(ns acronym)

(defn acronym [text]
  (->> (re-seq #"(?<=^|[-_ ])[A-Za-z]" text)
       (map first)
       (apply str)
       clojure.string/upper-case))
