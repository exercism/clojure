(ns matching-brackets-test
  (:require [clojure.test :refer [deftest testing is]]
            matching-brackets))

(deftest valid?_test_1
  (testing "paired square brackets"
    (is (true? (matching-brackets/valid? "[]")))))

(deftest valid?_test_2
  (testing "empty string"
    (is (true? (matching-brackets/valid? "")))))

(deftest valid?_test_3
  (testing "unpaired brackets"
    (is (false? (matching-brackets/valid? "[[")))))

(deftest valid?_test_4
  (testing "wrong ordered brackets"
    (is (false? (matching-brackets/valid? "}{")))))

(deftest valid?_test_5
  (testing "wrong closing bracket"
    (is (false? (matching-brackets/valid? "{]")))))

(deftest valid?_test_6
  (testing "paired with whitespace"
    (is (true? (matching-brackets/valid? "{ }")))))

(deftest valid?_test_7
  (testing "partially paired brackets"
    (is (false? (matching-brackets/valid? "{[])")))))

(deftest valid?_test_8
  (testing "simple nested brackets"
    (is (true? (matching-brackets/valid? "{[]}")))))

(deftest valid?_test_9
  (testing "several paired brackets"
    (is (true? (matching-brackets/valid? "{}[]")))))

(deftest valid?_test_10
  (testing "paired and nested brackets"
    (is (true? (matching-brackets/valid? "([{}({}[])])")))))

(deftest valid?_test_11
  (testing "unopened closing brackets"
    (is (false? (matching-brackets/valid? "{[)][]}")))))

(deftest valid?_test_12
  (testing "unpaired and nested brackets"
    (is (false? (matching-brackets/valid? "([{])")))))

(deftest valid?_test_13
  (testing "paired and wrong nested brackets"
    (is (false? (matching-brackets/valid? "[({]})")))))

(deftest valid?_test_14
  (testing "paired and wrong nested brackets but innermost are correct"
    (is (false? (matching-brackets/valid? "[({}])")))))

(deftest valid?_test_15
  (testing "paired and incomplete brackets"
    (is (false? (matching-brackets/valid? "{}[")))))

(deftest valid?_test_16
  (testing "too many closing brackets"
    (is (false? (matching-brackets/valid? "[]]")))))

(deftest valid?_test_17
  (testing "early unexpected brackets"
    (is (false? (matching-brackets/valid? ")()")))))

(deftest valid?_test_18
  (testing "early mismatched brackets"
    (is (false? (matching-brackets/valid? "{)()")))))

(deftest valid?_test_19
  (testing "math expression"
    (is (true? (matching-brackets/valid? "(((185 + 223.85) * 15) - 543)/2")))))

(deftest valid?_test_20
  (testing "complex latex expression"
    (is (true? (matching-brackets/valid? "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)")))))
