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
         (map #(apply card-games/concat-rounds %) 
              '((() ()) ((0 1) ()) (() (1 2))
                        ((1) (2)) ((27 28 29) (35 36))
                        ((1 2 3) (4 5 6)))))))

(deftest contains-round-test
  (is (= '(false false false true true true)
         (map #(apply card-games/contains-round? %) 
              '(([], 1), ([1, 2, 3], 0), ([27, 28, 29, 35, 36], 30),
              ([1], 1), ([1, 2, 3], 1), ([27, 28, 29, 35, 36], 29))))))

(deftest card-average-test
  (is (= '(1.0 6.0 2.5 37.0)
         (map card-games/card-average '((1) (5 6 7) (1 2 3 4) (1 10 100))))))

(deftest approx-average-test
  (is (= '(false false false false true true true true)
         (map card-games/approx-average?
               '((0 1 5) (3 6 9 12 150) (1 2 3 5 9)
                (2 3 4 7 8) (1 2 3) (2 3 4)
                (2 3 4 8 8) (1 2 4 5 8))))))

(deftest average-even-odd-test
  (is (= '(false false true true true)
         (map card-games/average-even-odd?
              '((5 6 8) (1 2 3 4) (1 2 3) (5 6 7) (1 3 5 7 9))))))

(deftest maybe-double-last-test
  (is (= '((1 2 22) (5 9 22) (5 9 10) (1 2 3))
         (map card-games/maybe-double-last
              '((1 2 11) (5 9 11) (5 9 10) (1 2 3))))))
