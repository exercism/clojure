(ns atbash-cipher
  (:require [clojure.set]
            [clojure.string :as str]))

(def ^:private letters
  (map char
       (range (int \a) (inc (int \z)))))

(def ^:private to-cipher
  (apply hash-map
         (interleave letters (reverse letters))))

(def ^:private from-cipher
  (clojure.set/map-invert to-cipher))

(defn- sanitize
  [plaintext]
  (str/replace (str/lower-case plaintext) #"\W" ""))

(defn- remove-spaces
  [ciphertext]
  (str/replace ciphertext #" " ""))

(defn- cipher-char
  [plain-char]
  (or (to-cipher plain-char) plain-char))

(defn- plain-char
  [cipher-char]
  (or (from-cipher cipher-char) cipher-char))

(defn- to-chunks
  [character-list]
  (map #(apply str %) (partition 5 5 "" character-list)))

(defn encode
  [plaintext]
  (->> plaintext
       sanitize
       (map cipher-char)
       to-chunks
       (str/join " ")))

(defn decode
  [ciphertext]
  (->> ciphertext
       remove-spaces
       (map plain-char)
       (apply str)))
