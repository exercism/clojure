(ns sublist-test
  (:require [clojure.test :refer [deftest is testing]]
            sublist))

(deftest sublist-tests
  (testing "empty lists"
    (is (= :equal (sublist/classify [] []))))
  (testing "empty list within non empty list"
    (is (= :sublist (sublist/classify [] [1 2 3]))))
  (testing "non empty list contains empty list"
    (is (= :superlist (sublist/classify [1 2 3] []))))
  (testing "list equals itself"
    (is (= :equal (sublist/classify [1 2 3] [1 2 3]))))
  (testing "different lists"
    (is (= :unequal (sublist/classify [1 2 3] [2 3 4]))))
  (testing "false start"
    (is (= :sublist (sublist/classify [1 2 5] [0 1 2 3 1 2 5 6]))))
  (testing "consecutive"
    (is (= :sublist (sublist/classify [1 1 2] [0 1 1 1 2 1 2]))))
  (testing "sublist at start"
    (is (= :sublist (sublist/classify [0 1 2] [0 1 2 3 4 5]))))
  (testing "sublist in middle"
    (is (= :sublist (sublist/classify [2 3 4] [0 1 2 3 4 5]))))
  (testing "sublist at end"
    (is (= :sublist (sublist/classify [3 4 5] [0 1 2 3 4 5]))))
  (testing "at start of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [0 1 2]))))
  (testing "in middle of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [2 3]))))
  (testing "at end of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [3 4 5]))))
  (testing "first list missing element from second list"
    (is (= :unequal (sublist/classify [1 3] [1 2 3]))))
  (testing "second list missing element from first list"
    (is (= :unequal (sublist/classify [1 2 3] [1 3]))))
  (testing "order matters to a list"
    (is (= :unequal (sublist/classify [1 2 3] [3 2 1]))))
  (testing "same digits but different numbers"
    (is (= :unequal (sublist/classify [1 0 1] [10 1]))))
)
