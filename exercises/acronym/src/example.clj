(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts a phrase to its acronym."
  [text]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" text)
       (map first)
       (apply str)
       str/upper-case))
