(ns trinary)

(defn to-decimal [num]
  (loop [sum 0, num num]
    (if (empty? num)
      sum
      (let [diff (.compareTo (first num) \0)]
        (if (<= 0 diff 2)
          (recur (+ (* sum 3) diff) (next num))
          0)))))
