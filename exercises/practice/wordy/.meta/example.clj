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
      (if (every? Character/isDigit op-str)
        (throw (IllegalArgumentException. "syntax error"))
        (throw (IllegalArgumentException. "unknown operation")))))

(defn- parse-operand [operand-str]
  (try
    (Integer/parseInt operand-str)
    (catch java.lang.NumberFormatException _ (throw (IllegalArgumentException. "syntax error")))))

(defn evaluate [expr]
  (if-let [[_ exprs] (re-matches #"What is(.*)\?" expr)]
    (if (empty? exprs)
      (throw (IllegalArgumentException. "syntax error"))
      (if-let [[token & tokens] (re-seq tokens-pattern exprs)]
        (reduce (fn [acc [op x]]
                  ((parse-op op) acc (parse-operand x)))
                (parse-operand token) (partition-all 2 tokens))
        (throw (IllegalArgumentException. "unknown operation"))))
    (throw (IllegalArgumentException. "syntax error"))))
