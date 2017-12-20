(ns say
    (:require [clojure.pprint :as pp]))

(defn number [input]
  (if
    (or (< input 0) (> input 999999999999))
    (throw (Exception. "Out of range"))
    (clojure.string/replace (clojure.pprint/cl-format nil "~R" input) #"," "")
  )
)
