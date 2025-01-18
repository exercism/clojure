(ns killer-sudoku-helper)

(def digits (set (range 1 10)))

(defn combinations-of-size [coll size]
  (cond
    (zero? size) '(())
    (empty? coll) '()
    :else (concat (map (fn [x] (cons (first coll) x))
                       (combinations-of-size (rest coll) (dec size)))
                  (combinations-of-size (rest coll) size))))

(defn combinations [{:keys [sum size exclude]}]
  (let [valid-digits (apply disj digits exclude)]
    (sort
     (for [combination (combinations-of-size valid-digits size)
           :when (= sum (apply + combination))]
       (into [] (sort combination))))))
