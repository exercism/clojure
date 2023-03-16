(ns pig-latin
  (:require [clojure.string :as str]))

(defn- starts-with-any [prefixes word]
  (some (partial str/starts-with? word) prefixes))

(defn- starts-with-vowel-like? [word]
  (starts-with-any #{"yt" "xr"} word))

(defn- starts-with-vowel? [word]
  (starts-with-any #{"a" "e" "i" "o" "u"} word))

(defn- starts-with-two-letter-prefix? [word]
  (starts-with-any #{"ch" "qu" "th" "rh"} word))

(defn- starts-with-three-letter-prefix? [word]
  (starts-with-any #{"thr" "sch"} word))

(defn- starts-with-qu-and-preceding-consonant? [word]
  (and (not (starts-with-vowel? word))
       (str/starts-with? (subs word 1) "qu")))

(defn- rotate [word n]
  (str (subs word n) (subs word 0 n)))

(defn- append-ay [word]
  (str word "ay"))

(defn- translate-word [word]
  (cond
    (or (starts-with-vowel? word)
        (starts-with-vowel-like? word))
    (append-ay word)

    (or
     (starts-with-three-letter-prefix? word)
     (starts-with-qu-and-preceding-consonant? word))
    (append-ay (rotate word 3))

    (starts-with-two-letter-prefix? word)
    (append-ay (rotate word 2))

    :else
    (append-ay (rotate word 1))))

(defn translate [words]
  (->> (str/split words #" ")
       (map translate-word)
       (str/join " ")))
