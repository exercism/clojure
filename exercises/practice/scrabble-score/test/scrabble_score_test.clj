(ns scrabble-score-test
  (:require [clojure.test :refer [deftest testing is]]
            scrabble-score))

(deftest lowercase-letter
  (testing "Lowercase letter"
    (is (= 1 (scrabble-score/score-word "a")))))

(deftest uppercase-letter
  (testing "Uppercase letter"
    (is (= 1 (scrabble-score/score-word "A")))))

(deftest valuable-letter
  (testing "Valuable letter"
    (is (= 4 (scrabble-score/score-word "f")))))

(deftest short-word
  (testing "Short word"
    (is (= 2 (scrabble-score/score-word "at")))))

(deftest short-valuable-word
  (testing "Short, valuable word"
    (is (= 12 (scrabble-score/score-word "zoo")))))

(deftest medium-word
  (testing "Medium word"
    (is (= 6 (scrabble-score/score-word "street")))))

(deftest medium-valuable-word
  (testing "medium, valuable word"
    (is (= 22 (scrabble-score/score-word "quirky")))))

(deftest long-mixed-case-word
  (testing "Long, mixed-case word"
    (is (= 41 (scrabble-score/score-word "OxyphenButazone")))))

(deftest english-like-word
  (testing "English-like word"
    (is (= 8 (scrabble-score/score-word "pinata")))))

(deftest empty-input
  (testing "Empty input"
    (is (= 0 (scrabble-score/score-word "")))))

(deftest entire-alphabet-available
  (testing "Entire alphabet available"
    (is (= 87 (scrabble-score/score-word "abcdefghijklmnopqrstuvwxyz")))))
