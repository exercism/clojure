(ns hamming)

(defn distance [a b]
  (if (= (count a) (count b))
    (count (filter true? (map not= a b)))
    (throw (IllegalArgumentException. "strands must be of equal length"))))
