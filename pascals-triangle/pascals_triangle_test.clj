(ns pascals-triangle-test
  (:require [clojure.test :refer :all]
            [pascals-triangle :refer :all]))

(deftest test-one-row
  (testing "First row")
  (is (= (triangle 1) [[1]])))

(deftest test-two-rows
  (testing "First two rows")
  (is (= (triangle 2) [[1], [1, 1]])))

(deftest test-three-rows
  (testing "First 3 rows")
  (is (= (triangle 3) [[1], [1, 1], [1, 2, 1]])))

(deftest test-third-row
  (testing "Third row"
    (is (= (last (triangle 3)) [1, 2, 1]))))

(deftest test-fourth-row
  (testing "Fourth row")
  (is (= (last (triangle 4)) [1, 3, 3, 1])))

(deftest test-fifth-row
  (testing "Fifth row")
  (is (= (last (triangle 5)) [1, 4, 6, 4, 1])))

(deftest triangle-20th-row
  (testing "20th row"
    (is (= (last (triangle 20))
           [1, 19, 171, 969, 3876, 11628, 27132, 50388, 75582, 92378, 92378,
            75582, 50388, 27132, 11628, 3876, 969, 171, 19, 1]))))

(deftest triangle-300th-row
  (testing "300th row"
    (is (true?
         (some #(= 768408467483699505953134992026497450726137182648496343119395977464120N %1)
                     (last (triangle 300)))))))