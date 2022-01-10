(ns complex-numbers-test
  (:require [clojure.test :refer [deftest is testing]]
            [complex-numbers :as c]))

;; Tests for Real Part
(deftest real-of-purely-real-number
  (testing "Real part of a purely real number"
    (is (= (c/real [1 0])
           1))))

(deftest real-of-purely-imaginary-number
  (testing "Real part of a purely imaginary number"
    (is (= (c/real [0 1])
           0))))

(deftest real-of-real-and-imaginary-number
  (testing "Real part of a number with real and imaginary part"
    (is (= (c/real [1 2])
           1))))

;; Tests for Imaginary Part
(deftest imaginary-of-purely-real-number
  (testing "Imaginary part of a purely real number"
    (is (= (c/imaginary [1 0])
           0))))

(deftest imaginary-of-purely-imaginary-number
  (testing "Imaginary part of a purely imaginary number"
    (is (= (c/imaginary [0 1])
           1))))

(deftest imaginary-of-real-and-imaginary-number
  (testing "Imaginary part of a number with real and imaginary part"
    (is (= (c/imaginary [1 2])
           2))))

;; Tests for Absolute Value
(deftest absolute-of-positive-purely-real-number
  (testing "Absolute value of a positive purely real number"
    (is (= (c/abs [5 0])
           5.0))))

(deftest absolute-of-negative-purely-real-number
  (testing "Absolute value of a negative purely real number"
    (is (= (c/abs [-5 0])
           5.0))))

(deftest absolute-of-positive-purely-imaginary-number
  (testing "Absolute value of a purely imaginary number with positive imaginary part"
    (is (= (c/abs [0 5])
           5.0))))

(deftest absolute-of-negative-purely-imaginary-number
  (testing "Absolute value of a purely imaginary number with negative imaginary part"
    (is (= (c/abs [0 -5])
           5.0))))

(deftest absolute-of-real-and-imaginary-number
  (testing "Absolute value of a number with real and imaginary part"
    (is (= (c/abs [3 4])
           5.0))))

;; Tests for Conjugate
(deftest conjugate-of-purely-real-number
  (testing "Conjugate a purely real number"
    (is (= (c/conjugate [5 0])
           [5 0]))))

(deftest conjugate-of-purely-imaginary-number
  (testing "Conjugate a purely imaginary number"
    (is (= (c/conjugate [0 5])
           [0 -5]))))

(deftest conjugate-of-real-and-imaginary-number
  (testing "Conjugate a number with real and imaginary part"
    (is (= (c/conjugate [1 1])
           [1 -1]))))

;; Tests for Addition
(deftest add-purely-real-numbers
  (testing "Add purely real numbers"
    (is (= (c/add [1 0] [2 0])
           [3 0]))))

(deftest add-purely-imaginary-numbers
  (testing "Add purely imaginary numbers"
    (is (= (c/add [0 1] [0 2])
           [0 3]))))

(deftest add-numbers-with-real-and-imaginary-part
  (testing "Add numbers with real and imaginary part"
    (is (= (c/add [1 2] [3 4])
           [4 6]))))

;; Tests for Subtraction
(deftest subtract-purely-real-numbers
  (testing "Subtract purely real numbers"
    (is (= (c/sub [1 0] [2 0])
           [-1 0]))))

(deftest subtract-purely-imaginary-numbers
  (testing "Subtract purely imaginary numbers"
    (is (= (c/sub [0 1] [0 2])
           [0 -1]))))

(deftest subtract-numbers-with-real-and-imaginary-part
  (testing "Subtract numbers with real and imaginary part"
    (is (= (c/sub [1 2] [3 4])
           [-2 -2]))))

;; Tests for Multiplication
(deftest multiply-purely-real-numbers
  (testing "Multiply purely real numbers"
    (is (= (c/mul [1 0] [2 0])
           [2 0]))))

(deftest multiply-purely-imaginary-numbers
  (testing "Multiply purely imaginary numbers"
    (is (= (c/mul [0 1] [0 2])
           [-2 0]))))

(deftest multiply-numbers-with-real-and-imaginary-part
  (testing "Multiply numbers with real and imaginary part"
    (is (= (c/mul [1 2] [3 4])
           [-5 10]))))

;; Tests for division
(deftest divide-purely-real-numbers
  (testing "Divide purely real numbers"
    (is (= (c/div [1 0] [2 0])
           [0.5 0.0]))))

(deftest dividey-purely-imaginary-numbers
  (testing "Divide purely imaginary numbers"
    (is (= (c/div [0 1] [0 2])
           [0.5 0.0]))))

(deftest divide-numbers-with-real-and-imaginary-part
  (testing "Divide numbers with real and imaginary part"
    (is (= (c/div [1 2] [3 4])
           [0.44 0.08]))))
