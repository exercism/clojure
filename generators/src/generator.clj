(ns generator)

(require
 '[clojure.data.json :as json]
 '[clojure.java.shell :refer [sh]]
 '[clojure.java.io :as io]
 '[selmer.parser :refer [render render-file]]
 '[toml-clj.core :as toml])

(defn error [message]
  (println message)
  (System/exit 1))

(def root-dir (.getCanonicalPath (io/file *file* ".." ".." "..")))
(def prob-specs-dir (io/file root-dir ".problem-specifications"))
(defn exercise-dir [slug] (io/file root-dir "exercises" "practice" slug))

(defn sync-prob-specs []
  (if (.isDirectory prob-specs-dir)
    (sh "git" "pull" :dir prob-specs-dir)
    (sh "git" "clone" "https://github.com/exercism/problem-specifications.git" prob-specs-dir)))

(defn canonical-data-file [slug] (io/file prob-specs-dir "exercises" slug "canonical-data.json"))
(defn canonical-data [slug]
  (let [file (canonical-data-file slug)]
    (if (.exists file)
      (json/read (io/reader file) :key-fn keyword)
      (error (str "No canonical-data.json found for exercise '" slug "'")))))

(defn tests-toml-file [slug] (io/file (exercise-dir slug) ".meta" "tests.toml"))
(defn excluded-uuids [slug]
  (let [file (tests-toml-file slug)]
    (if (.exists file)
      (->> file
           (io/reader)
           (toml/read)
           (filter #(= false (get (last %) "include")))
           (map first)
           (set))
      (error (str "No tests.toml data found for exercise '" slug "'")))))

(defn excluded? [slug]
  (let [excluded (excluded-uuids slug)]
    (fn [node] (contains? excluded (:uuid node)))))

(defn node->test-case [node path]
  (-> node
      (assoc :path path :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn test-case-nodes
  ([node] (test-case-nodes node []))
  ([node path]
   (let [description (:description node)
         children (:cases node)
         updated-path (if description (conj path description) path)]
     (if children
       (mapcat #(test-case-nodes % updated-path) children)
       [(node->test-case node updated-path)]))))

(defn test-cases [slug]
  (->> slug
       (canonical-data)
       (test-case-nodes)
       (remove (excluded? slug))
       (into [])))

(sync-prob-specs)
(test-cases "isogram")

(def data {:slug "isogram"
           :cases (cases (canonical-data "isogram"))})

(def template "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.template")
(def tests "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.clj")

(def toml-file "/home/erik/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.toml")

(spit tests (render (slurp template) data))
(def t (toml/read (io/reader toml-file)))
(set (map first (filter #(not= false (get (last %) "include")) t)))

(.getAbsolutePath (io/file *file* ".." ".."))
(.getCanonicalPath (io/file *file* ".." ".." ".."))