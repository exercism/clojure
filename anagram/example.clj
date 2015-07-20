(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn- anagram? [w c]
  (let [w (lower-case w)
        c (lower-case c)]
    (and (= (sort w) (sort c))
         (not= w c))))

(defn anagrams-for [w coll]
  (filter (partial anagram? w) coll))
