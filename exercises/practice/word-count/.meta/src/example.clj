(ns word-count
  (:require [clojure.string :refer [lower-case split]]))

(defn word-count
  "return a hash of unique words and how many times they appeared in the input string"
  [input]
  (->> (split input #"\W+")
       (map lower-case)
       (group-by identity)
       (reduce (fn [acc [word occurrences]]
                 (assoc acc word (count occurrences))) {})))


;; Another approach
(defn word-count [s]
  (->> s
       lower-case
       (re-seq #"\w+")
       frequencies))
