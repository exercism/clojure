(ns perfect-numbers
  (:require [clojure.math :as math]))

(defn prime-factors-of
  [n]
  (loop [result []
         candidate 2
         n n]
    (cond
      (= n 1) (frequencies result)
      (> candidate (math/sqrt n)) (recur (conj result n) candidate 1)
      (zero? (mod n candidate))  (recur (conj result candidate) candidate (quot n candidate))
      :else (recur result (inc candidate) n))))

(defn generate-factor-powers
  [factor max-power]
  (for [power (range (inc max-power))]
    (reduce * (repeat power factor))))

(defn cartesian-product
  [& collections]
  (reduce (fn [acc coll]
            (for [a acc
                  b coll]
              (* a b)))
          [1] collections))

(defn generate-factors
  [n]
  (let [prime-factors (prime-factors-of n)]
    (->> prime-factors
         (or (seq prime-factors) [])
         (map #(generate-factor-powers (key %) (val %)))
         (apply cartesian-product))))

(defn classify
  [n]
  (let [sum (reduce + (disj (set (generate-factors n)) n))]
    (cond
      (> sum n) :abundant
      (= sum n) :perfect
      (< sum n) :deficient)))
