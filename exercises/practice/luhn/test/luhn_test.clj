(ns luhn-test
  (:require [clojure.test :refer [deftest is testing]]
            luhn))

(deftest single-digit-strings-are-invalid
  (testing "Single digit strings can not be valid"
    (is (false? (luhn/valid? "1")))))

(deftest single-zero-is-invalid
  (testing "A single zero is invalid"
    (is (false? (luhn/valid? "0")))))

(deftest simple-valid-SIN-that-remains-valid-if-reversed
  (testing "A simple valid SIN that remains valid if reversed"
    (is (true? (luhn/valid? "059")))))

(deftest simple-valid-SIN-that-becomes-invalid-if-reversed
  (testing "A simple valid SIN that becomes invalid if reversed"
    (is (true? (luhn/valid? "59")))))

(deftest valid-canadian-SIN
  (testing "A valid Canadian SIN"
    (is (true? (luhn/valid? "055 444 285")))))

(deftest invalid-canadian-SIN
  (testing "Invalid Canadian SIN"
    (is (false? (luhn/valid? "055 444 286")))))

(deftest invalid-credit-card
  (testing "Invalid credit card"
    (is (false? (luhn/valid? "8273 1232 7352 0569")))))

(deftest invalid-long-number-with-an-even-remainder
  (testing "Invalid long number with an even remainder"
    (is (false? (luhn/valid? "1 2345 6789 1234 5678 9012")))))

(deftest invalid-long-number-with-a-remainder-divisible-by-5
  (testing "Invalid long number with a remainder divisible by 5"
    (is (false? (luhn/valid? "1 2345 6789 1234 5678 9013")))))

(deftest valid-number-with-an-even-number-of-digits
  (testing "Valid number with an even number of digits"
    (is (true? (luhn/valid? "095 245 88")))))

(deftest valid-number-with-an-odd-number-of-spaces
  (testing "Valid number with an odd number of spaces"
    (is (true? (luhn/valid? "234 567 891 234")))))

(deftest valid-strings-with-a-non-digit-added-at-the-end-become-invalid
  (testing "Valid strings with a non-digit added at the end become invalid"
    (is (false? (luhn/valid? "059a")))))

(deftest valid-strings-with-punctuation-included-become-invalid
  (testing "Valid strings with punctuation included become invalid"
    (is (false? (luhn/valid? "055-444-285")))))

(deftest valid-strings-with-symbols-included-become-invalid
  (testing "Valid strings with symbols included become invalid"
    (is (false? (luhn/valid? "055# 444$ 285")))))

(deftest single-zero-with-space-is-invalid
  (testing "Single zero with space is invalid"
    (is (false? (luhn/valid? " 0")))))

(deftest more-than-a-single-zero-is-valid
  (testing "More than a single zero is valid"
    (is (true? (luhn/valid? "0000 0")))))

(deftest input-digit-9-is-correctly-converted-to-output-digit-9
  (testing "Input digit 9 is correctly converted to output digit 9"
    (is (true? (luhn/valid? "091")))))

(deftest very-long-input-is-valid
  (testing "Very long input is valid"
    (is (true? (luhn/valid? "9999999999 9999999999 9999999999 9999999999")))))

(deftest valid-luhn-with-an-odd-number-of-digits-and-non-zero-first-digit
  (testing "Valid luhn with an odd number of digits and non zero first digit"
    (is (true? (luhn/valid? "109")))))

(deftest using-ascii-value-for-non-doubled-non-digit-is-not-allowed
  (testing "Using ascii value for non-doubled non-digit isn't allowed"
    (is (false? (luhn/valid? "055b 444 285")))))

(deftest using-ascii-value-for-doubled-non-digit-is-not-allowed
  (testing "Using ascii value for doubled non-digit isn't allowed"
    (is (false? (luhn/valid? ":9")))))

(deftest non-numeric-non-space-char-in-middle-with-sum-that-is-divisible-by-10-is-not-allowed
  (testing "Non-numeric, non-space char in the middle with a sum that's divisible by 10 isn't allowed"
    (is (false? (luhn/valid? "59%59")))))
