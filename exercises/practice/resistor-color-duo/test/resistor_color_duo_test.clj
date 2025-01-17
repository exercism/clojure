(ns resistor-color-duo-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-duo))

(deftest resistor-value_test_1
  (testing "Brown and black"
    (is (= 10 (resistor-color-duo/resistor-value ["brown" "black"])))))

(deftest resistor-value_test_2
  (testing "Blue and grey"
    (is (= 68 (resistor-color-duo/resistor-value ["blue" "grey"])))))

(deftest resistor-value_test_3
  (testing "Yellow and violet"
    (is (= 47 (resistor-color-duo/resistor-value ["yellow" "violet"])))))

(deftest resistor-value_test_4
  (testing "White and red"
    (is (= 92 (resistor-color-duo/resistor-value ["white" "red"])))))

(deftest resistor-value_test_5
  (testing "Orange and orange"
    (is (= 33 (resistor-color-duo/resistor-value ["orange" "orange"])))))

(deftest resistor-value_test_6
  (testing "Ignore additional colors"
    (is (= 51 (resistor-color-duo/resistor-value ["green" "brown" "orange"])))))

(deftest resistor-value_test_7
  (testing "Black and brown, one-digit"
    (is (= 1 (resistor-color-duo/resistor-value ["black" "brown"])))))
