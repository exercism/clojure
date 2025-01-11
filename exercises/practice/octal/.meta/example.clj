(ns octal)

(defn to-decimal [num]
  (loop [sum 0, num num]
    (if (empty? num)
      sum
      (let [diff (.compareTo (first num) \0)]
        (if (<= 0 diff 7)
          (recur (+ (* sum 8) diff) (next num))
          0)))))