(ns generator
  (:require [cheshire.core :as json]
            [babashka.fs :as fs]
            [clojure.string :as str]))

(def data
  (json/parse-string (slurp "canonical_data.json") true))

(defn init-deps [data]
  (fs/create-dirs (fs/path "exercises" "practice" 
                          (:exercise data) "src"))
  (spit (str (fs/file "exercises" "practice" 
                      (:exercise data)
                 "deps.edn"))
   "{:aliases {:test {:extra-paths [\"test\"]
                 :extra-deps {io.github.cognitect-labs/test-runner 
                              {:git/url \"https://github.com/cognitect-labs/test-runner.git\"
                               :sha \"705ad25bbf0228b1c38d0244a36001c2987d7337\"}}
                 :main-opts [\"-m\" \"cognitect.test-runner\"]
                 :exec-fn cognitect.test-runner.api/test}}}"))

(defn init-lein [data]
  (let [slug (:exercise data)]
  (spit (str (fs/file "exercises" "practice"
                      (:exercise data) "project.clj"))
        (str "(defproject " slug " \"0.1.0-SNAPSHOT\"
  :description \"" slug " exercise.\"
  :url \"https://github.com/exercism/clojure/tree/master/exercises/" slug "\"
  :dependencies [[org.clojure/clojure \"1.10.0\"]])
"))))

(defn test-ns-form [data]
  (str "(ns " (:exercise data) "-test
  (:require [clojure.test :refer [deftest testing is]]\n             "
            (:exercise data) "))\n\n"))

(defn testing-form [slug test-case]
  (let [property (symbol (str slug "/" (:property test-case)))
        input (:input test-case)
        args (map #(get input %) (keys input))]
    (str "  (testing \"" (:description test-case) "\"
     (is (= " (:expected test-case) " "
         (reverse (into (list property) args)) ")))")))

(defn testing-forms 
  "Outputs a sequence of the test cases for a given property name
   given its name as a string and the canonical data."
  [property data]
  (let [test-cases (filter #(= property (:property %)) (:cases data))]
    (map #(testing-form (:exercise data) %) test-cases)))

(defn deftest-forms [data]
  (for [property (distinct (map :property (:cases data)))]
    (str "(deftest " property "-test\n"
          (apply str (interpose "\n"
                         (testing-forms property data)))
         ")")))

(defn init-tests [data]
  (fs/create-dir (fs/path "exercises" "practice"
                          (:exercise data) "test"))
  (spit (fs/file "exercises" "practice" 
                 (:exercise data) "test"
                 (str (str/replace (:exercise data) "-" "_")
                      "_test.clj"))
        (str (test-ns-form data)
             (apply str (interpose "\n\n"
                                   (deftest-forms data))))))
