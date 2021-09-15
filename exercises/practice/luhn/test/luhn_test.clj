(ns luhn-test
  (:require [clojure.test :refer [deftest is testing]]
            luhn))

(deftest single-digit-strings
    (is (false? (luhn/valid? "1"))))

(deftest single-zero
    (is (false? (luhn/valid? "0"))))

(deftest sin
    (is (true? (luhn/valid? " 5 9 "))))

(deftest Canadian-SIN
    (is (true? (luhn/valid? "046 454 286"))))

(deftest invalid-Canadian-SIN
    (is (false? (luhn/valid? "046 454 287"))))

(deftest invalid-credit-card
    (is (false? (luhn/valid? "8273 1232 7352 0569"))))

(deftest non-digit-added
    (is (false? (luhn/valid? "046a 454 286"))))

(deftest punctuation
    (is (false? (luhn/valid? "055-444-285"))))

(deftest symbols
    (is (false? (luhn/valid? "055£ 444$ 285"))))

(deftest single-zero-with-space
    (is (false? (luhn/valid? " 0"))))

(deftest lots-of-zeros
    (is (true? (luhn/valid? " 00000"))))

(deftest another-valid-sin
    (is (true? (luhn/valid? "055 444 285"))))

(deftest nine-doubled
    (is (true? (luhn/valid? "091"))))
