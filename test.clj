#!/usr/bin/env bb

(require '[babashka.deps :as deps]
         '[babashka.fs :as fs]
         '[babashka.process :refer [process check]]
         '[cheshire.core :as json]
         '[clojure.tools.cli :refer [parse-opts]])

(deps/add-deps '{:deps {camel-snake-kebab/camel-snake-kebab {:mvn/version "0.4.2"}}})

(require '[camel-snake-kebab.core :as csk])

(def cli-options
  [["-u" "--update" "Create/update all results snapshots"]
   ["-f" "--fail-fast" "Exit after the first failed test"]
   ["-h" "--help"]])

(def opts
  (let [{:keys [options arguments errors summary]}
        (parse-opts *command-line-args* cli-options)]
    (cond
      (:help options) (do (println "Usage:" (fs/file-name *file*) "[options]" "[clojure-repo-path]")
                          (println "Options:")
                          (println summary)
                          (System/exit 0))
      errors (do (doall (map println errors))
                 (System/exit 1))
      :else (merge options {:clojure-repo-path (or (first arguments) "../clojure")}))))

(when-not (fs/directory? (:clojure-repo-path opts))
  (throw (IllegalArgumentException.
          "Please provide the path to your excercism/clojure repo")))

(defn get-exercises []
  (-> (fs/file (:clojure-repo-path opts) "config.json")
      slurp
      (json/parse-string true)
      :exercises
      (#(concat (:practice %) (:concept %)))))

(defn path-str [& parts]
  (-> (apply fs/path parts)
      fs/normalize
      str))

(defn exercise-path [{:keys [slug practices]}]
  (let [subdir (if practices "practice" "concept")]
    (path-str (:clojure-repo-path opts) "exercises" subdir slug)))

(defn example-subpath [{:keys [practices]}]
  (apply path-str ".meta" (if practices ["src" "example.clj"] ["exemplar.clj"])))

(defn src-subpath [{:keys [slug]}]
  (path-str "src" (str (csk/->snake_case slug) ".clj")))

(defn snapshot-path [{:keys [slug]} solved?]
  (let [filename (format "%s-%s.json" slug (if solved? "solved" "unsolved"))]
    (path-str *file* ".." ".." "results-snapshots" filename)))

(defn cp [src dest & opts]
  (println "Copying" (str src) "to" (str dest))
  (let [copy (if (fs/directory? src) fs/copy-tree fs/copy)]
    (apply copy src dest opts)))

(defn check-proc-inherit [& args]
  (check (process args {:inherit true})))

(def run-script
  (path-str *file* ".." ".." "bin" "run.sh"))

(defn update-snapshot [snapshot-file results-file]
  (fs/create-dirs (fs/parent snapshot-file))
  (check-proc-inherit
   "bash" "-c"
   (format "jq --sort-keys . \"%s\" > \"%s\"" results-file snapshot-file))
  true)

(defn compare-snapshot [snapshot-file actual-file]
  (if (fs/exists? snapshot-file)
    (let [cmd (format "diff <(jq --sort-keys . \"%s\") <(jq --sort-keys . \"%s\")"
                      snapshot-file actual-file)
          _ (println "comparing" actual-file "to" snapshot-file)
          {:keys [exit]} @(process ["bash" "-c" cmd] {:inherit true})]
      (if (zero? exit)
        (do (println "✅ TEST PASSED") true)
        (println "❌ TEST FAILED: results do not match snapshot")))
    (do (println "❌ TEST FAILED: snapshot file missing")
        (println "💬 Hint: run this script with the -u (--update) flag to create/update snapshots"))))

(defn run-test [{:keys [slug] :as exercise} path solved?]
  (check-proc-inherit run-script slug path path)
  (let [results-file (path-str path "results.json")
        {:keys [status] :as results} (-> results-file slurp (json/parse-string true))
        expected-status (if solved? "pass" "fail")
        snapshot-file (snapshot-path exercise solved?)]
    (if (= status expected-status)
      (if (:update opts)
        (update-snapshot snapshot-file results-file)
        (compare-snapshot snapshot-file results-file))
      (do (println (or (:message results) results))
          (println "❌ TEST FAILED: status should be" expected-status
                   "but instead it was" status)))))

(defn check-test [exercise path solved?]
  (let [passed? (run-test exercise path solved?)]
    (newline)
    (cond passed? 1
          (:fail-fast opts) (System/exit 1)
          :else 0)))

(defn apply-solution [exercise test-dir]
  (cp (fs/path test-dir (example-subpath exercise))
      (fs/path test-dir (src-subpath exercise))
      {:replace-existing true}))

(defn run-all-tests []
  (let [temp-dir (fs/create-temp-dir {:prefix "exercism-clojure-"})]
    (->> (for [{:keys [slug] :as ex} (get-exercises)]
           (let [test-dir (fs/path temp-dir slug)
                 _  (cp (exercise-path ex) test-dir)
                 t1 (check-test ex test-dir false)
                 _  (apply-solution ex test-dir)
                 t2 (check-test ex test-dir true)]
             {:total 2 :passed (+ t1 t2) :failed (- 2 t1 t2)}))
         (reduce #(merge-with + %1 %2) {:total 0 :passed 0 :failed 0}))))

(defn -main []
  (let [results (run-all-tests)]
    (prn results)
    (System/exit (:failed results))))

(when (= *file* (System/getProperty "babashka.file"))
  (-main))
