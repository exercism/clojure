(ns resistor-color-trio-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-trio))

(deftest label_test_1
  (testing "Orange and orange and black"
    (is (= "33 ohms" (resistor-color-trio/label ["orange" "orange" "black"])))))

(deftest label_test_2
  (testing "Blue and grey and brown"
    (is (= "680 ohms" (resistor-color-trio/label ["blue" "grey" "brown"])))))

(deftest label_test_3
  (testing "Red and black and red"
    (is (= "2 kiloohms" (resistor-color-trio/label ["red" "black" "red"])))))

(deftest label_test_4
  (testing "Green and brown and orange"
    (is (= "51 kiloohms" (resistor-color-trio/label ["green" "brown" "orange"])))))

(deftest label_test_5
  (testing "Yellow and violet and yellow"
    (is (= "470 kiloohms" (resistor-color-trio/label ["yellow" "violet" "yellow"])))))

(deftest label_test_6
  (testing "Blue and violet and blue"
    (is (= "67 megaohms" (resistor-color-trio/label ["blue" "violet" "blue"])))))

(deftest label_test_7
  (testing "Minimum possible value"
    (is (= "0 ohms" (resistor-color-trio/label ["black" "black" "black"])))))

(deftest label_test_8
  (testing "Maximum possible value"
    (is (= "99 gigaohms" (resistor-color-trio/label ["white" "white" "white"])))))

(deftest label_test_9
  (testing "First two colors make an invalid octal number"
    (is (= "8 ohms" (resistor-color-trio/label ["black" "grey" "black"])))))

(deftest label_test_10
  (testing "Ignore extra colors"
    (is (= "650 kiloohms" (resistor-color-trio/label ["blue" "green" "yellow" "orange"])))))
