(ns sieve)

(defn sieve
  "Returns a list of primes less than or equal to limit"
  [limit]
  (loop [current-sieve (concat [false false] (range 2 (inc limit)))
         last-prime 1]
    (let [current-prime (->> current-sieve
                             (drop (inc last-prime))
                             (some identity))]
      (if current-prime
        (recur (map #(and %1 %2)
                    (concat (repeat (inc current-prime) true)
                            (cycle (concat (repeat (dec current-prime) true)
                                           [false])))
                    current-sieve)
               current-prime)
        (filter identity current-sieve)))))
