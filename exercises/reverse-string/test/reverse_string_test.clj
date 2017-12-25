(ns reverse-string-test
  (:require [clojure.test :refer [deftest is]]
            reverse-string))

(deftest empty-string-test
  (is (= "" (reverse-string/reverse-string ""))))

(deftest a-word-test
  (is (= "tobor" (reverse-string/reverse-string "robot"))))

(deftest capitalised-word-test
  (is (= "nemaR" (reverse-string/reverse-string "Ramen"))))

(deftest sentence-with-punctuation-test
  (is (= "!yrgnuh m'I" (reverse-string/reverse-string "I'm hungry!"))))

(deftest palindrome-test
  (is (= "racecar" (reverse-string/reverse-string "racecar"))))
