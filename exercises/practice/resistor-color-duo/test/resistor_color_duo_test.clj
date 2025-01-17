(ns resistor-color-duo-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-duo))

(deftest value_test_1
  (testing "Brown and black"
    (is (= 10 (resistor-color-duo/value ["brown" "black"])))))

(deftest value_test_2
  (testing "Blue and grey"
    (is (= 68 (resistor-color-duo/value ["blue" "grey"])))))

(deftest value_test_3
  (testing "Yellow and violet"
    (is (= 47 (resistor-color-duo/value ["yellow" "violet"])))))

(deftest value_test_4
  (testing "White and red"
    (is (= 92 (resistor-color-duo/value ["white" "red"])))))

(deftest value_test_5
  (testing "Orange and orange"
    (is (= 33 (resistor-color-duo/value ["orange" "orange"])))))

(deftest value_test_6
  (testing "Ignore additional colors"
    (is (= 51 (resistor-color-duo/value ["green" "brown" "orange"])))))

(deftest value_test_7
  (testing "Black and brown, one-digit"
    (is (= 1 (resistor-color-duo/value ["black" "brown"])))))
