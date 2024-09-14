(ns complex-numbers-test
  (:require [clojure.test :refer [deftest is testing]]
            [complex-numbers :as c]))

(defn- float-equal?
  "Returns true if the complex number c1 is equal to the complex number c2.
  This happens only if their corresponding parts are equal as floats."
  [c1 c2]
  (= (mapv float c1) (mapv float c2)))

;; Tests for Real Part
(deftest real-of-purely-real-number
  (testing "Real part of a purely real number"
    (is (= 1
           (c/real [1 0])))))

(deftest real-of-purely-imaginary-number
  (testing "Real part of a purely imaginary number"
    (is (= 0
           (c/real [0 1])))))

(deftest real-of-real-and-imaginary-number
  (testing "Real part of a number with real and imaginary part"
    (is (= 1
           (c/real [1 2])))))

;; Tests for Imaginary Part
(deftest imaginary-of-purely-real-number
  (testing "Imaginary part of a purely real number"
    (is (= 0
           (c/imaginary [1 0])))))

(deftest imaginary-of-purely-imaginary-number
  (testing "Imaginary part of a purely imaginary number"
    (is (= 1
           (c/imaginary [0 1])))))

(deftest imaginary-of-real-and-imaginary-number
  (testing "Imaginary part of a number with real and imaginary part"
    (is (= 2
           (c/imaginary [1 2])))))

;; Tests for Imaginary unit
(deftest imaginary-unit
  (testing "Imaginary unit"
    (is (= [-1 0]
           (c/mul [0 1] [0 1])))))

;; Tests for Addition
(deftest add-purely-real-numbers
  (testing "Add purely real numbers"
    (is (= [3 0]
           (c/add [1 0] [2 0])))))

(deftest add-purely-imaginary-numbers
  (testing "Add purely imaginary numbers"
    (is (= [0 3]
           (c/add [0 1] [0 2])))))

(deftest add-numbers-with-real-and-imaginary-part
  (testing "Add numbers with real and imaginary part"
    (is (= [4 6]
           (c/add [1 2] [3 4])))))

;; Tests for Subtraction
(deftest subtract-purely-real-numbers
  (testing "Subtract purely real numbers"
    (is (= [-1 0]
           (c/sub [1 0] [2 0])))))

(deftest subtract-purely-imaginary-numbers
  (testing "Subtract purely imaginary numbers"
    (is (= [0 -1]
           (c/sub [0 1] [0 2])))))

(deftest subtract-numbers-with-real-and-imaginary-part
  (testing "Subtract numbers with real and imaginary part"
    (is (= [-2 -2]
           (c/sub [1 2] [3 4])))))

;; Tests for Multiplication
(deftest multiply-purely-real-numbers
  (testing "Multiply purely real numbers"
    (is (= [2 0]
           (c/mul [1 0] [2 0])))))

(deftest multiply-purely-imaginary-numbers
  (testing "Multiply purely imaginary numbers"
    (is (= [-2 0]
           (c/mul [0 1] [0 2])))))

(deftest multiply-numbers-with-real-and-imaginary-part
  (testing "Multiply numbers with real and imaginary part"
    (is (= [-5 10]
           (c/mul [1 2] [3 4])))))

;; Tests for Division
(deftest divide-purely-real-numbers
  (testing "Divide purely real numbers"
    (is (float-equal? [0.5 0.0]
                      (c/div [1 0] [2 0])))))

(deftest divide-purely-imaginary-numbers
  (testing "Divide purely imaginary numbers"
    (is (float-equal? [0.5 0.0]
                      (c/div [0 1] [0 2])))))

(deftest divide-numbers-with-real-and-imaginary-part
  (testing "Divide numbers with real and imaginary part"
    (is (float-equal? [0.44 0.08]
                      (c/div [1 2] [3 4])))))

;; Tests for Absolute value
(deftest absolute-of-positive-purely-real-number
  (testing "Absolute value of a positive purely real number"
    (is (= (float 5.0)
           (float (c/abs [5 0]))))))

(deftest absolute-of-negative-purely-real-number
  (testing "Absolute value of a negative purely real number"
    (is (= (float 5.0)
           (float (c/abs [-5 0]))))))

(deftest absolute-of-positive-purely-imaginary-number
  (testing "Absolute value of a purely imaginary number with positive imaginary part"
    (is (= (float 5.0)
           (float (c/abs [0 5]))))))

(deftest absolute-of-negative-purely-imaginary-number
  (testing "Absolute value of a purely imaginary number with negative imaginary part"
    (is (= (float 5.0)
           (float (c/abs [0 -5]))))))

(deftest absolute-of-real-and-imaginary-number
  (testing "Absolute value of a number with real and imaginary part"
    (is (= (float 5.0)
           (float (c/abs [3 4]))))))

;; Tests for Complex conjugate
(deftest conjugate-of-purely-real-number
  (testing "Conjugate a purely real number"
    (is (= [5 0]
           (c/conjugate [5 0])))))

(deftest conjugate-of-purely-imaginary-number
  (testing "Conjugate a purely imaginary number"
    (is (= [0 -5]
           (c/conjugate [0 5])))))

(deftest conjugate-of-real-and-imaginary-number
  (testing "Conjugate a number with real and imaginary part"
    (is (= [1 -1]
           (c/conjugate [1 1])))))

;; Tests for Operations between real numbers and complex numbers
(deftest add-real-to-complex-number
  (testing "Add real number to complex number"
    (is (= [6 2]
           (c/add [1 2] [5 0])))))

(deftest add-complex-to-real-number
  (testing "Add complex number to real number"
    (is (= [6 2]
           (c/add [5 0] [1 2])))))

(deftest subtract-real-from-complex-number
  (testing "Subtract real number from complex number"
    (is (= [1 7]
           (c/sub [5 7] [4 0])))))

(deftest subtract-complex-from-real-number
  (testing "Subtract complex number from real number"
    (is (= [-1 -7]
           (c/sub [4 0] [5 7])))))

(deftest multiply-complex-by-real-number
  (testing "Multiply complex number by real number"
    (is (= [10 25]
           (c/mul [2 5] [5 0])))))

(deftest multiply-real-by-complex-number
  (testing "Multiply real number by complex number"
    (is (= [10 25]
           (c/mul [5 0] [2 5])))))

(deftest divide-complex-by-real-number
  (testing "Divide complex number by real number"
    (is (float-equal? [1.0 10.0]
                      (c/div [10 100] [10 0])))))

(deftest divide-real-by-complex-number
  (testing "Divide real number by complex number"
    (is (float-equal? [2.5 -2.5]
                      (c/div [5 0] [1 1])))))
