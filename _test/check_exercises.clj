(ns check-exercises
  (:require [cheshire.core :as json]
            [clojure.string :as string]
            [clojure.test :refer [deftest is run-tests successful?]]))

(defn- ->snake_case [s] (string/replace s \- \_))

(deftest check-practice-exercises
  (doseq [exercise (((json/parse-string (slurp "config.json")) "exercises") "practice")
          :let [slug             (exercise "slug")
                path-to-exercise (partial str "exercises/practice/" slug "/")
                exercise-tests   (symbol (str slug "-test"))]]
    (load-file (path-to-exercise ".meta/src/example.clj"))
    (load-file (path-to-exercise "test/" (->snake_case slug) "_test.clj"))
    (is (successful? (run-tests exercise-tests)))))
