(ns triangle.test (:require [clojure.test :refer :all]))
(load-file "triangle.clj")

(deftest equilateral-1
  (is (= :equilateral (triangle/type 2 2 2))))
(deftest equilateral-2
  (is (= :equilateral (triangle/type 10 10 10))))
(deftest isoceles-1
  (is (= :isosceles (triangle/type 3 4 4))))
(deftest isoceles-2
  (is (= :isosceles (triangle/type 4 3 4))))
(deftest scalene
  (is (= :scalene (triangle/type 3 4 5))))
(deftest invalid-1
  (is (= :illogical (triangle/type 1 1 50))))
(deftest invalid-2
  (is (= :illogical (triangle/type 1 2 1))))

(run-tests)
