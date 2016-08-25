(ns bracket-push-test
  (:require [clojure.test :refer [deftest is]]
            bracket-push))

(deftest paired-square
  (is (bracket-push/valid? "[]") "paired square brackets"))

(deftest empty-string
  (is (bracket-push/valid? "") "empty string"))

(deftest unpaired-brackets
  (is (false? (bracket-push/valid? "[[")) "unpaired brackets"))

(deftest wrong-ordered-brackets
  (is (false? (bracket-push/valid? "}{")) "wrong ordered brackets"))

(deftest paired-with-whitespace
  (is (bracket-push/valid? "{ }") "paired with whitespace"))

(deftest simple-nested-brackets
  (is (bracket-push/valid? "{[]}")
      "simple nested brackets"))

(deftest several-paired-brackets
  (is (bracket-push/valid? "{}[]")
      "several paired brackets"))

(deftest paired-and-nested-brackets
  (is (bracket-push/valid? "([{}({}[])])")
      "paired and nested brackets"))

(deftest unopened-closing-brackets
  (is (false? (bracket-push/valid? "{[)][]}"))
      "unopened closing brackets"))
 
(deftest unpaired-and-nested-brackets
  (is (false? (bracket-push/valid? "([{])"))
      "unpaired and nested brackets"))

(deftest paired-and-wrong-nested-brackets
  (is (false? (bracket-push/valid? "[({]})"))
      "paired and wrong nested brackets"))

(deftest math-expression
  (is (bracket-push/valid? "(((185 + 223.85) * 15) - 543)/2")
      "math expression"))

(deftest complex-latex-expression
  (is (bracket-push/valid? "\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)")
      "complex latex expression"))
