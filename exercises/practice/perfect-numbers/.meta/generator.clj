(ns perfect-numbers-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn update-test-case [test-case]
  (update test-case :expected #(safe-str (keyword %))))
