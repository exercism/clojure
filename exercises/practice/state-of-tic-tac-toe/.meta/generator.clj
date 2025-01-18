(ns state-of-tic-tac-toe-generator
  (:require [hbs.helper :refer [safe-str]]))

(defn- update-expected [expected]
  (if-let [error (:error expected)]
    {:error (str "^" error "$")}
    (safe-str (keyword expected))))

(defn update-test-case [test-case]
  (update test-case :expected update-expected))
