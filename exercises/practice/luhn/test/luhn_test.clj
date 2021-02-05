(ns luhn-test
  (:require [clojure.test :refer [deftest is testing]]
            luhn))

(deftest validity-tests
  (testing "single digit strings can not be valid"
    (is (false? (luhn/valid? "1"))))
  (testing "A single zero is invalid"
    (is (false? (luhn/valid? "0"))))
  (testing "simple valid sin"
    (is (true? (luhn/valid? " 5 9 "))))
  (testing "valid Canadian SIN"
    (is (true? (luhn/valid? "046 454 286"))))
  (testing "invalid Canadian SIN"
    (is (false? (luhn/valid? "046 454 287"))))
  (testing "invalid credit card"
    (is (false? (luhn/valid? "8273 1232 7352 0569"))))
  (testing "valid strings with a non-digit added become invalid"
    (is (false? (luhn/valid? "046a 454 286"))))
  (testing "punctuation is not allowed"
    (is (false? (luhn/valid? "055-444-285"))))
  (testing "symbols are not allowed"
    (is (false? (luhn/valid? "055£ 444$ 285"))))
  (testing "single zero with space is invalid"
    (is (false? (luhn/valid? " 0"))))
  (testing "lots of zeros are valid"
    (is (true? (luhn/valid? " 00000"))))
  (testing "another valid sin"
    (is (true? (luhn/valid? "055 444 285"))))
  (testing "nine doubled is nine"
    (is (true? (luhn/valid? "091")))))
