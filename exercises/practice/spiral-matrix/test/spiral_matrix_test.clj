(ns spiral-matrix-test
  (:require [clojure.test :refer [deftest is testing]]
            spiral-matrix))

(deftest test-8f584201-b446-4bc9-b132-811c8edd9040
  (testing "Empty spiral"
    (is (= []
           (spiral-matrix/spiral 0)))))

(deftest test-e40ae5f3-e2c9-4639-8116-8a119d632ab2
  (testing "Trivial spiral"
    (is (= [[1]]
           (spiral-matrix/spiral 1)))))

(deftest test-cf05e42d-eb78-4098-a36e-cdaf0991bc48
  (testing "Spiral of size 2"
    (is (= [[1 2]
            [4 3]]
           (spiral-matrix/spiral 2)))))

(deftest test-1c475667-c896-4c23-82e2-e033929de939
  (testing "Spiral of size 3"
    (is (= [[1 2 3]
            [8 9 4]
            [7 6 5]]
           (spiral-matrix/spiral 3)))))

(deftest test-05ccbc48-d891-44f5-9137-f4ce462a759d
  (testing "Spiral of size 4"
    (is (= [[1  2  3  4]
            [12 13 14 5]
            [11 16 15 6]
            [10 9  8  7]]
           (spiral-matrix/spiral 4)))))

(deftest test-f4d2165b-1738-4e0c-bed0-c459045ae50d
  (testing "Spiral of size 5"
    (is (= [[1  2  3  4  5]
            [16 17 18 19 6]
            [15 24 25 20 7]
            [14 23 22 21 8]
            [13 12 11 10 9]]
           (spiral-matrix/spiral 5)))))
