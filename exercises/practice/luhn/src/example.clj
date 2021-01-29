(ns luhn
  (:require [clojure.string :as string]))

(defn to-reversed-digits
  "returns a lazy sequence of least to most significant digits of n"
  [n]
  (->> [n 0]
       (iterate (fn [[i _]] [(quot i 10) (mod i 10)]))
       (take-while (complement #{[0 0]}))
       (map second)
       rest))

(defn checksum
  "returns the luhn checksum of n, assuming it has a check digit"
  [n]
  (-> (->> n
           to-reversed-digits
           (map * (cycle [1 2]))
           (map #(if (>= % 10) (- % 9) %))
           (apply +))
      (mod 10)))

(defn string->long
  "Strips any non-digit characters and converts the string into a Long"
  [n]
  (-> n (string/replace #"[^0-9]+" "") Long/parseLong))

(defn valid?
  "whether n has a valid luhn check-digit"
  [n]
  ; Numbers with non digit/whitespace or only 1 digit are invalid
  (if (or (re-find #"[^0-9\s]+" n) (>= 1 (count (string/trim n))))
    false
    (zero? (-> n string->long checksum))))
