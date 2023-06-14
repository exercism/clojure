(ns card-games-test
  (:require [clojure.test :refer [deftest is testing]]
            card-games))

(deftest rounds-test
  (is (= '(0 1 2) (card-games/rounds 0))))

(comment
  (clojure.test/run-tests)
  )