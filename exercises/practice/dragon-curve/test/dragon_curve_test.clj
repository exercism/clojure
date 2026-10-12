(ns dragon-curve-test
  (:require [clojure.test :refer [deftest testing is]]
            dragon-curve))

(deftest count-squares_test_1
  (testing "0 folds"
    (is (= 0 (dragon-curve/count-squares 0)))))

(deftest count-squares_test_2
  (testing "1 folds"
    (is (= 0 (dragon-curve/count-squares 1)))))

(deftest count-squares_test_3
  (testing "2 folds"
    (is (= 0 (dragon-curve/count-squares 2)))))

(deftest count-squares_test_4
  (testing "3 folds"
    (is (= 0 (dragon-curve/count-squares 3)))))

(deftest count-squares_test_5
  (testing "4 folds"
    (is (= 1 (dragon-curve/count-squares 4)))))

(deftest count-squares_test_6
  (testing "5 folds"
    (is (= 4 (dragon-curve/count-squares 5)))))

(deftest count-squares_test_7
  (testing "6 folds"
    (is (= 11 (dragon-curve/count-squares 6)))))

(deftest count-squares_test_8
  (testing "8 folds"
    (is (= 67 (dragon-curve/count-squares 8)))))

(deftest count-squares_test_9
  (testing "11 folds"
    (is (= 724 (dragon-curve/count-squares 11)))))

(deftest count-squares_test_10
  (testing "13 folds"
    (is (= 3232 (dragon-curve/count-squares 13)))))
