(ns beer-song
  (:require [clojure.string :as str]))

(defn many [n] (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n" n n (dec n)))

(def two "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")
(def one "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")
(def zero "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")

(defn verse [v]
  (case (int v)
    0 zero
    1 one
    2 two
    (many v)))

(defn sing
  ([n]   (sing n 0))
  ([n m] (->> (range n (dec m) -1)
              (map verse)
              (str/join "\n"))))
