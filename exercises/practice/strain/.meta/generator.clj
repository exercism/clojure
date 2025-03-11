(ns strain-generator
  (:require [clojure.string :as str]
            [hbs.helper :refer [safe-str]]))

(defn- specs-fn->clojure-fn [pred]
  (case pred
    "fn(x) -> true" "(fn [_] true)"
    "fn(x) -> false" "(fn [_] false)"
    "fn(x) -> x % 2 == 1" "odd?"
    "fn(x) -> x % 2 == 0" "even?"
    "fn(x) -> starts_with(x, 'z')" "(fn[x] (str/starts-with? x \"z\"))"
    "fn(x) -> contains(x, 5)" "(fn [x] (boolean (some #{5} x)))"))

(defn- create-context [test-case]
  (str/replace (:description test-case) #"list" "vector"))

(defn- update-predicate [test-case]
  (let [pred (get-in test-case [:input :predicate])]
    (assoc-in test-case [:input :predicate] (-> pred specs-fn->clojure-fn safe-str))))

(defn update-test-case [test-case]
  (-> test-case
      update-predicate
      (assoc :context (create-context test-case))))
