(ns binary-search-test
  (:require [clojure.test :refer [deftest is testing]]
            binary-search))

(deftest finds-value-in-array-with-one-element
  (testing "Finds a value in an array with one element"
           (is (= 0 (binary-search/search-for 6 [6])))))

(deftest finds-value-in-middle-of-array
  (testing "Finds a value in the middle of an array"
    (is (= 3 (binary-search/search-for 6 [1, 3, 4, 6, 8, 9, 11])))))

(deftest finds-value-at-beginning-of-array
  (testing "Finds a value at the beginning of an array"
    (is (= 0 (binary-search/search-for 1 [1, 3, 4, 6, 8, 9, 11])))))

(deftest finds-value-at-end-of-array
  (testing "Finds a value at the end of an array"
    (is (= 6 (binary-search/search-for 11 [1, 3, 4, 6, 8, 9, 11])))))

(deftest finds-value-in-array-of-odd-length
  (testing "Finds a value in an array of odd length"
    (is (= 9 (binary-search/search-for 144 [1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634])))))

(deftest finds-value-in-array-of-even-length
  (testing "Finds a value in an array of even length"
    (is (= 5 (binary-search/search-for 21 [1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377])))))

(deftest identifies-that-value-is-not-in-array
  (testing "Identifies that a value is not included in the array"
    (is (thrown-with-msg? Throwable #"not found"
                          (binary-search/search-for 7 [1, 3, 4, 6, 8, 9, 11])))))

(deftest value-smaller-than-arrays-smallest-value-not-found
  (testing "A value smaller than the array's smallest value is not found"
    (is (thrown-with-msg? Throwable #"not found"
                          (binary-search/search-for 0 [1, 3, 4, 6, 8, 9, 11])))))

(deftest value-larger-than-arrays-largest-value-not-found
  (testing "A value larger than the array's largest value is not found"
    (is (thrown-with-msg? Throwable #"not found"
                          (binary-search/search-for 13 [1, 3, 4, 6, 8, 9, 11])))))

(deftest nothing-found-in-empty-array
  (testing "Nothing is found in an empty array"
    (is (thrown-with-msg? Throwable #"not found"
                          (binary-search/search-for 1 [])))))

(deftest nothing-found-when-left-and-right-bounds-cross
  (testing "Nothing is found when the left and right bounds cross"
    (is (thrown-with-msg? Throwable #"not found"
                          (binary-search/search-for 0 [1, 2])))))
