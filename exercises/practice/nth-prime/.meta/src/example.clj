(ns nth-prime)

(defn sqrt
  "Wrapper around java's sqrt method."
  [number]
  (int (Math/ceil (Math/sqrt number))))

(defn divides?
  "Helper function to decide if a number is evenly divided by divisor."
  [number divisor]
  (zero? (mod number divisor)))

(defn- prime-by-trial-division?
  "Simple trial division prime check."
  [number]
  (empty? (for [n (range 3 (inc (sqrt number)) 2) :when (divides? number n)] n)))

(defn prime? [number]
  (or (= 2 number)
      (and (odd? number) (prime-by-trial-division? number))))

(defn next-prime [start]
  (loop [n (inc start)]
    (if (prime? n)
      n
      (recur (inc n)))))

(def primes (iterate next-prime 1))

(defn nth-prime [index]
  (when-not (pos? index)
    (throw (IllegalArgumentException. "nth-prime expects a positive integer for an argument")))
  (nth primes index))
