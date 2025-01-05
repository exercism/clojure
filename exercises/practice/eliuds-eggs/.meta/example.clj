(ns eliuds-eggs)

(defn egg-count [number]
  (loop [value number acc 0]
    (if (= 0 value)
      acc
      (recur (quot value 2) (+ acc (rem value 2))))))