(ns crypto-square
  (:require [clojure.string :as str]))

(defn normalize-plaintext [plaintext]
  (str/lower-case (str/replace plaintext #"[^\w]" "")))

(defn square-size [plaintext]
  (int (Math/ceil (Math/sqrt (count (normalize-plaintext plaintext))))))

(defn plaintext-segments [plaintext]
  (let [normalized-plaintext (normalize-plaintext plaintext)
        size (square-size normalized-plaintext)]
    (map #(apply str %) (partition size size nil normalized-plaintext))))

(defn- padded-segments [plaintext pad]
  (let [segments (plaintext-segments plaintext)
        r (count (first segments))]
        (map #(concat % (take (- r (count %)) (repeat pad))) segments)))

(defn ciphertext [plaintext]
  (apply str (apply mapcat vector (padded-segments plaintext nil))))

(defn normalize-ciphertext [plaintext]
  (str/join " " (map #(apply str %) (apply map vector (padded-segments plaintext \ )))))
