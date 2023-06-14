(ns card-games-test
  (:require [clojure.test :refer [deftest is testing]]
            card-games))

(deftest rounds-test
  (is (= '((0 1 2) (1 2 3) (10 11 12) 
           (27 28 29) (99 100 101) (666 667 668)) 
         (map card-games/rounds '(0 1 10 27 99 666)))))

(deftest concat-rounds-test
  (is (= '(() (0 1) (1 2) (1 2)
           (27 28 29 35 36)
           (1 2 3 4 5 6))
         (map #(apply card-games/concat-rounds %) '((() ()) ((0 1) ()) (() (1 2))
                                         ((1) (2)) ((27 28 29) (35 36))
                                         ((1 2 3) (4 5 6)))))))

(comment
  (apply card-games/concat-rounds '(() ()))

  (clojure.test/run-tests)
  )