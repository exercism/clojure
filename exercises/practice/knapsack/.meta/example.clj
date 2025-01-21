(ns knapsack)

(defn maximum-value [maximum-weight items]
  (if (empty? items)
    0
    (max
     (if (<= (:weight (first items)) maximum-weight)
       (+
        (:value (first items))
        (maximum-value (- maximum-weight (:weight (first items))) (rest items)))
       0)
     (maximum-value maximum-weight (rest items)))))
