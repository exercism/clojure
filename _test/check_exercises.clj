(ns check-exercises
  (:require [cheshire.core :as json]
            [clojure.string :as string]
            [clojure.test :refer [deftest is run-tests successful?]]))

(defn- ->snake_case [s] (string/replace s \- \_))

(deftest check-exercises
  (doseq [problem ((json/parse-string (slurp "config.json")) "problems")
          :let [path-to-problem (partial str "exercises/" problem "/")
                problem-tests   (symbol (str problem "-test"))]]
    (load-file (path-to-problem "src/example.clj"))
    (load-file (path-to-problem "test/" (->snake_case problem) "_test.clj"))
    (is (successful? (run-tests problem-tests)))))
