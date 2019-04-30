(ns matching-brackets-test
  (:require [clojure.test :refer [deftest is]]
            matching-brackets))

(deftest paired-square
  (is (matching-brackets/valid? "[]") "paired square brackets"))

(deftest empty-string
  (is (matching-brackets/valid? "") "empty string"))

(deftest unpaired-brackets
  (is (false? (matching-brackets/valid? "[[")) "unpaired brackets"))

(deftest wrong-ordered-brackets
  (is (false? (matching-brackets/valid? "}{")) "wrong ordered brackets"))

(deftest paired-with-whitespace
  (is (matching-brackets/valid? "{ }") "paired with whitespace"))

(deftest simple-nested-brackets
  (is (matching-brackets/valid? "{[]}")
      "simple nested brackets"))

(deftest several-paired-brackets
  (is (matching-brackets/valid? "{}[]")
      "several paired brackets"))

(deftest paired-and-nested-brackets
  (is (matching-brackets/valid? "([{}({}[])])")
      "paired and nested brackets"))

(deftest unopened-closing-brackets
  (is (false? (matching-brackets/valid? "{[)][]}"))
      "unopened closing brackets"))
 
(deftest unpaired-and-nested-brackets
  (is (false? (matching-brackets/valid? "([{])"))
      "unpaired and nested brackets"))

(deftest paired-and-wrong-nested-brackets
  (is (false? (matching-brackets/valid? "[({]})"))
      "paired and wrong nested brackets"))

(deftest math-expression
  (is (matching-brackets/valid? "(((185 + 223.85) * 15) - 543)/2")
      "math expression"))

(deftest complex-latex-expression
  (is (matching-brackets/valid? "\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)")
      "complex latex expression"))
