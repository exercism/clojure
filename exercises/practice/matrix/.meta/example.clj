(ns matrix
  (:require [clojure.string :as str]))

(defn get-row
  "Returns the i-th row of the matrix s"
  [s i]
  (let [lines (str/split-lines s)
        row (str/split (get lines (dec i)) #" ")]
    (map #(Integer/parseInt %) row)))

(defn get-column
  "Returns the i-th column of the matrix s"
  [s i]
  (let [lines (str/split-lines s)
        matrix (map #(str/split % #" ") lines)
        column (map #(get % (dec i)) matrix)]
    (map #(Integer/parseInt %) column)))
