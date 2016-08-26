(ns pangram
  (:require [clojure.string :refer [lower-case]]))

(def ^:private a-int (int \a))
(def ^:private z-int (int \z))

(def ^:private alphabet (set (range a-int (inc z-int))))

(defn pangram? [input]
  (= alphabet
     (->> input
          lower-case
          (map int)
          (filter #(<= a-int % z-int))
          set)))
