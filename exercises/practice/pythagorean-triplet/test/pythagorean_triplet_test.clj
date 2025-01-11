(ns pythagorean-triplet-test
  (:require [clojure.test :refer [deftest testing is]]
            pythagorean-triplet))

(deftest test-a19de65d-35b8-4480-b1af-371d9541e706
  (testing "triplets whose sum is 12"
    (is (= [[3 4 5]] (pythagorean-triplet/find-pythagorean-triplets 12)))))

(deftest test-48b21332-0a3d-43b2-9a52-90b2a6e5c9f5
  (testing "triplets whose sum is 108"
    (is (= [[27 36 45]] (pythagorean-triplet/find-pythagorean-triplets 108)))))

(deftest test-dffc1266-418e-4daa-81af-54c3e95c3bb5
  (testing "triplets whose sum is 1000"
    (is (= [[200 375 425]] (pythagorean-triplet/find-pythagorean-triplets 1000)))))

(deftest test-5f86a2d4-6383-4cce-93a5-e4489e79b186
  (testing "no matching triplets for 1001"
    (is (= [] (pythagorean-triplet/find-pythagorean-triplets 1001)))))

(deftest test-bf17ba80-1596-409a-bb13-343bdb3b2904
  (testing "returns all matching triplets"
    (is (= [[9 40 41]
            [15 36 39]]
           (pythagorean-triplet/find-pythagorean-triplets 90)))))

(deftest test-9d8fb5d5-6c6f-42df-9f95-d3165963ac57
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

(deftest test-f5be5734-8aa0-4bd1-99a2-02adcc4402b4
  (testing "triplets for large number"
    (is (= [[1200 14375 14425]
            [1875 14000 14125]
            [5000 12000 13000]
            [6000 11250 12750]
            [7500 10000 12500]]
           (pythagorean-triplet/find-pythagorean-triplets 30000)))))
