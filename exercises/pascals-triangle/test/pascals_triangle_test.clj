(ns pascals-triangle-test
  (:require [clojure.test :refer [deftest is testing]]
            [pascals-triangle :refer :all]))

(deftest test-one-row
  (testing "First row"
    (is (= (take 1 triangle) [[1]]))))

(deftest test-two-rows
  (testing "First two rows"
    (is (= (take 2 triangle) [[1], [1 1]]))))

(deftest test-three-rows
  (testing "First 3 rows"
    (is (= (take 3 triangle) [[1], [1 1], [1 2 1]]))))

(deftest test-third-row
  (testing "Third row"
    (is (= (row 3) [1 2 1]))))

(deftest test-fourth-row
  (testing "Fourth row"
    (is (= (row 4) [1 3 3 1]))))

(deftest test-fifth-row
  (testing "Fifth row"
    (is (= (row 5) [1 4 6 4 1]))))

(deftest triangle-20th-row
  (testing "20th row"
    (is (= (row 20)
           (let [v [1 19 171 969 3876 11628 27132 50388 75582 92378]]
             (into v (rseq v)))))))

(deftest triangle-300th-row
  (testing "300th row"
    (is (some?
         (some #{768408467483699505953134992026497450726137182648496343119395977464120N}
               (row 300))))))
