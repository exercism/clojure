(ns templates
  (:require [hbs.core :as hbs]
            [clojure.string :as str]
            [log]
            [paths]))

(def exercises-with-template
  (->> paths/exercises-dir
       (file-seq)
       (filter #(.isFile %))
       (filter #(= "generator.template" (.getName %)))
       (map #(-> % (.getParentFile) (.getParentFile) (.getName)))
       (set)))

(defn- test-case->data [idx node]
  (-> node
      (assoc :idx (inc idx)
             :description (str/join " - " (:path node))
             :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn- test-cases->data [test-cases]
  (let [test-cases-by-property (update-vals (group-by :property test-cases) #(map-indexed test-case->data %))]
    {:test_cases (reduce concat (vals test-cases-by-property))
     :test_cases_by_property test-cases-by-property}))

(defn generate-test-files [slug test-cases]
  (let [template (slurp (paths/generator-template-file slug))
        data (test-cases->data test-cases)]
    (->> (hbs/render template data)
         (spit (paths/tests-file slug)))))
