(ns reverse-string-test
  (:require [clojure.test :refer [deftest testing is]]
            reverse-string))

(deftest reverse-string_test_1
  (testing "an empty string"
    (is (= "" (reverse-string/reverse-string "")))))

(deftest reverse-string_test_2
  (testing "a word"
    (is (= "tobor" (reverse-string/reverse-string "robot")))))

(deftest reverse-string_test_3
  (testing "a capitalized word"
    (is (= "nemaR" (reverse-string/reverse-string "Ramen")))))

(deftest reverse-string_test_4
  (testing "a sentence with punctuation"
    (is (= "!yrgnuh m'I" (reverse-string/reverse-string "I'm hungry!")))))

(deftest reverse-string_test_5
  (testing "a palindrome"
    (is (= "racecar" (reverse-string/reverse-string "racecar")))))

(deftest reverse-string_test_6
  (testing "an even-sized word"
    (is (= "reward" (reverse-string/reverse-string "drawer")))))

(deftest reverse-string_test_7
  (testing "wide characters"
    (is (= "猫子" (reverse-string/reverse-string "子猫")))))
