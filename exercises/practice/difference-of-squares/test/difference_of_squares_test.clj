(ns difference-of-squares-test
  (:require [clojure.test :refer [deftest testing is]]
            difference-of-squares))

(deftest square-of-sum_test_1
  (testing "Square the sum of the numbers up to the given number -> square of sum 1"
    (is (= 1 (difference-of-squares/square-of-sum 1)))))

(deftest square-of-sum_test_2
  (testing "Square the sum of the numbers up to the given number -> square of sum 5"
    (is (= 225 (difference-of-squares/square-of-sum 5)))))

(deftest square-of-sum_test_3
  (testing "Square the sum of the numbers up to the given number -> square of sum 100"
    (is (= 25502500 (difference-of-squares/square-of-sum 100)))))

(deftest sum-of-squares_test_1
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 1"
    (is (= 1 (difference-of-squares/sum-of-squares 1)))))

(deftest sum-of-squares_test_2
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 5"
    (is (= 55 (difference-of-squares/sum-of-squares 5)))))

(deftest sum-of-squares_test_3
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 100"
    (is (= 338350 (difference-of-squares/sum-of-squares 100)))))

(deftest difference_test_1
  (testing "Subtract sum of squares from square of sums -> difference of squares 1"
    (is (= 0 (difference-of-squares/difference 1)))))

(deftest difference_test_2
  (testing "Subtract sum of squares from square of sums -> difference of squares 5"
    (is (= 170 (difference-of-squares/difference 5)))))

(deftest difference_test_3
  (testing "Subtract sum of squares from square of sums -> difference of squares 100"
    (is (= 25164150 (difference-of-squares/difference 100)))))
