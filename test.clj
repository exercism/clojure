#!/usr/bin/env bb

(require
 '[babashka.classpath :as cp]
 '[cheshire.core :as json]
 '[clojure.string :as str]
 '[rewrite-clj.zip :as z]
 '[clojure.test :refer [deftest is run-tests successful? use-fixtures]])

(defn- ->snake_case [s] (str/replace s \- \_))

(deftest check-practice-exercises
  (doseq [exercise (((json/parse-string (slurp "config.json")) "exercises") "practice")
          :let [slug             (exercise "slug")
                path-to-exercise (partial str "exercises/practice/" slug "/")
                exercise-tests   (symbol (str slug "-test"))]]
    (load-file (path-to-exercise ".meta/src/example.clj"))
    (load-file (path-to-exercise "test/" (->snake_case slug) "_test.clj"))
(is (successful? (run-tests exercise-tests)))))

(deftest check-concept-exercises
  (doseq [exercise (((json/parse-string (slurp "config.json")) "exercises") "concept")
          :let [slug             (exercise "slug")
                path-to-exercise (partial str "exercises/concept/" slug "/")
                exercise-tests   (symbol (str slug "-test"))]]
    (load-file (path-to-exercise ".meta/exemplar.clj"))
    (load-file (path-to-exercise "test/" (->snake_case slug) "_test.clj"))
    (is (successful? (run-tests exercise-tests)))))

(let [report (run-tests)]
  (System/exit (+ (:fail report)
                  (:error report))))
