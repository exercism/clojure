(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten
  "Flattens the given list and removes any nil values"
  [coll]
  (cond
    (empty? coll) (list)
    (nil? (first coll)) (flatten (rest coll))
    (coll? (first coll)) (concat (flatten (first coll)) (flatten (rest coll)))
    :else (cons (first coll) (flatten (rest coll)))))
