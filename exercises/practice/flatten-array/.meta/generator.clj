(ns flatten-array-generator
  (:require [clojure.string :as str]))

(defn update-description [description]
  (-> description
      (str/replace #"null" "nil")
      (str/replace #"array" "vector")))

(defn update-test-case [test-case]
  (->> (:description test-case)
       update-description
       (assoc test-case :context)))
