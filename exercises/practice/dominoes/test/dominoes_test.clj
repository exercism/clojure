(ns dominoes-test
  (:require [clojure.test :refer [deftest testing is]]
            dominoes))

(deftest can-chain?_test_1
  (testing "empty input = empty output"
    (is (true? (dominoes/can-chain? [])))))

(deftest can-chain?_test_2
  (testing "singleton input = singleton output"
    (is (true? (dominoes/can-chain? [[1 1]])))))

(deftest can-chain?_test_3
  (testing "singleton that can't be chained"
    (is (false? (dominoes/can-chain? [[1 2]])))))

(deftest can-chain?_test_4
  (testing "three elements"
    (is (true? (dominoes/can-chain? [[1 2] [3 1] [2 3]])))))

(deftest can-chain?_test_5
  (testing "can reverse dominoes"
    (is (true? (dominoes/can-chain? [[1 2] [1 3] [2 3]])))))

(deftest can-chain?_test_6
  (testing "can't be chained"
    (is (false? (dominoes/can-chain? [[1 2] [4 1] [2 3]])))))

(deftest can-chain?_test_7
  (testing "disconnected - simple"
    (is (false? (dominoes/can-chain? [[1 1] [2 2]])))))

(deftest can-chain?_test_8
  (testing "disconnected - double loop"
    (is (false? (dominoes/can-chain? [[1 2] [2 1] [3 4] [4 3]])))))

(deftest can-chain?_test_9
  (testing "disconnected - single isolated"
    (is (false? (dominoes/can-chain? [[1 2] [2 3] [3 1] [4 4]])))))

(deftest can-chain?_test_10
  (testing "need backtrack"
    (is (true? (dominoes/can-chain? [[1 2] [2 3] [3 1] [2 4] [2 4]])))))

(deftest can-chain?_test_11
  (testing "separate loops"
    (is (true? (dominoes/can-chain? [[1 2] [2 3] [3 1] [1 1] [2 2] [3 3]])))))

(deftest can-chain?_test_12
  (testing "nine elements"
    (is (true? (dominoes/can-chain? [[1 2] [5 3] [3 1] [1 2] [2 4] [1 6] [2 3] [3 4] [5 6]])))))

(deftest can-chain?_test_13
  (testing "separate three-domino loops"
    (is (false? (dominoes/can-chain? [[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]])))))
