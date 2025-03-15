(ns grains-test
  (:require [clojure.test :refer [deftest testing is]]
            grains))

(deftest square_test_1
  (testing "grains on square 1"
    (is (= 1 (grains/square 1)))))

(deftest square_test_2
  (testing "grains on square 2"
    (is (= 2 (grains/square 2)))))

(deftest square_test_3
  (testing "grains on square 3"
    (is (= 4 (grains/square 3)))))

(deftest square_test_4
  (testing "grains on square 4"
    (is (= 8 (grains/square 4)))))

(deftest square_test_5
  (testing "grains on square 16"
    (is (= 32768 (grains/square 16)))))

(deftest square_test_6
  (testing "grains on square 32"
    (is (= 2147483648 (grains/square 32)))))

(deftest square_test_7
  (testing "grains on square 64"
    (is (= 9223372036854775808 (grains/square 64)))))

(deftest total_test_1
  (testing "returns the total number of grains on the board"
    (is (= 18446744073709551615 (grains/total)))))
