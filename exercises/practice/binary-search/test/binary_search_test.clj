(ns binary-search-test
  (:require [clojure.test :refer [deftest testing is]]
            binary-search))

(deftest search-for_test_1
  (testing "finds a value in a vector with one element"
    (is (= 0 (binary-search/search-for 6 [6])))))

(deftest search-for_test_2
  (testing "finds a value in the middle of a vector"
    (is (= 3 (binary-search/search-for 6 [1 3 4 6 8 9 11])))))

(deftest search-for_test_3
  (testing "finds a value at the beginning of a vector"
    (is (= 0 (binary-search/search-for 1 [1 3 4 6 8 9 11])))))

(deftest search-for_test_4
  (testing "finds a value at the end of a vector"
    (is (= 6 (binary-search/search-for 11 [1 3 4 6 8 9 11])))))

(deftest search-for_test_5
  (testing "finds a value in a vector of odd length"
    (is (= 9 (binary-search/search-for 144 [1 3 5 8 13 21 34 55 89 144 233 377 634])))))

(deftest search-for_test_6
  (testing "finds a value in a vector of even length"
    (is (= 5 (binary-search/search-for 21 [1 3 5 8 13 21 34 55 89 144 233 377])))))

(deftest search-for_test_7
  (testing "identifies that a value is not included in the vector"
    (is (= -1 (binary-search/search-for 7 [1 3 4 6 8 9 11])))))

(deftest search-for_test_8
  (testing "a value smaller than the vector's smallest value is not found"
    (is (= -1 (binary-search/search-for 0 [1 3 4 6 8 9 11])))))

(deftest search-for_test_9
  (testing "a value larger than the vector's largest value is not found"
    (is (= -1 (binary-search/search-for 13 [1 3 4 6 8 9 11])))))

(deftest search-for_test_10
  (testing "nothing is found in an empty vector"
    (is (= -1 (binary-search/search-for 1 [])))))

(deftest search-for_test_11
  (testing "nothing is found when the left and right bounds cross"
    (is (= -1 (binary-search/search-for 0 [1 2])))))
