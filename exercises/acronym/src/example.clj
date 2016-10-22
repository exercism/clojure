(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [text]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" text)
       (map first)
       (map str/upper-case)
       (apply str)))
