(ns isogram)

(defn isogram?
  [s]
  (->> s
       clojure.string/lower-case
       (filter #(Character/isAlphabetic (int %)))
       frequencies
       vals
       (every? #{1})))
