(ns reverse-string-test
  (:require [clojure.test :refer [deftest testing is]]
            [reverse-string :refer [reverse-string]]))

(deftest empty-string
  (testing "An empty string"
    (is (= "" (reverse-string "")))))

(deftest a-word
  (testing "A word"
    (is (= "tobor" (reverse-string "robot")))))

(deftest capitalised-word
  (testing "A capitalized word"
    (is (= "nemaR" (reverse-string "Ramen")))))

(deftest sentence-with-punctuation
  (testing "A sentence with punctuation"
    (is (= "!yrgnuh m'I" (reverse-string "I'm hungry!")))))

(deftest palindrome
  (testing "A palindrome"
    (is (= "racecar" (reverse-string "racecar")))))

(deftest even-sized-word
  (testing "An even sized word"
    (is (= "reward" (reverse-string "drawer")))))
