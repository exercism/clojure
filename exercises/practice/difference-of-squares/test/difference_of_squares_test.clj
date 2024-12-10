(ns difference-of-squares-test
  (:require [clojure.test :refer [deftest testing is]]
            difference-of-squares))

(deftest test-e46c542b-31fc-4506-bcae-6b62b3268537
  (testing "Square the sum of the numbers up to the given number -> square of sum 1"
    (is (= 1 (difference-of-squares/square-of-sum 1)))))

(deftest test-9b3f96cb-638d-41ee-99b7-b4f9c0622948
  (testing "Square the sum of the numbers up to the given number -> square of sum 5"
    (is (= 225 (difference-of-squares/square-of-sum 5)))))

(deftest test-54ba043f-3c35-4d43-86ff-3a41625d5e86
  (testing "Square the sum of the numbers up to the given number -> square of sum 100"
    (is (= 25502500 (difference-of-squares/square-of-sum 100)))))

(deftest test-01d84507-b03e-4238-9395-dd61d03074b5
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 1"
    (is (= 1 (difference-of-squares/sum-of-squares 1)))))

(deftest test-c93900cd-8cc2-4ca4-917b-dd3027023499
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 5"
    (is (= 55 (difference-of-squares/sum-of-squares 5)))))

(deftest test-94807386-73e4-4d9e-8dec-69eb135b19e4
  (testing "Sum the squares of the numbers up to the given number -> sum of squares 100"
    (is (= 338350 (difference-of-squares/sum-of-squares 100)))))

(deftest test-44f72ae6-31a7-437f-858d-2c0837adabb6
  (testing "Subtract sum of squares from square of sums -> difference of squares 1"
    (is (= 0 (difference-of-squares/difference 1)))))

(deftest test-005cb2bf-a0c8-46f3-ae25-924029f8b00b
  (testing "Subtract sum of squares from square of sums -> difference of squares 5"
    (is (= 170 (difference-of-squares/difference 5)))))

(deftest test-b1bf19de-9a16-41c0-a62b-1f02ecc0b036
  (testing "Subtract sum of squares from square of sums -> difference of squares 100"
    (is (= 25164150 (difference-of-squares/difference 100)))))
