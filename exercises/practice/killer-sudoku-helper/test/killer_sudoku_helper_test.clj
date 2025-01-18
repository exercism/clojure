(ns killer-sudoku-helper-test
  (:require [clojure.test :refer [deftest testing is]]
            killer-sudoku-helper))

(deftest combinations_test_1
  (testing "Trivial 1-digit cages ▶ 1"
    (is (= [[1]] (killer-sudoku-helper/combinations {:sum 1 :size 1 :exclude []})))))

(deftest combinations_test_2
  (testing "Trivial 1-digit cages ▶ 2"
    (is (= [[2]] (killer-sudoku-helper/combinations {:sum 2 :size 1 :exclude []})))))

(deftest combinations_test_3
  (testing "Trivial 1-digit cages ▶ 3"
    (is (= [[3]] (killer-sudoku-helper/combinations {:sum 3 :size 1 :exclude []})))))

(deftest combinations_test_4
  (testing "Trivial 1-digit cages ▶ 4"
    (is (= [[4]] (killer-sudoku-helper/combinations {:sum 4 :size 1 :exclude []})))))

(deftest combinations_test_5
  (testing "Trivial 1-digit cages ▶ 5"
    (is (= [[5]] (killer-sudoku-helper/combinations {:sum 5 :size 1 :exclude []})))))

(deftest combinations_test_6
  (testing "Trivial 1-digit cages ▶ 6"
    (is (= [[6]] (killer-sudoku-helper/combinations {:sum 6 :size 1 :exclude []})))))

(deftest combinations_test_7
  (testing "Trivial 1-digit cages ▶ 7"
    (is (= [[7]] (killer-sudoku-helper/combinations {:sum 7 :size 1 :exclude []})))))

(deftest combinations_test_8
  (testing "Trivial 1-digit cages ▶ 8"
    (is (= [[8]] (killer-sudoku-helper/combinations {:sum 8 :size 1 :exclude []})))))

(deftest combinations_test_9
  (testing "Trivial 1-digit cages ▶ 9"
    (is (= [[9]] (killer-sudoku-helper/combinations {:sum 9 :size 1 :exclude []})))))

(deftest combinations_test_10
  (testing "Cage with sum 45 contains all digits 1:9"
    (is (= [[1 2 3 4 5 6 7 8 9]] (killer-sudoku-helper/combinations {:sum 45 :size 9 :exclude []})))))

(deftest combinations_test_11
  (testing "Cage with only 1 possible combination"
    (is (= [[1 2 4]] (killer-sudoku-helper/combinations {:sum 7 :size 3 :exclude []})))))

(deftest combinations_test_12
  (testing "Cage with several combinations"
    (is (= [[1 9] [2 8] [3 7] [4 6]] (killer-sudoku-helper/combinations {:sum 10 :size 2 :exclude []})))))

(deftest combinations_test_13
  (testing "Cage with several combinations that is restricted"
    (is (= [[2 8] [3 7]] (killer-sudoku-helper/combinations {:sum 10 :size 2 :exclude [1 4]})))))
