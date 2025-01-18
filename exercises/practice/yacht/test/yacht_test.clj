(ns yacht-test
  (:require [clojure.test :refer [deftest testing is]]
            yacht))

(deftest score_test_1
  (testing "Yacht"
    (is (= 50 (yacht/score [5 5 5 5 5] "yacht")))))

(deftest score_test_2
  (testing "Not Yacht"
    (is (= 0 (yacht/score [1 3 3 2 5] "yacht")))))

(deftest score_test_3
  (testing "Ones"
    (is (= 3 (yacht/score [1 1 1 3 5] "ones")))))

(deftest score_test_4
  (testing "Ones, out of order"
    (is (= 3 (yacht/score [3 1 1 5 1] "ones")))))

(deftest score_test_5
  (testing "No ones"
    (is (= 0 (yacht/score [4 3 6 5 5] "ones")))))

(deftest score_test_6
  (testing "Twos"
    (is (= 2 (yacht/score [2 3 4 5 6] "twos")))))

(deftest score_test_7
  (testing "Fours"
    (is (= 8 (yacht/score [1 4 1 4 1] "fours")))))

(deftest score_test_8
  (testing "Yacht counted as threes"
    (is (= 15 (yacht/score [3 3 3 3 3] "threes")))))

(deftest score_test_9
  (testing "Yacht of 3s counted as fives"
    (is (= 0 (yacht/score [3 3 3 3 3] "fives")))))

(deftest score_test_10
  (testing "Fives"
    (is (= 10 (yacht/score [1 5 3 5 3] "fives")))))

(deftest score_test_11
  (testing "Sixes"
    (is (= 6 (yacht/score [2 3 4 5 6] "sixes")))))

(deftest score_test_12
  (testing "Full house two small, three big"
    (is (= 16 (yacht/score [2 2 4 4 4] "full house")))))

(deftest score_test_13
  (testing "Full house three small, two big"
    (is (= 19 (yacht/score [5 3 3 5 3] "full house")))))

(deftest score_test_14
  (testing "Two pair is not a full house"
    (is (= 0 (yacht/score [2 2 4 4 5] "full house")))))

(deftest score_test_15
  (testing "Four of a kind is not a full house"
    (is (= 0 (yacht/score [1 4 4 4 4] "full house")))))

(deftest score_test_16
  (testing "Yacht is not a full house"
    (is (= 0 (yacht/score [2 2 2 2 2] "full house")))))

(deftest score_test_17
  (testing "Four of a Kind"
    (is (= 24 (yacht/score [6 6 4 6 6] "four of a kind")))))

(deftest score_test_18
  (testing "Yacht can be scored as Four of a Kind"
    (is (= 12 (yacht/score [3 3 3 3 3] "four of a kind")))))

(deftest score_test_19
  (testing "Full house is not Four of a Kind"
    (is (= 0 (yacht/score [3 3 3 5 5] "four of a kind")))))

(deftest score_test_20
  (testing "Little Straight"
    (is (= 30 (yacht/score [3 5 4 1 2] "little straight")))))

(deftest score_test_21
  (testing "Little Straight as Big Straight"
    (is (= 0 (yacht/score [1 2 3 4 5] "big straight")))))

(deftest score_test_22
  (testing "Four in order but not a little straight"
    (is (= 0 (yacht/score [1 1 2 3 4] "little straight")))))

(deftest score_test_23
  (testing "No pairs but not a little straight"
    (is (= 0 (yacht/score [1 2 3 4 6] "little straight")))))

(deftest score_test_24
  (testing "Minimum is 1, maximum is 5, but not a little straight"
    (is (= 0 (yacht/score [1 1 3 4 5] "little straight")))))

(deftest score_test_25
  (testing "Big Straight"
    (is (= 30 (yacht/score [4 6 2 5 3] "big straight")))))

(deftest score_test_26
  (testing "Big Straight as little straight"
    (is (= 0 (yacht/score [6 5 4 3 2] "little straight")))))

(deftest score_test_27
  (testing "No pairs but not a big straight"
    (is (= 0 (yacht/score [6 5 4 3 1] "big straight")))))

(deftest score_test_28
  (testing "Choice"
    (is (= 23 (yacht/score [3 3 5 6 6] "choice")))))

(deftest score_test_29
  (testing "Yacht as choice"
    (is (= 10 (yacht/score [2 2 2 2 2] "choice")))))
