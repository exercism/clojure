(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [text]
  (apply str (map str/upper-case (map first (re-seq #"[A-Z]+[a-z]*|[a-z]+" text)))))
