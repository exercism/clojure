(ns flatten-array-test
  (require [clojure.test :refer [deftest is testing]]
           [flatten-array]))

(deftest flattens-array-of-ints
  (testing "flattens array with just integers present"
    (is (= [1 2 3 4 5 6 7 8]
           (flatten-array/flatten [1 [2 3 4 5 6 7] 8])))))

(deftest five-level-nesting
  (testing "5 level nested list"
    (is (= [0 2 2 3 8 100 4 50 -2]
           (flatten-array/flatten [0 2 [[2 3] 8 100 4 [[[50]]]] -2])))))

(deftest six-level-nesting
  (testing "6 level nested list"
    (is (= [1 2 3 4 5 6 7 8]
           (flatten-array/flatten [1 [2 [[3]] [4 [[5]]] 6 7] 8])))))

(deftest six-level-nested-with-nils
  (testing "6 level nested list with nil values"
    (is (= [0 2 2 3 8 100 -2]
           (flatten-array/flatten [0 2 [[2 3] 8 [[100]] nil [[nil]]] -2])))))

(deftest all-nils-list
  (testing "All values in nested list are nil"
    (is (empty?
          (flatten-array/flatten [nil [[[nil]]] nil nil [[nil nil] nil] nil])))))
