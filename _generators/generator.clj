(ns generator
  (:require [cheshire.core :as json]
            [clojure.java.shell :refer [sh]]
            [clojure.java.io :refer [reader]]
            [stencil.core :as stencil])
  (:import (java.io File IOException)))

(defn file-exists?
  "Helper function to determine if a given file exists."
  [path]
  (.exists (File. path)))

(defn warn-and-exit
  "Wrapper function to warn with the given message and then exit with a non-zero return"
  [message]
  (println message)
  (System/exit 1))

(defn clone-test-data
  "Clone the x-common repo from github"
  []
  (sh "git" "clone" "git@github.com:exercism/x-common"))

(defn load-test-data
  "Clones and loads the test data for the given exercise"
  [exercise-name]
  (when-not (file-exists? "x-common")
    (clone-test-data))
  (let [test-data-filename (format "x-common/exercises/%s/canonical-data.json" exercise-name)]
    (when-not (file-exists? test-data-filename)
      (warn-and-exit
       (format "Could not find test data for %s (looking in %s)"
               exercise-name test-data-filename)))
    (json/parse-stream (reader test-data-filename))))

(defn munge-test-data
  "Loads the generator namespace for the exercise and calls the munge-data function on the given test-data."
  [exercise-name test-data]
  (let [exercise-ns (symbol (str exercise-name "-generator"))]
    (try
      (require [exercise-ns])
      (if-let [munge-data-fn (ns-resolve exercise-ns (symbol "munge-data"))]
        (munge-data-fn test-data)
        (do
          (println (format "No munge-data function defined in %s" exercise-ns))
          (println (format "Skipping any munging of canonical-data for %s" exercise-name))
          test-data))
      (catch IOException e
        (println (format "Could not require %s due to an exception:\n\t%s" exercise-ns (.getMessage e)))
        (println (format "Skipping any munging of canonical-data for %s" exercise-name))
        test-data))))

(defn generate-test-data
  "Munges the test-data and renders the test for the exercise using the test template."
  [exercise-name test-template-path test-data]
  (let [munged-test-data (munge-test-data exercise-name test-data)
        template (slurp test-template-path)]
    (spit
     (format "exercises/%s/test/%s_test.clj" exercise-name exercise-name)
     (stencil/render-string template munged-test-data))))

(defn -main
  "Uses the test template for the exercise and test data to generate test cases."
  [exercise-name & args]
  (let [test-template-path (format "exercises/%s/.meta/%s.mustache" exercise-name exercise-name)
        test-data (load-test-data exercise-name)]
    (if (file-exists? test-template-path)
      (do
        (generate-test-data exercise-name test-template-path test-data)
        (println (format "Generated tests for %s exercise using template %s" exercise-name test-template-path)))
      (warn-and-exit (format "No exercise test template found at '%s'" test-template-path))))
  (shutdown-agents))
