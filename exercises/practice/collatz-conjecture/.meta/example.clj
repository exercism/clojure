(ns collatz-conjecture)

(defn collatz-helper [n]
  (cond (= 1 n)   1
        (even? n) (/ n 2)
        :else     (inc (* 3 n))))

(defn collatz [n]
  (if (> n 0)
    (count (take-while #(not= 1 %)
                       (iterate collatz-helper n)))
    (throw (IllegalArgumentException.
            "Just defined for numbers greater than 0."))))
