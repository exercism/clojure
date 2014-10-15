(ns difference-of-squares-test
  (:require [clojure.test :refer :all]))

(load-file "difference_of_squares.clj")

(deftest square-of-sums-to-5
  (is (= 225 (difference-of-squares/square-of-sums 5))))

(deftest sum-of-squares-to-5
  (is (= 55 (difference-of-squares/sum-of-squares 5))))

(deftest difference-of-sums-to-5
  (is (= 170 (difference-of-squares/difference 5))))

(deftest square-of-sums-to-10
  (is (= 3025 (difference-of-squares/square-of-sums 10))))

(deftest sum-of-squares-to-10
  (is (= 385 (difference-of-squares/sum-of-squares 10))))

(deftest difference-of-sums-to-10
  (is (= 2640 (difference-of-squares/difference 10))))

(deftest square-of-sums-to-100
  (is (= 25502500 (difference-of-squares/square-of-sums 100))))

(deftest sum-of-squares-to-100
  (is (= 338350 (difference-of-squares/sum-of-squares 100))))

(deftest difference-of-sums-to-100
  (is (= 25164150 (difference-of-squares/difference 100))))

(run-tests)

