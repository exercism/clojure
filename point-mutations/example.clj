(ns point-mutations
  (:require [clojure.string :refer [split]]))

(defn- nucleotides
  [strand]
  (rest (split strand #"")))

(defn- matching?
  [pair]
  (= (first pair) (last pair)))

(defn hamming-distance
  [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (->> (map vector (nucleotides strand1) (nucleotides strand2))
         (remove #(matching? %1))
         count)
    nil))
