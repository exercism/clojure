(ns series)

(defn slices [s n]
  (cond
    (= "" s) (throw (IllegalArgumentException. "series cannot be empty"))
    (zero? n) (throw (IllegalArgumentException. "slice length cannot be zero"))
    (neg? n) (throw (IllegalArgumentException. "slice length cannot be negative"))
    (> n (.length s)) (throw (IllegalArgumentException. "slice length cannot be greater than series length")))
  (->> s
       (partition n 1)
       (map #(apply str %))))
