(ns knapsack-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn- update-item [item]
  (safe-str (str item)))

(defn- update-items [items]
  (map update-item items))

(defn update-test-case [test-case]
  (update-in test-case [:input :items] update-items))
