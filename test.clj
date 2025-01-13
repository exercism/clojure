#!/usr/bin/env bb

(require
 '[cheshire.core :as json]
 '[clojure.string :as str]
 '[clojure.java.shell :as shell]
 '[babashka.fs :as fs])

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
                  (str dir ".meta/example.clj")
                  (str dir ".meta/exemplar.clj"))
        src (str dir "src/" (->snake_case slug) ".clj")
        src-copy (str src ".bak")]
    (shell/sh "cp" src src-copy)
    (try
      (do
        (shell/sh "cp" example src)
        (= "pass" ((json/parse-string
                    (:out (shell/sh (str test-runner-dir "test-runner.clj")
                                    slug
                                    dir
                                    dir)))
                   "status")))
      (finally (shell/sh "mv" src-copy src)))))

(defn test-exercises! []
  (let [exercises (or (seq (take 1 *command-line-args*))
                      (into practice-exercises concept-exercises))]
    (for [exercise exercises]
      {(keyword exercise) (test-exercise exercise)})))

(let [results (test-exercises!)
      fails (filter #(false? (first (vals %))) results)]
  (prn {:tested (count results)
        :fails fails})
  (System/exit (count fails)))
