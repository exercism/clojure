(ns elyses-destructured-enchantments-test
  (:require [clojure.test :refer :all]
            [elyses-destructured-enchantments :refer :all]))

(deftest first-card-test
  (is (= (first-card [3]) 3))
  (is (= (first-card [8 3 9 5]) 8)))

(deftest second-card-test
  (is (= (second-card [10 4]) 4))
  (is (= (second-card [2 5 1 6]) 5))
  (is (nil? (second-card [])))
  (is (nil? (second-card [8]))))

(deftest swap-top-two-cards-test
  (is (= (swap-top-two-cards [3 6]) [6 3]))
  (is (= (swap-top-two-cards [10 4 3 7 8]) [4 10 3 7 8])))

(deftest discard-top-card-test
  (is (= (discard-top-card [7]) [7 nil]))
  (is (= (discard-top-card [9 2 10 4]) [9 [2 10 4]])))

(deftest insert-face-cards-test
  (is (= (insert-face-cards [3 10 7]) [3 "jack" "queen" "king" 10 7]))
  (is (= (insert-face-cards [9]) [9 "jack" "queen" "king"]))
  (is (= (insert-face-cards []) ["jack" "queen" "king"])))
