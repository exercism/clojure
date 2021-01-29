(ns scrabble-score
  (:require [clojure.string :refer [split]]))

;; The letter values as shown in the README
(def ^:private letter-values
  {"AEIOULNRST" 1
   "DG"         2
   "BCMP"       3
   "FHVWY"      4
   "K"          5
   "JX"         8
   "QZ"        10})

;; A map from letter (as string) to score
(def ^:private letter->score
  (reduce-kv (fn [acc letters score]
               (-> (map str letters)
                   (zipmap (repeat score))
                   (->> (merge acc))))
             {} letter-values))

;; Defaults to 0 for non-alphabetic input
(defn score-letter [letter]
  (get letter->score (.toUpperCase (str letter)) 0))

(defn score-word [word]
  (reduce (fn [score letter]
            (+ score (score-letter letter)))
          0 word))
