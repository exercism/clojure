(ns scrabble-score-test
  (:require [clojure.test :refer [deftest is]]
            scrabble-score))

(deftest lower-case-letter
  (is (= 1 (scrabble-score/score-letter "a"))))

(deftest upper-case-letter
  (is (= 1 (scrabble-score/score-letter "A"))))

(deftest two-letter-word
  (is (= 2 (scrabble-score/score-word "at"))))

(deftest bigger-word-1
  (is (= 6 (scrabble-score/score-word "street"))))

(deftest bigger-word-2
  (is (= 22 (scrabble-score/score-word "quirky"))))

(deftest all-upper-case-word
  (is (= 41 (scrabble-score/score-word "OXYPHENBUTAZONE"))))
