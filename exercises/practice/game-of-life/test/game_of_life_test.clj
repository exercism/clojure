(ns game-of-life-test
  (:require [clojure.test :refer [deftest testing is]]
            game-of-life))

(deftest tick_test_1
  (testing "empty matrix"
    (is
     (= []
        (game-of-life/tick
         [])))))

(deftest tick_test_2
  (testing "live cells with zero live neighbors die"
    (is
     (= [[0 0 0]
         [0 0 0]
         [0 0 0]]
        (game-of-life/tick
         [[0 0 0]
          [0 1 0]
          [0 0 0]])))))

(deftest tick_test_3
  (testing "live cells with only one live neighbor die"
    (is
     (= [[0 0 0]
         [0 0 0]
         [0 0 0]]
        (game-of-life/tick
         [[0 0 0]
          [0 1 0]
          [0 1 0]])))))

(deftest tick_test_4
  (testing "live cells with two live neighbors stay alive"
    (is
     (= [[0 0 0]
         [1 0 1]
         [0 0 0]]
        (game-of-life/tick
         [[1 0 1]
          [1 0 1]
          [1 0 1]])))))

(deftest tick_test_5
  (testing "live cells with three live neighbors stay alive"
    (is
     (= [[0 0 0]
         [1 0 0]
         [1 1 0]]
        (game-of-life/tick
         [[0 1 0]
          [1 0 0]
          [1 1 0]])))))

(deftest tick_test_6
  (testing "dead cells with three live neighbors become alive"
    (is
     (= [[0 0 0]
         [1 1 0]
         [0 0 0]]
        (game-of-life/tick
         [[1 1 0]
          [0 0 0]
          [1 0 0]])))))

(deftest tick_test_7
  (testing "live cells with four or more neighbors die"
    (is
     (= [[1 0 1]
         [0 0 0]
         [1 0 1]]
        (game-of-life/tick
         [[1 1 1]
          [1 1 1]
          [1 1 1]])))))

(deftest tick_test_8
  (testing "bigger matrix"
    (is
     (= [[1 1 0 1 1 0 0 0]
         [0 0 0 0 0 1 1 0]
         [1 0 1 1 1 1 0 1]
         [1 0 0 0 0 0 0 1]
         [1 1 0 0 1 0 0 1]
         [1 1 0 1 0 0 0 1]
         [1 0 0 0 0 0 0 0]
         [0 0 0 0 0 0 1 1]]
        (game-of-life/tick
         [[1 1 0 1 1 0 0 0]
          [1 0 1 1 0 0 0 0]
          [1 1 1 0 0 1 1 1]
          [0 0 0 0 0 1 1 0]
          [1 0 0 0 1 1 0 0]
          [1 1 0 0 0 1 1 1]
          [0 0 1 0 1 0 0 1]
          [1 0 0 0 0 0 1 1]])))))
