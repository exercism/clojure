(ns change)

(defn issue
  "Outputs the fewest number of coins that add up to a given sum."
  [sum coins]
  (when (or (neg? sum) (and (pos? sum) (every? #(< sum %) coins)))
    (throw (IllegalArgumentException. "cannot change")))
  (let [coins (sort coins)
        all-amounts (reduce (fn [cached-amounts amount]
                              (->> coins
                                   (filter #(<= % amount))
                                   (map #(conj (cached-amounts (- amount %) []) %))
                                   (apply min-key count)
                                   (assoc cached-amounts amount)))
                            {} (range 1 (inc sum)))]
    (all-amounts sum)))
