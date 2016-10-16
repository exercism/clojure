(ns perfect-numbers)

(defn- get-divisors
  "Utility function to get the divisors of a number"
  [number]
  (for [n (range 1 (inc (quot number 2))) :when (zero? (mod number n))]
    n))

(defn classify [number]
  "Classifies a positive integer as deficient, abundant or perfect"
  (if-not (pos? number)
    (throw (IllegalArgumentException. "Only positive numbers can be classified."))
    (let [divisor-sum (apply + (get-divisors number))]
      (cond
        (> divisor-sum number) :abundant
        (< divisor-sum number) :deficient
        (= divisor-sum number) :perfect))))
