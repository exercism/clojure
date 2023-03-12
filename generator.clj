#!/usr/bin/env bb

(require '[cheshire.core :as json]
         '[babashka.fs :as fs]
         '[clojure.string :as str])

(comment
  (def slug "zipper"))

(def data
  (let [url "https://raw.githubusercontent.com/exercism/problem-specifications/main/exercises/"]
    {:canonical-data (json/parse-string (slurp (str url "/" slug "/canonical-data.json")) true)
     :description (slurp (str url "/" slug "/description.md"))
     :metadata (slurp (str url "/" slug "/metadata.toml"))}))

(second
 (str/split (:metadata data) #"="))

(defn get-meta 
  "Returns a vector containing the exercise title and blurb"
  [data]
  (mapv last
       (map #(map str/trim (str/split % #"="))
            (str/split-lines (:metadata data)))))

(defn init-deps [data]
  (fs/create-dirs (fs/path "exercises" "practice"
                           (:exercise (:canonical-data data)) "src"))
  (spit (str (fs/file "exercises" "practice"
                      (:exercise (:canonical-data data))
                      "deps.edn"))
        "{:aliases {:test {:extra-paths [\"test\"]
                 :extra-deps {io.github.cognitect-labs/test-runner 
                              {:git/url \"https://github.com/cognitect-labs/test-runner.git\"
                               :sha \"705ad25bbf0228b1c38d0244a36001c2987d7337\"}}
                 :main-opts [\"-m\" \"cognitect.test-runner\"]
                 :exec-fn cognitect.test-runner.api/test}}}"))

(defn init-lein [data]
  (let [slug (:exercise (:canonical-data data))]
    (spit (str (fs/file "exercises" "practice"
                        (:exercise (:canonical-data data)) "project.clj"))
          (str "(defproject " slug " \"0.1.0-SNAPSHOT\"
  :description \"" slug " exercise.\"
  :url \"https://github.com/exercism/clojure/tree/master/exercises/" slug "\"
  :dependencies [[org.clojure/clojure \"1.10.0\"]])
"))))

(defn test-ns-form [data]
  (str "(ns " (:exercise data) "-test
  (:require [clojure.test :refer [deftest testing is]]\n             "
       (:exercise data) "))\n\n"))

(defn src-ns-form [data]
  (str "(ns " (:exercise data) ")\n\n"))

(defn testing-form [slug test-case]
  (let [property (symbol (str slug "/" (:property test-case)))
        input (:input test-case)
        args (map #(get input %) (keys input))]
    (str "  (testing \"" (:description test-case) "\"
     (is (= " (:expected test-case) " "
         (reverse (into (list property) args)) ")))")))

(defn zipper-generator [slug test-case]
  (let [input (:input test-case)
        ops (for [op (:operations input)]
              (if (contains? op :item)
                (str "(zipper/" (:operation op) " "
                     (if (nil? (:item op))
                       "nil"
                       (str (:item op))) ")")
                (str "zipper/" (:operation op))))]
    (str "  (testing \"" (:description test-case) "\"
     (is (= " (if (nil? (:value (:expected test-case)))
                "nil" (:value (:expected test-case))) " "
         "\n         (-> " (:initialTree input) "\n           "
         (apply str (interpose "\n           " ops)) "))))")))

(defn testing-forms
  "Outputs a sequence of the test cases for a given property name
   given its name as a string and the canonical data."
  [property data]
  (let [test-cases (filter #(= property (:property %)) (:cases data))]
    (map #(zipper-generator (:exercise data) %) test-cases)))

(defn deftest-forms [data]
  (for [property (distinct (map :property (:cases (:canonical-data data))))]
    (str "(deftest " property "-test\n"
         (apply str (interpose "\n"
                               (testing-forms property (:canonical-data data))))
         ")")))

(defn init-tests [data]
  #_(fs/create-dir (fs/path "exercises" "practice"
                            (:exercise (:canonical-data data)) "test"))
  (spit (str (fs/file "exercises" "practice"
                      (:exercise (:canonical-data data)) "test"
                      (str (str/replace (:exercise (:canonical-data data)) "-" "_")
                           "_test.clj")))
        (str (test-ns-form (:canonical-data data))
             (apply str (interpose "\n\n"
                                   (deftest-forms data))))))

(defn init-src [data]
  (spit (str (fs/file "exercises" "practice" (:exercise (:canonical-data data)) "src"
                      (str (str/replace (:exercise (:canonical-data data))
                                        "-" "_") ".clj")))
        (str (src-ns-form (:canonical-data data))
             (apply str (interpose "\n\n"
                                   (for [property (distinct (map :property (:cases (:canonical-data data))))]
                                     (str "(defn " property " []\n  )")))))))

(defn init-description! [data]
  (let [path ["exercises" "practice" (:exercise (:canonical-data data)) ".docs"]]
    (when-not (fs/directory? (apply fs/path path))
      (fs/create-dir (apply fs/path path))
      (spit (str (apply fs/file (conj path "instructions.md")))
            (:description data)))))

(defn config [data author blurb]
  (let [slug (:exercise (:canonical-data data))]
    {:authors [author],
     :contributors [],
     :files {:solution [(str "src/" (str/replace slug "-" "_") ".clj")], 
             :test [(str "test/" (str/replace slug "-" "_") "_test.clj")], 
             :example [".meta/src/example.clj"]},
     :blurb blurb}))

(defn init-config! [data]
  (let [path ["exercises" "practice" (:exercise (:canonical-data data)) ".meta"]]
    (when-not (fs/directory? (apply fs/path path))
   (fs/create-dirs (apply fs/path (conj path "src")))
      (spit (str (apply fs/file (conj path "config.json")))
            (json/generate-string (config data "porkostomus" (last (get-meta data)))
                                  {:pretty true})))))

(comment
  (init-config! data)
  )