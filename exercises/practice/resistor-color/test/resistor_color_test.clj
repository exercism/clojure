(ns resistor-color-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color))

(deftest colors_test_1
  (testing "Colors"
    (is (= ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"]
           resistor-color/colors))))

(deftest color-code_test_1
  (testing "Color codes ▶ Black"
    (is (= 0 (resistor-color/color-code "black")))))

(deftest color-code_test_2
  (testing "Color codes ▶ White"
    (is (= 9 (resistor-color/color-code "white")))))

(deftest color-code_test_3
  (testing "Color codes ▶ Orange"
    (is (= 3 (resistor-color/color-code "orange")))))
