(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform
  "Accepts a map of scores to strings,
   and returns a map of each letter to its score."
  [legacy-data]
  (into {}
        (for [[score letters] legacy-data
              letter          letters]
          [(lower-case letter) score])))
