(ns twelve-days
  (:require [clojure.string :as str]))

(def gifts ["a Partridge in a Pear Tree"
            "two Turtle Doves"
            "three French Hens"
            "four Calling Birds"
            "five Gold Rings"
            "six Geese-a-Laying"
            "seven Swans-a-Swimming"
            "eight Maids-a-Milking"
            "nine Ladies Dancing"
            "ten Lords-a-Leaping"
            "eleven Pipers Piping"
            "twelve Drummers Drumming"])

(def days ["first"
           "second"
           "third"
           "fourth"
           "fifth"
           "sixth"
           "seventh"
           "eighth"
           "ninth"
           "tenth"
           "eleventh"
           "twelfth"])

(defn line-gifts [n]
  (->> gifts
       (take n)
       (reverse)
       (str/join ", ")
       (#(str/replace % #", a" ", and a"))))

(defn line [n]
  (str "On the " (nth days (dec n)) " day of Christmas my true love gave to me: " (line-gifts n) "."))

(defn recite [start-verse end-verse]
  (map line (range start-verse (inc end-verse))))
