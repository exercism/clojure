(ns armstrong-numbers)

(defn armstrong? [n]
  (let [digits (map (comp read-string str) (str n))
        l      (count digits)]
    (== n (reduce + (map #(Math/pow % l) digits)))))
