(ns templates
  (:require [selmer.parser :as selmer]
            [log]
            [paths]))

(def exercises-with-template
  (->> paths/exercises-dir
       (file-seq)
       (filter #(.isFile %))
       (filter #(= "generator.template" (.getName %)))
       (map #(-> % (.getParentFile) (.getParentFile) (.getName)))
       (set)))

(defn- render-template [data template]
  (selmer/render (slurp template) data))

(defn- render [slug test-cases]
  (let [data {:slug slug :test_cases test-cases}]
    (render-template data (paths/generator-template-file slug))))

(defn generate-tests-file [slug test-cases]
  (->> test-cases
       (render slug)
       (spit (paths/tests-file slug))))
