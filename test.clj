#!/usr/bin/env bb

(require
 '[cheshire.core :as json]
 '[clojure.string :as str]
 '[clojure.java.shell :as shell]
 '[clojure.java.io :as io])

(def root (str (fs/parent *file*) "/"))

(def test-runner-dir (str (fs/parent *file*) "/"))

(defn- ->snake_case [s] (str/replace s \- \_))

(def practice-exercises
  (map #(% "slug")
       (-> (str root "config.json")
           slurp
           json/parse-string
           (get "exercises")
           (get "practice"))))

(def concept-exercises
  (map #(% "slug")
       (-> (str root "config.json")
           slurp
           json/parse-string
           (get "exercises")
           (get "concept"))))

(defn test-exercise [slug]
  (let [practice? (contains? (set practice-exercises) slug)
        example (if practice?
                  (str root "exercises/practice/" slug "/.meta/src/example.clj")
                  (str root "exercises/concept/" slug "/.meta/exemplar.clj"))
        src (if practice?
              (str root "exercises/practice/" slug "/src/" (->snake_case slug) ".clj")
              (str root "exercises/concept/" slug "/src/" (->snake_case slug) ".clj"))]
    (shell/sh "cp" example src)
    (= "pass" ((json/parse-string
                (:out (shell/sh (str test-runner-dir "test-runner.clj")
                                slug
                                (str root (if practice? "exercises/practice/" "exercises/concept/") slug "/")
                                (str root (if practice? "exercises/practice/" "exercises/concept/") slug "/"))))
               "status"))))

(defn test-exercises! []
  (for [exercise (into practice-exercises concept-exercises)]
    {(keyword exercise) (test-exercise exercise)}))

(let [results (test-exercises!)
      fails (filter #(false? (first (vals %))) results)]
  (prn {:tested (count results)
        :fails fails})
  (System/exit (count fails)))
