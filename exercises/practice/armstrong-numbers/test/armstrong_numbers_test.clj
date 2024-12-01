(ns armstrong-numbers-test
  (:require [clojure.test :refer [deftest is testing]]
            armstrong-numbers))

(deftest armstrong-number-0
  (testing "Zero is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 0)))))

(deftest armstrong-number-5
  (testing "Single-digit numbers are Armstrong numbers"
    (is (true? (armstrong-numbers/armstrong? 5)))))

(deftest not-armstrong-number-10
  (testing "There are no two-digit Armstrong numbers"
    (is (false? (armstrong-numbers/armstrong? 10)))))

(deftest armstrong-number-153
  (testing "Three-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 153)))))

(deftest not-armstrong-number-100
  (testing "Three-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 100)))))

(deftest armstrong-number-9474
  (testing "Four-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9474)))))

(deftest not-armstrong-number-9475
  (testing "Four-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9475)))))

(deftest armstrong-number-9926315
  (testing "Seven-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9926315)))))

(deftest not-armstrong-number-9926314
  (testing "Seven-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9926314)))))

(deftest armstrong-number-186709961001538790100634132976990
  (testing "Armstrong number containing seven zeroes"
    (is (true? (armstrong-numbers/armstrong? 186709961001538790100634132976990)))))

(deftest armstrong-number-115132219018763992565095597973971522401
  (testing "The largest and last Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 115132219018763992565095597973971522401)))))
