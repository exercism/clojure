(ns series-test
  (:require [clojure.test :refer [deftest is testing]]
            [series :refer [slices]]))

(deftest empty-string
  (testing "empty string with any number"
    (is (= [] (slices "" 1)))))

(deftest number-eq-zero
  (testing "number = 0"
    (is (= [""] (slices "123" 0)))))

(deftest number>string
  (testing "number > string-length"
    (is (= [] (slices "123" 1000)))))

(deftest number=string
  (testing "number = string-length"
    (is (= ["123"] (slices "123" 3)))))

(deftest number<string
  (testing "number < string-length"
    (is (= #{"123" "234" "345"} (set (slices "12345" 3))))))
