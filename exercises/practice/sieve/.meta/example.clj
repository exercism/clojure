(ns sieve
  (:require [clojure.math :as math]))

(defn non-even-composites
  [n]
  (for [i (range 3 (inc (int (math/sqrt n))) 2)
        k (range i (inc (int (/ n i))) 2)]
    (* i k)))

(defn sieve
  [n]
  (if (< n 2)
    ()
    (let [candidates (cons 2 (range 3 (inc n) 2))
          composites (set (non-even-composites n))]
      (remove composites candidates))))
