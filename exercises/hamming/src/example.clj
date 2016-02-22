(ns hamming)

(defn distance [a b]
  (when (= (count a) (count b))
    (count (filter true? (map not= a b)))))
