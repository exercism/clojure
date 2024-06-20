(ns matching-brackets-test
  (:require [clojure.test :refer [deftest testing is]]
            matching-brackets))

(deftest paired-square-brackets
  (testing "paired square brackets"
    (is (matching-brackets/valid? "[]"))))

(deftest empty-string
  (testing "Empty string"
    (is (matching-brackets/valid? ""))))

(deftest unpaired-brackets
  (testing "Unpaired brackets"
    (is (false? (matching-brackets/valid? "[[")))))

(deftest wrong-ordered-brackets
  (testing "Wrong ordered brackets"
    (is (false? (matching-brackets/valid? "}{")))))

(deftest wrong-closing-bracket
  (testing "Wrong closing bracket"
    (is (false? (matching-brackets/valid? "{]")))))

(deftest paired-with-whitespace
  (testing "Paired with whitespace"
    (is (matching-brackets/valid? "{ }"))))

(deftest partially-paired-brackets
  (testing "Partially paired brackets"
    (is (false? (matching-brackets/valid? "{[])")))))

(deftest simple-nested-brackets
  (testing "Simple nested brackets"
    (is (matching-brackets/valid? "{[]}"))))

(deftest several-paired-brackets
  (testing "Several paired brackets"
    (is (matching-brackets/valid? "{}[]"))))

(deftest paired-and-nested-brackets
  (testing "Paired and nested brackets"
    (is (matching-brackets/valid? "([{}({}[])])"))))

(deftest unopened-closing-brackets
  (testing "Unopened closing brackets"
    (is (false? (matching-brackets/valid? "{[)][]}")))))
 
(deftest unpaired-and-nested-brackets
  (testing "Unpaired and nested brackets"
    (is (false? (matching-brackets/valid? "([{])")))))

(deftest paired-and-wrong-nested-brackets
  (testing "Paired and wrong nested brackets"
    (is (false? (matching-brackets/valid? "[({]})")))))

(deftest paired-and-wrong-nested-brackets-but-innermost-are-correct
  (testing "Paired and wrong nested brackets but innermost are correct"
    (is (false? (matching-brackets/valid? "[({}])")))))

(deftest paired-and-incomplete-brackets
  (testing "Paired and incomplete brackets"
    (is (false? (matching-brackets/valid? "{}[")))))

(deftest too-many-closing-brackets
  (testing "Too many closing brackets"
    (is (false? (matching-brackets/valid? "[]]")))))

(deftest early-unexpected-brackets
  (testing "Early unexpected brackets"
    (is (false? (matching-brackets/valid? ")()")))))

(deftest early-mismatched-brackets
  (testing "Early mismatched brackets"
    (is (false? (matching-brackets/valid? "{)()")))))

(deftest math-expression
  (testing "Math expression"
    (is (matching-brackets/valid? "(((185 + 223.85) * 15) - 543)/2"))))

(deftest complex-latex-expression
  (testing "Complex latex expression"
    (is (matching-brackets/valid? "\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)"))))
