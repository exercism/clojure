(ns templates
  (:require [selmer.parser :as selmer]
            [log]
            [paths]))

(defn render [slug test-cases]
  (let [data {:slug slug :test_cases test-cases}
        template-file (paths/generator-template-file slug)
        tests-file (paths/tests-file slug)]
    (->> data
         (selmer/render (slurp template-file))
         (spit tests-file))))

(templates/render "isogram" (canonical-data/test-cases "isogram"))