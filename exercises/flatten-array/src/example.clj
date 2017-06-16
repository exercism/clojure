(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten [s]
  (->> s
       (tree-seq sequential? seq)
       rest
       (remove sequential?)
       (remove nil?)))
