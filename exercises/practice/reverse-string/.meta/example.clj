(ns reverse-string)

(defn reverse-string
  [s]
  (apply str (into () s)))
