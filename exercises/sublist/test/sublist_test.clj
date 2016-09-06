(ns sublist-test
  (:require [clojure.test :refer [deftest is]]
            sublist))

(deftest empty-lists
  (is (= (sublist/classify [] []) :equal)))

(deftest empty-list-within-non-empty-list
  (is (= (sublist/classify [] [1 2 3]) :sublist)))

(deftest non-empty-list-contains-empty-list
  (is (= (sublist/classify [1 2 3] []) :superlist)))

(deftest list-equals-itself
  (is (= (sublist/classify [1 2 3] [1 2 3]) :equal)))

(deftest different-lists
  (is (= (sublist/classify [1 2 3] [2 3 4]) :unequal)))

(deftest false-start
  (is (= (sublist/classify [1 2 5] [0 1 2 3 1 2 5 6]) :sublist)))

(deftest consecutive
  (is (= (sublist/classify [1 1 2] [0 1 1 1 2 1 2]) :sublist)))

(deftest sublist-at-start
  (is (= (sublist/classify [0 1 2] [0 1 2 3 4 5]) :sublist)))

(deftest sublist-in-middle
  (is (= (sublist/classify [2 3 4] [0 1 2 3 4 5]) :sublist)))

(deftest sublist-at-end
  (is (= (sublist/classify [3 4 5] [0 1 2 3 4 5]) :sublist)))

(deftest at-start-of-superlist
  (is (= (sublist/classify [0 1 2 3 4 5] [0 1 2]) :superlist)))

(deftest in-middle-of-superlist
  (is (= (sublist/classify [0 1 2 3 4 5] []) :superlist)))

(deftest at-end-of-superlist
  (is (= (sublist/classify [0 1 2 3 4 5] [3 4 5]) :superlist)))

(deftest first-list-missing-element-from-second-list
  (is (= (sublist/classify [1 3] [1 2 3]) :unequal)))

(deftest second-list-missing-element-from-first-list
  (is (= (sublist/classify [1 2 3] [1 3]) :unequal)))

(deftest order-matters-to-a-list
  (is (= (sublist/classify [1 2 3] [3 2 1]) :unequal)))

