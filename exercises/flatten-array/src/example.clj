(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten
  "Flattens the given list and removes any nil values"
  [coll]
  (loop
   [results nil
    [elem & remaining] coll]
    (if (or elem remaining)
      (if (coll? elem)
        (if (empty? elem)
          (recur results remaining)
          (recur results (conj remaining (rest elem) (first elem))))
        (recur (conj results elem) remaining))
      (reverse (remove nil? results)))))
