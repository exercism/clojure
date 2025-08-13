(ns perfect-numbers
  (:require [clojure.math :as math]))

(defn prime-factors-of
  [num]
  (loop [result []
         candidate 2
         n num]
    (cond
      (= n 1) (frequencies result)
      (> candidate (math/sqrt n)) (recur (conj result n) candidate 1)
      (zero? (mod n candidate))  (recur (conj result candidate) candidate (quot n candidate))
      :else (recur result (inc candidate) n))))

(defn powers-of
  [num max-power]
  (for [power (range (inc max-power))]
    (reduce * (repeat power num))))

(defn cartesian-product
  [& collections]
  (reduce (fn [acc coll]
            (for [a acc
                  b coll]
              (* a b)))
          [1] collections))

(defn factors-of
  [num]
  (->> (prime-factors-of num)
       (map #(powers-of (first %) (second %)))
       (apply cartesian-product)))

(defn aliquot-sum
  [num]
  (reduce + (disj (set (factors-of num)) num)))

(defn classify
  [num]
  (let [sum (aliquot-sum num)]
    (cond
      (> sum num) :abundant
      (= sum num) :perfect
      (< sum num) :deficient)))
