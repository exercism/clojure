(ns dominoes-test
  (:require [clojure.test :refer [deftest testing is]]
            dominoes))

(deftest test-31a673f2-5e54-49fe-bd79-1c1dae476c9c
  (testing "Empty input = empty output"
    (is (true? (dominoes/can-chain? [])))))

(deftest test-4f99b933-367b-404b-8c6d-36d5923ee476
  (testing "Singleton input = singleton output"
    (is (true? (dominoes/can-chain? [[1 1]])))))

(deftest test-91122d10-5ec7-47cb-b759-033756375869
  (testing "Singleton that can't be chained"
    (is (false? (dominoes/can-chain? [[1 2]])))))

(deftest test-be8bc26b-fd3d-440b-8e9f-d698a0623be3
  (testing "Three elements"
    (is (true? (dominoes/can-chain?  [[1 2] [3 1] [2 3]])))))

(deftest test-99e615c6-c059-401c-9e87-ad7af11fea5c
  (testing "Can reverse dominoes"
    (is (true? (dominoes/can-chain? [[1 2] [1 3] [2 3]])))))

(deftest test-51f0c291-5d43-40c5-b316-0429069528c9
  (testing "Can't be chained"
    (is (false? (dominoes/can-chain? [[1 2] [4 1] [2 3]])))))

(deftest test-9a75e078-a025-4c23-8c3a-238553657f39
  (testing "Disconnected - simple"
    (is (false? (dominoes/can-chain? [[1 1] [2 2]])))))

(deftest test-0da0c7fe-d492-445d-b9ef-1f111f07a301
  (testing "Disconnected - double loop"
    (is (false? (dominoes/can-chain? [[1 2] [2 1] [3 4] [4 3]])))))

(deftest test-b6087ff0-f555-4ea0-a71c-f9d707c5994a
  (testing "Disconnected - single isolated"
    (is (false? (dominoes/can-chain? [[1 2] [2 3] [3 1] [4 4]])))))

(deftest test-2174fbdc-8b48-4bac-9914-8090d06ef978
  (testing "Need backtrack"
    (is (true? (dominoes/can-chain? [[1 2] [2 3] [3 1] [2 4] [2 4]])))))

(deftest test-167bb480-dfd1-4318-a20d-4f90adb4a09f
  (testing "Separate loops"
    (is (true? (dominoes/can-chain? [[1 2] [2 3] [3 1] [1 1] [2 2] [3 3]])))))

(deftest test-cd061538-6046-45a7-ace9-6708fe8f6504
  (testing "Nine elements"
    (is (true? (dominoes/can-chain? [[1 2] [5 3] [3 1] [1 2] [2 4] [1 6] [2 3] [3 4] [5 6]])))))

(deftest test-44704c7c-3adb-4d98-bd30-f45527cf8b49
  (testing "Separate three-domino loops"
    (is (false? (dominoes/can-chain?  [[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]])))))
