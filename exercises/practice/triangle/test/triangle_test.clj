(ns triangle-test
  (:require [clojure.test :refer [deftest is testing]]
            triangle))

(deftest equilateral-all-sides-equal
      (is (true? (triangle/equilateral? 2 2 2))))

(deftest equilateral-any-side-is-unequal
      (is (false? (triangle/equilateral? 2 3 2))))

(deftest equilateral-no-sides-are-equal
      (is (false? (triangle/equilateral? 5 4 6))))

(deftest equilateral-all-zero-sides
      (is (false? (triangle/equilateral? 0 0 0))))

(deftest equilateral-sides-may-be-floats
      (is (true? (triangle/equilateral? 0.5 0.5 0.5))))

(deftest isosceles-last-two-sides-equal
      (is (true? (triangle/isosceles? 3 4 4))))

(deftest isosceles-first-two-sides-equal
      (is (true? (triangle/isosceles? 4 4 3))))

(deftest isosceles-first-last-sides-equal
      (is (true? (triangle/isosceles? 4 3 4))))

(deftest isosceles-equilateral-triangles-also-isosceles
      (is (true? (triangle/isosceles? 4 4 4))))

(deftest isosceles-no-sides-equal
      (is (false? (triangle/isosceles? 2 3 4))))

(deftest isosceles-first-triangle-inequality-violation
      (is (false? (triangle/isosceles? 1 1 3))))

(deftest isosceles-second-triangle-inequality-violation
      (is (false? (triangle/isosceles? 1 3 1))))

(deftest isosceles-third-triangle-inequality-violation
      (is (false? (triangle/isosceles? 3 1 1))))

(deftest isosceles-sides-may-be-floats
      (is (true? (triangle/isosceles? 0.5 0.4 0.5))))

(deftest scalene-no-sides-are-equal
      (is (true? (triangle/scalene? 5 4 6))))

(deftest scalene-all-sides-equal
      (is (false? (triangle/scalene? 4 4 4))))

(deftest scalene-two-sides-equal
      (is (false? (triangle/scalene? 4 4 3))))

(deftest scalene-may-not-violate-triangle-inequality
      (is (false? (triangle/scalene? 7 3 2))))

(deftest scalene-sides-may-be-floats
      (is (true? (triangle/scalene? 0.5 0.4 0.6))))
