(ns collatz-conjecture)

(defn collatz [n]
  (when (> n 0)
    (loop [t 0 n n]
      (cond (= 1 n)   t
            (even? n) (recur (inc t) (/ n 2))
            :else     (recur (inc t) (inc (* 3 n)))))))
