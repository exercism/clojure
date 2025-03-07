(ns binary-search-generator
  (:require [clojure.string :as str]))

(defn update-description [description]
  (-> description
      (str/replace #"an array" "a vector")
      (str/replace #"array" "vector")))

(defn update-test-case [test-case]
  (->> (:description test-case)
       update-description
       (assoc test-case :context)))
