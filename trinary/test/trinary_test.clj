(ns trinary-test
  (:require [clojure.test :refer [deftest is testing]]
            [trinary :refer [to-decimal]]))

(deftest trinary-1-is-decimal-1
  (testing "1 should still be 1"
    (is (= 1 (to-decimal "1")))))

(deftest trinary-2-is-decimal-2
  (testing "2 should still be 2"
    (is (= 2 (to-decimal "2")))))

(deftest trinary-10-is-decimal-3
  (testing "10 should be 3"
    (is (= 3 (to-decimal "10")))))

(deftest trinary-11-is-decimal-4
  (testing "11 should be 4"
    (is (= 4 (to-decimal "11")))))

(deftest trinary-100-is-decimal-9
  (testing "100 should be 9"
    (is (= 9 (to-decimal "100")))))

(deftest trinary-112-is-decimal-14
  (testing "112 should be 14"
    (is (= 14 (to-decimal "112")))))

(deftest trinary-222-is-decimal-26
  (testing "222 should be 26"
    (is (= 26 (to-decimal "222")))))

(deftest trinary-1122000120-is-decimal-32091
  (testing "1122000120 should be 32091"
    (is (= 32091 (to-decimal "1122000120")))))

(deftest invalid-input-is-decimal-0
  (testing "carrot should be invalid"
    (is (= 0 (to-decimal "carrot")))))

(deftest invalid-input-with-digits-is-decimal-0
  (testing "0a1b2c should be 0"
    (is (= 0 (to-decimal "0a1b2c")))))
