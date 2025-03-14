(ns nth-prime
  (:require [clojure.math :as math]))

(defn- prime?
  "Returns true if N is prime. This will happen if N is a not multiple
  of any number in the given vector of primes."
  [N primes]
  (let [sqrt-N (math/sqrt N)]
    (reduce (fn [result prime]
              (if (> prime sqrt-N)
                (reduced true)
                (if (= 0 (mod N prime))
                  (reduced false)
                  result)))
            true
            primes)))

(defn- add-next-prime
  "Adds the next prime to the given vector of all previous primes."
  [primes]
  (let [n (inc (peek primes))]
    (loop [n n]
      (if (prime? n primes)
        (conj primes n)
        (recur (inc n))))))

(defn- gen-primes-seq
  "Returns a lazy sequence of primes."
  ([]
   (gen-primes-seq [2]))
  ([primes]
   (lazy-seq
     (cons (peek primes) (gen-primes-seq (add-next-prime primes))))))

(def primes-seq (gen-primes-seq))

(defn nth-prime
  [n]
  (nth primes-seq (dec n)))
