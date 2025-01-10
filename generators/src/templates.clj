(ns templates
  (:require [pogonos.core :as pg]
            [pogonos.output :as output]
            [log]
            [paths]))

(def exercises-with-template
  (->> paths/exercises-dir
       (file-seq)
       (filter #(.isFile %))
       (filter #(= "generator.template" (.getName %)))
       (map #(-> % (.getParentFile) (.getParentFile) (.getName)))
       (set)))

(defn generate-tests-file [slug test-cases]
  (pg/render-file
   (paths/generator-template-file slug)
   {:test_cases test-cases}
   {:output (output/to-file (paths/tests-file slug))}))
