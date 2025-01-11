(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [text]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" text)
       (map first)
       (apply str)
       str/upper-case))
