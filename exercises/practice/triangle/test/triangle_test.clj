(ns triangle-test
  (:require [clojure.test :refer [deftest is testing]]
            triangle))

(deftest equilateral
  (testing "equilateral triangle"
    (testing "all sides are equal"
      (is (true? (triangle/equilateral? 2 2 2))))
    (testing "any side is unequal"
      (is (false? (triangle/equilateral? 2 3 2))))
    (testing "no sides are equal"
      (is (false? (triangle/equilateral? 5 4 6))))
    (testing "all zero sides is not a triangle"
      (is (false? (triangle/equilateral? 0 0 0))))
    (testing "sides may be floats"
      (is (true? (triangle/equilateral? 0.5 0.5 0.5))))))


(deftest isosceles
  (testing "isosceles triangle"
    (testing "last two sides are equal"
      (is (true? (triangle/isosceles? 3 4 4))))
    (testing "first two sides are equal"
      (is (true? (triangle/isosceles? 4 4 3))))
    (testing "first and last sides are equal"
      (is (true? (triangle/isosceles? 4 3 4))))
    (testing "equilateral triangles are also isosceles"
      (is (true? (triangle/isosceles? 4 4 4))))
    (testing "no sides are equal"
      (is (false? (triangle/isosceles? 2 3 4))))
    (testing "first triangle inequality violation"
      (is (false? (triangle/isosceles? 1 1 3))))
    (testing "second triangle inequality violation"
      (is (false? (triangle/isosceles? 1 3 1))))
    (testing "third triangle inequality violation"
      (is (false? (triangle/isosceles? 3 1 1))))
    (testing "sides may be floats"
      (is (true? (triangle/isosceles? 0.5 0.4 0.5))))))

(deftest scalene
  (testing "scalene triangle"
    (testing "no sides are equal"
      (is (true? (triangle/scalene? 5 4 6))))
    (testing "all sides are equal"
      (is (false? (triangle/scalene? 4 4 4))))
    (testing "two sides are equal"
      (is (false? (triangle/scalene? 4 4 3))))
    (testing "may not violate triangle inequality"
      (is (false? (triangle/scalene? 7 3 2))))
    (testing "sides may be floats"
      (is (true? (triangle/scalene? 0.5 0.4 0.6))))))
