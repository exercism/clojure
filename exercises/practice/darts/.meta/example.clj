(ns darts
  (:require [clojure.math :refer [hypot]]))

(defn score
  [x y]
  (condp >= (hypot x y)
    1 10
    5 5
    10 1
    0))
