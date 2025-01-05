(ns word-count)

(defn word-count
  [phrase]
  (->> phrase
       clojure.string/lower-case
       (re-seq #"\b\w+'?\w*\b")
       frequencies))
