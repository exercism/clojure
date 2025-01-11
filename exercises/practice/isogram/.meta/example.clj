(ns isogram
  (:require [clojure.string :as str]))

(defn isogram? [word]
  (apply distinct? (filter #(Character/isLetter %) (str/lower-case word))))
