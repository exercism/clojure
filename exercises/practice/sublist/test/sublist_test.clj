(ns sublist-test
  (:require [clojure.test :refer [deftest testing is]]
            sublist))

(deftest classify_test_1
  (testing "empty lists"
    (is (= :equal (sublist/classify [] [])))))

(deftest classify_test_2
  (testing "empty list within non empty list"
    (is (= :sublist (sublist/classify [] [1 2 3])))))

(deftest classify_test_3
  (testing "non empty list contains empty list"
    (is (= :superlist (sublist/classify [1 2 3] [])))))

(deftest classify_test_4
  (testing "list equals itself"
    (is (= :equal (sublist/classify [1 2 3] [1 2 3])))))

(deftest classify_test_5
  (testing "different lists"
    (is (= :unequal (sublist/classify [1 2 3] [2 3 4])))))

(deftest classify_test_6
  (testing "false start"
    (is (= :sublist (sublist/classify [1 2 5] [0 1 2 3 1 2 5 6])))))

(deftest classify_test_7
  (testing "consecutive"
    (is (= :sublist (sublist/classify [1 1 2] [0 1 1 1 2 1 2])))))

(deftest classify_test_8
  (testing "sublist at start"
    (is (= :sublist (sublist/classify [0 1 2] [0 1 2 3 4 5])))))

(deftest classify_test_9
  (testing "sublist in middle"
    (is (= :sublist (sublist/classify [2 3 4] [0 1 2 3 4 5])))))

(deftest classify_test_10
  (testing "sublist at end"
    (is (= :sublist (sublist/classify [3 4 5] [0 1 2 3 4 5])))))

(deftest classify_test_11
  (testing "at start of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [0 1 2])))))

(deftest classify_test_12
  (testing "in middle of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [2 3])))))

(deftest classify_test_13
  (testing "at end of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [3 4 5])))))

(deftest classify_test_14
  (testing "first list missing element from second list"
    (is (= :unequal (sublist/classify [1 3] [1 2 3])))))

(deftest classify_test_15
  (testing "second list missing element from first list"
    (is (= :unequal (sublist/classify [1 2 3] [1 3])))))

(deftest classify_test_16
  (testing "first list missing additional digits from second list"
    (is (= :unequal (sublist/classify [1 2] [1 22])))))

(deftest classify_test_17
  (testing "order matters to a list"
    (is (= :unequal (sublist/classify [1 2 3] [3 2 1])))))

(deftest classify_test_18
  (testing "same digits but different numbers"
    (is (= :unequal (sublist/classify [1 0 1] [10 1])))))
