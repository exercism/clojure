(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn- canonicalize
  [word]
  (-> word
      lower-case
      frequencies))

(defn anagrams-for
  [word candidates]
  (let [canonical (canonicalize word)]
    (vec (filter #(and (not= word %) (= canonical (canonicalize %))) candidates))))
