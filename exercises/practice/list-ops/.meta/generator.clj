(ns list-ops-generator
  (:require [clojure.string :as str]
            [hbs.helper :refer [safe-str]]))

(def ^:private patterns->test-type
  {#"(?i)append" "Append"
   #"(?i)concatenate" "Concatenate"
   #"(?i)filter" "Filter"
   #"(?i)length" "Length"
   #"(?i)transform" "Map"
   #"(?i)reverse" "Reverse"
   #"(?i)fold.*left" "Foldl"
   #"(?i)fold.*right" "Foldr"})

(defn- specs-fn->clojure-fn [f]
  (case f
    "(x) -> x modulo 2 == 1" "odd?"
    "(x) -> x + 1" "inc"
    ("(x, y) -> x * y" "(acc, el) -> el * acc") "(fn [acc el] (* el acc))"
    ("(x, y) -> x + y" "(acc, el) -> el + acc") "(fn [acc el] (+ el acc))"
    ("(x, y) -> x / y" "(acc, el) -> el / acc") "(fn [acc el] (/ el acc))"))

(defn- test-case-type [path]
  (let [parent-description (first path)]
    (->> patterns->test-type
         (some #(when (re-find (key %) parent-description) (val %))))))

(defn- update-description [path]
  (-> path
      second
      (str/replace #"list" "vector")))

(defn- create-context [test-case]
  (let [path (:path test-case)
        test-type (test-case-type path)
        new-description (update-description path)]
    (str test-type " ▶ " new-description)))

(defn- update-input [input]
  (if-let [f (get input :function)]
    (assoc input :function (-> f specs-fn->clojure-fn safe-str))
    input))

(defn update-test-case [test-case]
  (-> test-case
      (assoc :context (create-context test-case))
      (update :input update-input)))
