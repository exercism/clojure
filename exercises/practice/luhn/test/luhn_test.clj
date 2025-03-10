(ns luhn-test
  (:require [clojure.test :refer [deftest testing is]]
            luhn))

(deftest valid?_test_1
  (testing "single digit strings can not be valid"
    (is (false? (luhn/valid? "1")))))

(deftest valid?_test_2
  (testing "a single zero is invalid"
    (is (false? (luhn/valid? "0")))))

(deftest valid?_test_3
  (testing "a simple valid SIN that remains valid if reversed"
    (is (true? (luhn/valid? "059")))))

(deftest valid?_test_4
  (testing "a simple valid SIN that becomes invalid if reversed"
    (is (true? (luhn/valid? "59")))))

(deftest valid?_test_5
  (testing "a valid Canadian SIN"
    (is (true? (luhn/valid? "055 444 285")))))

(deftest valid?_test_6
  (testing "invalid Canadian SIN"
    (is (false? (luhn/valid? "055 444 286")))))

(deftest valid?_test_7
  (testing "invalid credit card"
    (is (false? (luhn/valid? "8273 1232 7352 0569")))))

(deftest valid?_test_8
  (testing "invalid long number with an even remainder"
    (is (false? (luhn/valid? "1 2345 6789 1234 5678 9012")))))

(deftest valid?_test_9
  (testing "invalid long number with a remainder divisible by 5"
    (is (false? (luhn/valid? "1 2345 6789 1234 5678 9013")))))

(deftest valid?_test_10
  (testing "valid number with an even number of digits"
    (is (true? (luhn/valid? "095 245 88")))))

(deftest valid?_test_11
  (testing "valid number with an odd number of spaces"
    (is (true? (luhn/valid? "234 567 891 234")))))

(deftest valid?_test_12
  (testing "valid strings with a non-digit added at the end become invalid"
    (is (false? (luhn/valid? "059a")))))

(deftest valid?_test_13
  (testing "valid strings with punctuation included become invalid"
    (is (false? (luhn/valid? "055-444-285")))))

(deftest valid?_test_14
  (testing "valid strings with symbols included become invalid"
    (is (false? (luhn/valid? "055# 444$ 285")))))

(deftest valid?_test_15
  (testing "single zero with space is invalid"
    (is (false? (luhn/valid? " 0")))))

(deftest valid?_test_16
  (testing "more than a single zero is valid"
    (is (true? (luhn/valid? "0000 0")))))

(deftest valid?_test_17
  (testing "input digit 9 is correctly converted to output digit 9"
    (is (true? (luhn/valid? "091")))))

(deftest valid?_test_18
  (testing "very long input is valid"
    (is (true? (luhn/valid? "9999999999 9999999999 9999999999 9999999999")))))

(deftest valid?_test_19
  (testing "valid luhn with an odd number of digits and non zero first digit"
    (is (true? (luhn/valid? "109")))))

(deftest valid?_test_20
  (testing "using ascii value for non-doubled non-digit isn't allowed"
    (is (false? (luhn/valid? "055b 444 285")))))

(deftest valid?_test_21
  (testing "using ascii value for doubled non-digit isn't allowed"
    (is (false? (luhn/valid? ":9")))))

(deftest valid?_test_22
  (testing "non-numeric, non-space char in the middle with a sum that's divisible by 10 isn't allowed"
    (is (false? (luhn/valid? "59%59")))))
