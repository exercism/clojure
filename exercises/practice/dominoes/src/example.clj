(ns dominoes)

(defn rm [xs x]
  (let [i (.indexOf xs x)]
    (if (= -1 i) xs (vec (concat (take i xs) (drop (inc i) xs))))))

(defn connects [[a b] [c d]]
  (cond (= b c) [c d]
        (= b d) [d c]
        :else   nil))

(defn backtrack [rem chain]
  (or (and (empty? rem) (= (ffirst chain) (second (peek chain))))
      (and (not (empty? rem))
           (some #(let [c (connects (peek chain) %)]
                    (and c (backtrack (rm rem %) (conj chain c))))
                 rem))))

(defn can-chain? [xs]
  (or (empty? xs) (some #(backtrack (rm xs %) [%]) xs)))
