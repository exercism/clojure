(ns prime-factors)

(defn of
  [n]
  (loop [result []
         candidate 2
         n n]
    (if (= n 1)
      result
      (if (zero? (mod n candidate))
        (recur (conj result candidate) candidate (quot n candidate))
        (recur result (inc candidate) n)))))
