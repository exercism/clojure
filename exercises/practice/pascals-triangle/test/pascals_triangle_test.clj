(ns pascals-triangle-test
  (:require [clojure.test :refer [deftest is testing]]
            pascals-triangle))

(deftest zero-rows
  (testing "Zero rows"
    (is (= []
           (take 0 pascals-triangle/triangle)))))

(deftest single-row
  (testing "Single row"
    (is (= [[1]]
           (take 1 pascals-triangle/triangle)))))

(deftest two-rows
  (testing "Two rows"
    (is (= [[1]
            [1 1]]
           (take 2 pascals-triangle/triangle)))))

(deftest three-rows
  (testing "Three rows"
    (is (= [[1]
            [1 1]
            [1 2 1]]
           (take 3 pascals-triangle/triangle)))))

(deftest four-rows
  (testing "Four rows"
    (is (= [[1]
            [1 1]
            [1 2 1]
            [1 3 3 1]]
           (take 4 pascals-triangle/triangle)))))

(deftest five-rows
  (testing "Five rows"
    (is (= [[1]
            [1 1]
            [1 2 1]
            [1 3 3 1]
            [1 4 6 4 1]]
           (take 5 pascals-triangle/triangle)))))

(deftest six-rows
  (testing "Six rows"
    (is (= [[1]
            [1 1]
            [1 2 1]
            [1 3 3  1]
            [1 4 6  4  1]
            [1 5 10 10 5 1]]
           (take 6 pascals-triangle/triangle)))))

(deftest ten-rows
  (testing "Ten rows"
    (is (= [[1]
            [1 1]
            [1 2 1]
            [1 3 3  1]
            [1 4 6  4  1]
            [1 5 10 10 5   1]
            [1 6 15 20 15  6   1]
            [1 7 21 35 35  21  7  1]
            [1 8 28 56 70  56  28 8  1]
            [1 9 36 84 126 126 84 36 9 1]]
           (take 10 pascals-triangle/triangle)))))
