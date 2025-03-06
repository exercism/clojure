(ns flatten-array-test
  (:require [clojure.test :refer [deftest testing is]]
            flatten-array))

(deftest flatten_test_1
  (testing "empty"
    (is (= []
           (flatten-array/flatten [])))))

(deftest flatten_test_2
  (testing "no nesting"
    (is (= [0 1 2]
           (flatten-array/flatten [0 1 2])))))

(deftest flatten_test_3
  (testing "flattens a nested vector"
    (is (= []
           (flatten-array/flatten [[[]]])))))

(deftest flatten_test_4
  (testing "flattens vector with just integers present"
    (is (= [1 2 3 4 5 6 7 8]
           (flatten-array/flatten [1 [2 3 4 5 6 7] 8])))))

(deftest flatten_test_5
  (testing "5 level nesting"
    (is (= [0 2 2 3 8 100 4 50 -2]
           (flatten-array/flatten [0 2 [[2 3] 8 100 4 [[[50]]]] -2])))))

(deftest flatten_test_6
  (testing "6 level nesting"
    (is (= [1 2 3 4 5 6 7 8]
           (flatten-array/flatten [1 [2 [[3]] [4 [[5]]] 6 7] 8])))))

(deftest flatten_test_7
  (testing "nil values are omitted from the final result"
    (is (= [1 2]
           (flatten-array/flatten [1 2 nil])))))

(deftest flatten_test_8
  (testing "consecutive nil values at the front of the vector are omitted from the final result"
    (is (= [3]
           (flatten-array/flatten [nil nil 3])))))

(deftest flatten_test_9
  (testing "consecutive nil values in the middle of the vector are omitted from the final result"
    (is (= [1 4]
           (flatten-array/flatten [1 nil nil 4])))))

(deftest flatten_test_10
  (testing "6 level nested vector with nil values"
    (is (= [0 2 2 3 8 100 -2]
           (flatten-array/flatten [0 2 [[2 3] 8 [[100]] nil [[nil]]] -2])))))

(deftest flatten_test_11
  (testing "all values in nested vector are nil"
    (is (= []
           (flatten-array/flatten [nil [[[nil]]] nil nil [[nil nil] nil] nil])))))
