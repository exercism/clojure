(ns octal-test
  (:require [clojure.test :refer [deftest is testing]]
            [octal :refer [to-decimal]]))

(deftest octal-1-is-decimal-1
  (testing "1 should still be 1"
    (is (= 1 (to-decimal "1")))))

(deftest octal-2-is-decimal-2
  (testing "2 should still be 2"
    (is (= 2 (to-decimal "2")))))

(deftest octal-10-is-decimal-8
  (testing "10 should be 8"
    (is (= 8 (to-decimal "10")))))

(deftest octal-11-is-decimal-9
  (testing "11 should be 9"
    (is (= 9 (to-decimal "11")))))

(deftest octal-17-is-decimal-15
  (testing "17 should be 15"
    (is (= 15 (to-decimal "17")))))

(deftest octal-130-is-decimal-88
  (testing "130 should be 88"
    (is (= 88 (to-decimal "130")))))

(deftest octal-2047-is-decimal-1063
  (testing "2047 should be 1063"
    (is (= 1063 (to-decimal "2047")))))

(deftest octal-7777-is-decimal-4095
  (testing "7777 should be 4095"
    (is (= 4095 (to-decimal "7777")))))

(deftest octal-1234567-is-decimal-342391
  (testing "1234567 should be 342391"
    (is (= 342391 (to-decimal "1234567")))))

(deftest invalid-input-is-decimal-0
  (testing "carrot should be invalid"
    (is (= 0 (to-decimal "carrot")))))

(deftest eight-is-invalid-input-decimal-0
  (testing "8 should be invalid and return 0"
    (is (= 0 (to-decimal "8")))))

(deftest nine-is-invalid-input-decimal-0
  (testing "9 should be invalid and return 0"
    (is (= 0 (to-decimal "9")))))

(deftest invalid-input-6789-is-decimal-0
  (testing "6789 should be invalid and return 0"
    (is (= 0 (to-decimal "6789")))))

(deftest invalid-input-with-digits-is-decimal-0
  (testing "abc1z should be 0"
    (is (= 0 (to-decimal "abc1z")))))

(deftest leading-zero-is-okay
  (testing "Leading zero should be valid octal"
    (is (= 9 (to-decimal "011")))))