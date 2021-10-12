(ns elyses-destructured-enchantments-test
  (:require [clojure.test :refer :all]
            [elyses-destructured-enchantments :refer :all]))

(deftest first-card-single-test
  (is (= (first-card [3]) 3)))

(deftest first-card-multiple-test
  (is (= (first-card [8 3 9 5]) 8)))

(deftest second-card-2-test
  (is (= (second-card [10 4]) 4)))

(deftest second-card-4-test
  (is (= (second-card [2 5 1 6]) 5)))

(deftest second-card-empty-test
  (is (nil? (second-card []))))

(deftest second-card-single-test
  (is (nil? (second-card [8]))))

(deftest swap-top-two-cards-2-test
  (is (= (swap-top-two-cards [3 6]) [6 3])))

(deftest swap-top-two-cards-5-test
  (is (= (swap-top-two-cards [10 4 3 7 8]) [4 10 3 7 8])))

(deftest discard-top-card-single-test
  (is (= (discard-top-card [7]) [7 nil])))

(deftest discard-top-card-4-test
  (is (= (discard-top-card [9 2 10 4]) [9 [2 10 4]])))

(deftest insert-face-cards-3-test
  (is (= (insert-face-cards [3 10 7]) [3 "jack" "queen" "king" 10 7])))

(deftest insert-face-cards-1-test
  (is (= (insert-face-cards [9]) [9 "jack" "queen" "king"])))

(deftest insert-face-cards-empty-test
  (is (= (insert-face-cards []) ["jack" "queen" "king"])))