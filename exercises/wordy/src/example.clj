(ns wordy
  (:require [clojure.string :refer [join]]))

(def ^:private ops {"plus" +
                    "minus" -
                    "multiplied by" *
                    "divided by" /})

(def ^:private tokens-pattern (re-pattern
                               (str (join "|" (keys ops)) "|-?\\d+|\\S+")))

(defn- parse-op [op-str]
  (or (ops op-str)
      (throw (IllegalArgumentException. (str "unknown operator " op-str)))))

(defn evaluate [expr]
  (if-let [[_ exprs] (re-matches #"What is (.+)\?" expr)]
    (if-let [[token & tokens] (re-seq tokens-pattern exprs)]
      (reduce (fn [acc [op x]]
                ((parse-op op) acc (Integer/parseInt x)))
              (Integer/parseInt token) (partition-all 2 tokens))
      (throw (IllegalArgumentException. "no arithmetic expression found")))
    (throw (IllegalArgumentException. "cannot recognize question"))))
