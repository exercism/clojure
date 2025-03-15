(ns robot-simulator-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn- update-direction [x]
    (update x :direction #(safe-str (keyword %))))

(defn update-test-case [test-case]
  (-> test-case
      (update :expected update-direction)
      (update :input update-direction)))
