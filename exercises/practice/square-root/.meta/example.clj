(ns square-root)

(defn square-root
  "Calculates a number's square root"
  [n]
  (loop [i 1]
    (if (<= (* i i) n)
      (recur (inc i))
      (dec i))))
