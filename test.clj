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
        type (if practice? "practice" "concept")
        dir (str root "exercises/" type "/" slug "/")
        example (if practice?
                  (str dir ".meta/src/example.clj")
                  (str dir ".meta/exemplar.clj"))
        src (str dir "src/" (->snake_case slug) ".clj")]
    (shell/sh "cp" example src)
    (= "pass" ((json/parse-string
                (:out (shell/sh (str test-runner-dir "test-runner.clj")
                                slug
                                dir
                                dir)))
               "status"))))

(defn test-exercises! []
  (for [exercise (into practice-exercises concept-exercises)]
    {(keyword exercise) (test-exercise exercise)}))

(let [results (test-exercises!)
      fails (filter #(false? (first (vals %))) results)]
  (prn {:tested (count results)
        :fails fails})
  (System/exit (count fails)))
