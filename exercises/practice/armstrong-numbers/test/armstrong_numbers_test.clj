(ns armstrong-numbers-test
  (:require [clojure.test :refer [deftest is testing]]
            armstrong-numbers))

(deftest test-c1ed103c-258d-45b2-be73-d8c6d9580c7b
  (testing "Zero is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 0)))))

(deftest test-579e8f03-9659-4b85-a1a2-d64350f6b17a
  (testing "Single-digit numbers are Armstrong numbers"
    (is (true? (armstrong-numbers/armstrong? 5)))))

(deftest test-2d6db9dc-5bf8-4976-a90b-b2c2b9feba60
  (testing "There are no two-digit Armstrong numbers"
    (is (false? (armstrong-numbers/armstrong? 10)))))

(deftest test-509c087f-e327-4113-a7d2-26a4e9d18283
  (testing "Three-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 153)))))

(deftest test-7154547d-c2ce-468d-b214-4cb953b870cf
  (testing "Three-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 100)))))

(deftest test-6bac5b7b-42e9-4ecb-a8b0-4832229aa103
  (testing "Four-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9474)))))

(deftest test-eed4b331-af80-45b5-a80b-19c9ea444b2e
  (testing "Four-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9475)))))

(deftest test-f971ced7-8d68-4758-aea1-d4194900b864
  (testing "Seven-digit number that is an Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 9926315)))))

(deftest test-7ee45d52-5d35-4fbd-b6f1-5c8cd8a67f18
  (testing "Seven-digit number that is not an Armstrong number"
    (is (false? (armstrong-numbers/armstrong? 9926314)))))

(deftest test-5ee2fdf8-334e-4a46-bb8d-e5c19c02c148
  (testing "Armstrong number containing seven zeroes"
    (is (true? (armstrong-numbers/armstrong? 186709961001538790100634132976990)))))

(deftest test-12ffbf10-307a-434e-b4ad-c925680e1dd4
  (testing "The largest and last Armstrong number"
    (is (true? (armstrong-numbers/armstrong? 115132219018763992565095597973971522401)))))
