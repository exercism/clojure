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
  (cond
    (= 2 number) true
    (even? number) false
    :else (prime-by-trial-division? number)))

(defn next-prime [start]
  (loop [n (inc start)]
    (if (prime? n)
      n
      (recur (inc n)))))

(defn nth-prime [index]
  (when (not (pos? index))
    (throw (IllegalArgumentException. "nth-prime expects a positive integer for an argument")))
  (loop [cur-prime 2
         num-times 1]
    (if (= num-times index)
      cur-prime
      (recur (next-prime cur-prime) (inc num-times)))))
