(ns change-test
  (:require [clojure.test :refer [deftest testing is]]
            change))

(deftest issue_test_1
  (testing "change for 1 cent"
    (is (= '(1)
           (change/issue 1 #{1 5 10 25})))))

(deftest issue_test_2
  (testing "single coin change"
    (is (= '(25)
           (change/issue 25 #{1 5 10 25 100})))))

(deftest issue_test_3
  (testing "multiple coin change"
    (is (= '(5 10)
           (change/issue 15 #{1 5 10 25 100})))))

(deftest issue_test_4
  (testing "change with Lilliputian Coins"
    (is (= '(4 4 15)
           (change/issue 23 #{1 4 15 20 50})))))

(deftest issue_test_5
  (testing "change with Lower Elbonia Coins"
    (is (= '(21 21 21)
           (change/issue 63 #{1 5 10 21 25})))))

(deftest issue_test_6
  (testing "large target values"
    (is (= '(2 2 5 20 20 50 100 100 100 100 100 100 100 100 100)
           (change/issue 999 #{1 2 5 10 20 50 100})))))

(deftest issue_test_7
  (testing "possible change without unit coins available"
    (is (= '(2 2 2 5 10)
           (change/issue 21 #{2 5 10 20 50})))))

(deftest issue_test_8
  (testing "another possible change without unit coins available"
    (is (= '(4 4 4 5 5 5)
           (change/issue 27 #{4 5})))))

(deftest issue_test_9
  (testing "a greedy approach is not optimal"
    (is (= '(10 10)
           (change/issue 20 #{1 10 11})))))

(deftest issue_test_10
  (testing "no coins make 0 change"
    (is (= '()
           (change/issue 0 #{1 5 10 21 25})))))

(deftest issue_test_11
  (testing "error testing for change smaller than the smallest of coins"
    (is (thrown-with-msg? IllegalArgumentException #"^can't make target with given coins$"
                          (change/issue 3 #{5 10})))))

(deftest issue_test_12
  (testing "error if no combination can add up to target"
    (is (thrown-with-msg? IllegalArgumentException #"^can't make target with given coins$"
                          (change/issue 94 #{5 10})))))

(deftest issue_test_13
  (testing "cannot find negative change values"
    (is (thrown-with-msg? IllegalArgumentException #"^target can't be negative$"
                          (change/issue -5 #{1 2 5})))))
