(ns armstrong-numbers-test
  (:require [clojure.test :refer [deftest testing is]]
            armstrong-numbers))

(deftest armstrong?_test_1
  (testing "Zero is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 0)))))

(deftest armstrong?_test_2
  (testing "Single-digit numbers are Armstrong numbers"
    (is (true? (armstrong-numbers/armstrong? 5)))))

(deftest armstrong?_test_3
  (testing "There are no two-digit Armstrong numbers"
    (is (false? (armstrong-numbers/armstrong? 10)))))

(deftest armstrong?_test_4
  (testing "Three-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 153)))))

(deftest armstrong?_test_5
  (testing "Three-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 100)))))

(deftest armstrong?_test_6
  (testing "Four-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9474)))))

(deftest armstrong?_test_7
  (testing "Four-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9475)))))

(deftest armstrong?_test_8
  (testing "Seven-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9926315)))))

(deftest armstrong?_test_9
  (testing "Seven-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9926314)))))

(deftest armstrong?_test_10
  (testing "Armstrong number containing seven zeroes"
    (is (true? (armstrong-numbers/armstrong? 186709961001538790100634132976990)))))

(deftest armstrong?_test_11
  (testing "The largest and last Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 115132219018763992565095597973971522401)))))
