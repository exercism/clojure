(ns scrabble-score-test
  (:require [clojure.test :refer [deftest testing is]]
            scrabble-score))

(deftest score-word_test_1
  (testing "lowercase letter"
    (is (= 1 (scrabble-score/score-word "a")))))

(deftest score-word_test_2
  (testing "uppercase letter"
    (is (= 1 (scrabble-score/score-word "A")))))

(deftest score-word_test_3
  (testing "valuable letter"
    (is (= 4 (scrabble-score/score-word "f")))))

(deftest score-word_test_4
  (testing "short word"
    (is (= 2 (scrabble-score/score-word "at")))))

(deftest score-word_test_5
  (testing "short, valuable word"
    (is (= 12 (scrabble-score/score-word "zoo")))))

(deftest score-word_test_6
  (testing "medium word"
    (is (= 6 (scrabble-score/score-word "street")))))

(deftest score-word_test_7
  (testing "medium, valuable word"
    (is (= 22 (scrabble-score/score-word "quirky")))))

(deftest score-word_test_8
  (testing "long, mixed-case word"
    (is (= 41 (scrabble-score/score-word "OxyphenButazone")))))

(deftest score-word_test_9
  (testing "english-like word"
    (is (= 8 (scrabble-score/score-word "pinata")))))

(deftest score-word_test_10
  (testing "empty input"
    (is (= 0 (scrabble-score/score-word "")))))

(deftest score-word_test_11
  (testing "entire alphabet available"
    (is (= 87 (scrabble-score/score-word "abcdefghijklmnopqrstuvwxyz")))))
