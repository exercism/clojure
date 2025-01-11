(ns say
  (:require [clojure.pprint :as pp]
            [clojure.string :as s]))

(defn number [input]
  (if
   (or (< input 0) (> input 999999999999))
    (throw (IllegalArgumentException. "Out of range"))
    (s/replace (pp/cl-format nil "~R" input) #"," "")))
