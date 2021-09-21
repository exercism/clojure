(ns dominoes)

(defn next-stones [n ds]
  (for [i (range (count ds))
        :let [[l [[a b] & r]] (split-at i ds)
              m (cond (= a n) b (= b n) a)]
        :when m]
    [m (concat l r)]))

(defn chain-end [b ds]
  (some (fn [[b ds]]
          (if (empty? ds) b (chain-end b ds)))
        (next-stones b ds)))

(defn can-chain? [[[a b] & ds]]
  (cond (nil? a) true
        (nil? ds) (= a b)
        :else (= a (chain-end b (vec ds)))))