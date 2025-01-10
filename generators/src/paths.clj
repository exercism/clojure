(ns paths
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def generators-dir (.getCanonicalPath (io/file *file* ".." "..")))
(def root-dir (.getCanonicalPath (io/file generators-dir "..")))
(def prob-specs-dir (io/file generators-dir ".problem-specifications"))
(def exercises-dir (io/file root-dir "exercises" "practice"))
(defn exercise-dir [slug] (io/file exercises-dir slug))
(defn canonical-data-file [slug] (io/file prob-specs-dir "exercises" slug "canonical-data.json"))
(defn tests-toml-file [slug] (io/file (exercise-dir slug) ".meta" "tests.toml"))
(defn generator-template-file [slug] (io/file (exercise-dir slug) ".meta" "generator.template"))
(defn tests-file-name [slug] (str (str/replace slug "-" "_") "_test.clj"))
(defn tests-file [slug] (io/file (exercise-dir slug) "test" (tests-file-name slug)))
