#!/usr/bin/env bb

(require
 '[cheshire.core :as json]
 '[clojure.string :as str]
 '[babashka.classpath :as cp]
 '[clojure.java.shell :as shell])

(defn- ->snake_case [s] (str/replace s \- \_))

(def root-dir "/github/workspace/main/")
(def test-runner-dir "/github/workspace/clojure-test-runner/")

(cp/add-classpath root-dir)

(def practice-root (str root-dir "exercises/practice/"))
(def concept-root (str root-dir "exercises/concept/"))

(defn copy-practice-example! [slug]
  (shell/sh "cp"
            (str practice-root slug "/.meta/src/example.clj")
            (str practice-root slug "/.meta/src/" (->snake_case slug) ".clj")))

(defn replace-practice-example! [slug]
  (shell/sh "mv"
            (str practice-root slug "/.meta/src/" (->snake_case slug) ".clj")
            (str practice-root slug "/src/" (->snake_case slug) ".clj")))

(defn practice-pass? [slug]
  (let [copy (copy-practice-example! slug)
        replace (replace-practice-example! slug)]
    (= "pass" ((json/parse-string
                (:out (shell/sh (str test-runner-dir "test-runner.clj")
                                slug
                                (str practice-root slug "/")
                                (str practice-root slug "/"))))
               "status"))))

(defn copy-concept-example! [slug]
  (shell/sh "cp"
            (str concept-root slug "/.meta/exemplar.clj")
            (str concept-root slug "/.meta/" (->snake_case slug) ".clj")))

(defn replace-concept-example! [slug]
  (shell/sh "mv"
            (str concept-root slug "/.meta/" (->snake_case slug) ".clj")
            (str concept-root slug "/src/" (->snake_case slug) ".clj")))

(defn concept-pass? [slug]
  (let [copy (copy-concept-example! slug)
        replace (replace-concept-example! slug)]
    (= "pass" ((json/parse-string
                (:out (shell/sh (str test-runner-dir "test-runner.clj")
                                slug
                                (str concept-root slug "/")
                                (str concept-root slug "/"))))
               "status"))))

(def practice-exercises
  (map #(% "slug") (((json/parse-string (slurp (str root-dir "config.json"))) "exercises") "practice")))

(def concept-exercises
  (map #(% "slug") (((json/parse-string (slurp (str root-dir "config.json"))) "exercises") "concept")))

(defn check-practice-exercises! []
  (for [exercise practice-exercises]
    {(keyword exercise) (practice-pass? exercise)}))

(defn check-concept-exercises! []
  (for [exercise concept-exercises]
    {(keyword exercise) (concept-pass? exercise)}))

(let [results (into (check-concept-exercises!)
                    (check-practice-exercises!))
      fails (filter false? results)]
  (prn {:tested (count results)
        :fails fails})
  (System/exit (count fails)))
