(ns templates
  (:require [hbs.core :as hbs]
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
  (let [template (slurp (paths/generator-template-file slug))
        data {:test_cases test-cases}]
    (->> (hbs/render template data)
         (spit (paths/tests-file slug)))))
