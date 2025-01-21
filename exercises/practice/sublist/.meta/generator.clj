(ns sublist-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn transform-test-case [test-case]
  (update test-case :expected #(safe-str (keyword %))))
