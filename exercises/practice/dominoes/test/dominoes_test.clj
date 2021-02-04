(ns dominoes-test
  (:require [clojure.test :refer [deftest is]]
            [dominoes     :refer [can-chain?]]))

(deftest empty-input-empty-output
  (is (can-chain? [])))

(deftest singleton-input-singleton-output
  (is (can-chain? [[1 1]])))

(deftest singleton-that-cant-be-chained
  (is ((comp not can-chain?) [[1 2]])))

(deftest three-elements
  (is (can-chain?  [[1 2] [3 1] [2 3]])))

(deftest can-reverse-dominoes
  (is (can-chain? [[1 2] [1 3] [2 3]])))

(deftest cant-be-chained
  (is ((comp not can-chain?) [[1 2] [4 1] [2 3]])))

(deftest disconnected-simple
  (is ((comp not can-chain?) [[1 1] [2 2]])))

(deftest disconnected-double-loop
  (is ((comp not can-chain?) [[1 2] [2 1] [3 4] [4 3]])))

(deftest disconnected-single-isolated
  (is ((comp not can-chain?) [[1 2] [2 3] [3 1] [4 4]])))

(deftest need-backtrack
  (is (can-chain? [[1 2] [2 3] [3 1] [2 4] [2 4]])))

(deftest separate-loops
  (is (can-chain? [[1 2] [2 3] [3 1] [1 1] [2 2] [3 3]])))

(deftest nine-elements
  (is (can-chain? [[1 2] [5 3] [3 1] [1 2] [2 4] [1 6] [2 3] [3 4] [5 6]])))
