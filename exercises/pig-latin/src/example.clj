(ns pig-latin
  (:require [clojure.string :as str]))

(defn starts-with-any [prefixes]
  (fn [word]
    (some (partial str/starts-with? word) prefixes)))

(defn- starts-with-vowel-like? [word]
  ((starts-with-any #{"yt" "xr"}) word))

(defn starts-with-vowel? [word]
  ((starts-with-any #{"a" "e" "i" "o" "u"}) word))

(defn- starts-with-two-letter-prefix? [word]
  ((starts-with-any #{"ch" "qu" "th"}) word))

(defn- starts-with-three-letter-prefix? [word]
  ((starts-with-any #{"thr" "sch"}) word))

(defn- starts-with-qu-and-preceeding-constanant? [word]
  (and (not (starts-with-vowel? word))
       (str/starts-with? (subs word 1) "qu")))

(defn rotate [word n]
  (str (subs word n) (subs word 0 n)))

(defn- translate-word [word]
  (cond
    (or (starts-with-vowel? word)
        (starts-with-vowel-like? word))
    (str word "ay")

    (or
     (starts-with-three-letter-prefix? word)
     (starts-with-qu-and-preceeding-constanant? word))
    (str (rotate word 3) "ay")

    (starts-with-two-letter-prefix? word)
    (str (rotate word 2) "ay")

    :else
    (str (rotate word 1) "ay")))

(defn translate [words]
  (->> (str/split words #" ")
       (map translate-word)
       (str/join " ")))
