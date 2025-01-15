(ns saddle-points-test
  (:require [clojure.test :refer [deftest testing is]]
            saddle-points))

(deftest saddle-points_test_1
  (testing "Can identify single saddle point"
    (is (= #{[2 1]}
           (saddle-points/saddle-points
             [
              [9 8 7]
              [5 3 2]
              [6 6 7]
             ])))))

(deftest saddle-points_test_2
  (testing "Can identify that empty matrix has no saddle points"
    (is (= #{}
           (saddle-points/saddle-points
             [
             ])))))

(deftest saddle-points_test_3
  (testing "Can identify lack of saddle points when there are none"
    (is (= #{}
           (saddle-points/saddle-points
             [
              [1 2 3]
              [3 1 2]
              [2 3 1]
             ])))))

(deftest saddle-points_test_4
  (testing "Can identify multiple saddle points in a column"
    (is (= #{[2 2] [1 2] [3 2]}
           (saddle-points/saddle-points
             [
              [4 5 4]
              [3 5 5]
              [1 5 4]
             ])))))

(deftest saddle-points_test_5
  (testing "Can identify multiple saddle points in a row"
    (is (= #{[2 2] [2 3] [2 1]}
           (saddle-points/saddle-points
             [
              [6 7 8]
              [5 5 5]
              [7 5 6]
             ])))))

(deftest saddle-points_test_6
  (testing "Can identify saddle point in bottom right corner"
    (is (= #{[3 3]}
           (saddle-points/saddle-points
             [
              [8 7 9]
              [6 7 6]
              [3 2 5]
             ])))))

(deftest saddle-points_test_7
  (testing "Can identify saddle points in a non square matrix"
    (is (= #{[1 1] [1 3]}
           (saddle-points/saddle-points
             [
              [3 1 3]
              [3 2 4]
             ])))))

(deftest saddle-points_test_8
  (testing "Can identify that saddle points in a single column matrix are those with the minimum value"
    (is (= #{[4 1] [2 1]}
           (saddle-points/saddle-points
             [
              [2]
              [1]
              [4]
              [1]
             ])))))

(deftest saddle-points_test_9
  (testing "Can identify that saddle points in a single row matrix are those with the maximum value"
    (is (= #{[1 4] [1 2]}
           (saddle-points/saddle-points
             [
              [2 5 3 5]
             ])))))
