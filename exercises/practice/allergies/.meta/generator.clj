(ns allergies-generator
  (:require [clojure.string :as str]))

(defn- create-context [test-case]
  (let [[parent-description description] (:path test-case)]
    (-> parent-description
        (str/replace #"list when:" "allergies")
        (str/replace #"testing for " "check for ")
        (str " ▶ " description))))

(defn- update-input [input]
  (if-let [item (get input :item)]
    (assoc input :item (symbol (str (keyword item))))
    input))

 (defn- update-expected [expected]
   (if (sequential? expected)
     (mapv #(symbol (str (keyword %))) expected)
     expected))

(defn update-test-case [test-case]
  (-> test-case
      (update :input update-input)
      (update :expected update-expected)
      (assoc :context (create-context test-case))))
