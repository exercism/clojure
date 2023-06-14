(ns card-games-test
  (:require [clojure.test :refer [deftest is testing]]
            card-games))

(deftest rounds-test
  (is (= '((0 1 2) (1 2 3) (10 11 12) 
           (27 28 29) (99 100 101) (666 667 668)) 
         (map card-games/rounds '(0 1 10 27 99 666)))))

(comment
  (clojure.test/run-tests)
  )