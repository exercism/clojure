(ns elyses-destructured-enchantments-test
  (:require [clojure.test :refer :all]
            [elyses-destructured-enchantments :refer :all]))

(deftest ^{:task 1} first-card-single-test
  (is (= 3 (first-card [3]))))

(deftest ^{:task 1} first-card-multiple-test
  (is (= 8 (first-card [8 3 9 5]))))

(deftest ^{:task 2} second-card-2-test
  (is (= 4 (second-card [10 4]))))

(deftest ^{:task 2} second-card-4-test
  (is (= 5 (second-card [2 5 1 6]))))

(deftest ^{:task 2} second-card-empty-test
  (is (nil? (second-card []))))

(deftest ^{:task 2} second-card-single-test
  (is (nil? (second-card [8]))))

(deftest ^{:task 3} swap-top-two-cards-2-test
  (is (= [6 3] (swap-top-two-cards [3 6]))))

(deftest ^{:task 3} swap-top-two-cards-5-test
  (is (= [4 10 3 7 8] (swap-top-two-cards [10 4 3 7 8]))))

(deftest ^{:task 4} discard-top-card-single-test
  (is (= [7 nil] (discard-top-card [7]))))

(deftest ^{:task 4} discard-top-card-4-test
  (is (= [9 [2 10 4]] (discard-top-card [9 2 10 4]))))

(deftest ^{:task 5} insert-face-cards-3-test
  (is (= [3 "jack" "queen" "king" 10 7] (insert-face-cards [3 10 7]))))

(deftest ^{:task 5} insert-face-cards-1-test
  (is (= [9 "jack" "queen" "king"] (insert-face-cards [9]))))

(deftest ^{:task 5} insert-face-cards-empty-test
  (is (= ["jack" "queen" "king"] (insert-face-cards []))))
