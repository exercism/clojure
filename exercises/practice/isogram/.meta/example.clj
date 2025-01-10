(ns isogram
  (:require [clojure.string :as str]))

(defn isogram? [word]
  (let [letters (filter #(Character/isLetter %) (str/lower-case word))]
    (or (empty? letters) (apply distinct? letters))))
