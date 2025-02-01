(ns pythagorean-triplet-test
  (:require [clojure.test :refer [deftest testing is]]
            pythagorean-triplet))

(deftest find-pythagorean-triplets_test_1
  (testing "triplets whose sum is 12"
    (is (= [[3 4 5]]
           (pythagorean-triplet/find-pythagorean-triplets 12)))))

(deftest find-pythagorean-triplets_test_2
  (testing "triplets whose sum is 108"
    (is (= [[27 36 45]]
           (pythagorean-triplet/find-pythagorean-triplets 108)))))

(deftest find-pythagorean-triplets_test_3
  (testing "triplets whose sum is 1000"
    (is (= [[200 375 425]]
           (pythagorean-triplet/find-pythagorean-triplets 1000)))))

(deftest find-pythagorean-triplets_test_4
  (testing "no matching triplets for 1001"
    (is (= []
           (pythagorean-triplet/find-pythagorean-triplets 1001)))))

(deftest find-pythagorean-triplets_test_5
  (testing "returns all matching triplets"
    (is (= [[9 40 41]
            [15 36 39]]
           (pythagorean-triplet/find-pythagorean-triplets 90)))))

(deftest find-pythagorean-triplets_test_6
  (testing "several matching triplets"
    (is (= [[40 399 401]
            [56 390 394]
            [105 360 375]
            [120 350 370]
            [140 336 364]
            [168 315 357]
            [210 280 350]
            [240 252 348]]
           (pythagorean-triplet/find-pythagorean-triplets 840)))))

(deftest find-pythagorean-triplets_test_7
  (testing "triplets for large number"
    (is (= [[1200 14375 14425]
            [1875 14000 14125]
            [5000 12000 13000]
            [6000 11250 12750]
            [7500 10000 12500]]
           (pythagorean-triplet/find-pythagorean-triplets 30000)))))
