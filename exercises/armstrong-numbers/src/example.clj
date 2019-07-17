(ns armstrong-numbers)

(defn expt [base pow]
  (reduce * 1 (repeat pow base)))

(defn armstrong? [n]
  (let [digits (map (comp read-string str) (str n))
        l      (count digits)]
    (= n (reduce + (map #(expt % l) digits)))))
