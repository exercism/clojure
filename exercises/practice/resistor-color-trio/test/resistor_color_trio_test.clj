(ns resistor-color-trio-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-trio))

(deftest resistor-label_test_1
  (testing "Orange and orange and black"
    (is (= "33 ohms" (resistor-color-trio/resistor-label ["orange" "orange" "black"])))))

(deftest resistor-label_test_2
  (testing "Blue and grey and brown"
    (is (= "680 ohms" (resistor-color-trio/resistor-label ["blue" "grey" "brown"])))))

(deftest resistor-label_test_3
  (testing "Red and black and red"
    (is (= "2 kiloohms" (resistor-color-trio/resistor-label ["red" "black" "red"])))))

(deftest resistor-label_test_4
  (testing "Green and brown and orange"
    (is (= "51 kiloohms" (resistor-color-trio/resistor-label ["green" "brown" "orange"])))))

(deftest resistor-label_test_5
  (testing "Yellow and violet and yellow"
    (is (= "470 kiloohms" (resistor-color-trio/resistor-label ["yellow" "violet" "yellow"])))))

(deftest resistor-label_test_6
  (testing "Blue and violet and blue"
    (is (= "67 megaohms" (resistor-color-trio/resistor-label ["blue" "violet" "blue"])))))

(deftest resistor-label_test_7
  (testing "Minimum possible value"
    (is (= "0 ohms" (resistor-color-trio/resistor-label ["black" "black" "black"])))))

(deftest resistor-label_test_8
  (testing "Maximum possible value"
    (is (= "99 gigaohms" (resistor-color-trio/resistor-label ["white" "white" "white"])))))

(deftest resistor-label_test_9
  (testing "First two colors make an invalid octal number"
    (is (= "8 ohms" (resistor-color-trio/resistor-label ["black" "grey" "black"])))))

(deftest resistor-label_test_10
  (testing "Ignore extra colors"
    (is (= "650 kiloohms" (resistor-color-trio/resistor-label ["blue" "green" "yellow" "orange"])))))
