(ns connect-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn- update-expected [expected]
  (if (= "" expected)
    (safe-str :no-winner)
    (safe-str (keyword expected))))

(defn update-test-case [test-case]
  (update test-case :expected update-expected))
