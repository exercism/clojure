(ns spiral-matrix-test
  (:require [clojure.test :refer [deftest testing is]]
            spiral-matrix))

(deftest spiral_test_1
  (testing "empty spiral"
    (is (= []
           (spiral-matrix/spiral 0)))))

(deftest spiral_test_2
  (testing "trivial spiral"
    (is (= [[1]]
           (spiral-matrix/spiral 1)))))

(deftest spiral_test_3
  (testing "spiral of size 2"
    (is (= [[1 2]
            [4 3]]
           (spiral-matrix/spiral 2)))))

(deftest spiral_test_4
  (testing "spiral of size 3"
    (is (= [[1 2 3]
            [8 9 4]
            [7 6 5]]
           (spiral-matrix/spiral 3)))))

(deftest spiral_test_5
  (testing "spiral of size 4"
    (is (= [[1 2 3 4]
            [12 13 14 5]
            [11 16 15 6]
            [10 9 8 7]]
           (spiral-matrix/spiral 4)))))

(deftest spiral_test_6
  (testing "spiral of size 5"
    (is (= [[1 2 3 4 5]
            [16 17 18 19 6]
            [15 24 25 20 7]
            [14 23 22 21 8]
            [13 12 11 10 9]]
           (spiral-matrix/spiral 5)))))
