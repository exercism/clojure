(ns triangle-test
  (:require [clojure.test :refer [deftest is]]
            triangle))

(deftest equilateral-1
  (is (= :equilateral (triangle/type 2 2 2))))

(deftest equilateral-2
  (is (= :equilateral (triangle/type 10 10 10))))

(deftest isosceles-1
  (is (= :isosceles (triangle/type 3 4 4))))

(deftest isosceles-2
  (is (= :isosceles (triangle/type 4 3 4))))

(deftest scalene
  (is (= :scalene (triangle/type 3 4 5))))

(deftest invalid-1
  (is (= :illogical (triangle/type 1 1 50))))

;; See discussion at https://github.com/exercism/xerlang/issues/85

(deftest invalid-2
  (is (= :illogical (triangle/type 1 2 1))))

(deftest invalid-3
  (is (= :illogical (triangle/type 2 4 2))))
