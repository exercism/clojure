(ns gigasecond-generator
  (:require [clojure.instant :refer [read-instant-date]]))

(defn- update-test-case [test-case]
  (let [moment (read-instant-date (get-in test-case [:input :moment]))
        expected (if (= "isEqual" (:property test-case))
                   [moment])])

  (defn transform [test-cases]
    (map update-test-case test-cases))
