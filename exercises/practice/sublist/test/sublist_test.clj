(ns sublist-test
  (:require [clojure.test :refer [deftest is testing]]
            sublist))

(deftest test-97319c93-ebc5-47ab-a022-02a1980e1d29
  (testing "Empty lists"
    (is (= :equal (sublist/classify [] [])))))

(deftest test-de27dbd4-df52-46fe-a336-30be58457382
  (testing "Empty list within non empty list"
    (is (= :sublist (sublist/classify [] [1 2 3])))))

(deftest test-5487cfd1-bc7d-429f-ac6f-1177b857d4fb
  (testing "Non empty list contains empty list"
    (is (= :superlist (sublist/classify [1 2 3] [])))))

(deftest test-1f390b47-f6b2-4a93-bc23-858ba5dda9a6
  (testing "List equals itself"
    (is (= :equal (sublist/classify [1 2 3] [1 2 3])))))

(deftest test-7ed2bfb2-922b-4363-ae75-f3a05e8274f5
  (testing "Different lists"
    (is (= :unequal (sublist/classify [1 2 3] [2 3 4])))))

(deftest test-3b8a2568-6144-4f06-b0a1-9d266b365341
  (testing "False start"
    (is (= :sublist (sublist/classify [1 2 5] [0 1 2 3 1 2 5 6])))))

(deftest test-dc39ed58-6311-4814-be30-05a64bc8d9b1
  (testing "Consecutive"
    (is (= :sublist (sublist/classify [1 1 2] [0 1 1 1 2 1 2])))))

(deftest test-d1270dab-a1ce-41aa-b29d-b3257241ac26
  (testing "Sublist at start"
    (is (= :sublist (sublist/classify [0 1 2] [0 1 2 3 4 5])))))

(deftest test-81f3d3f7-4f25-4ada-bcdc-897c403de1b6
  (testing "Sublist in middle"
    (is (= :sublist (sublist/classify [2 3 4] [0 1 2 3 4 5])))))

(deftest test-43bcae1e-a9cf-470e-923e-0946e04d8fdd
  (testing "Sublist at end"
    (is (= :sublist (sublist/classify [3 4 5] [0 1 2 3 4 5])))))

(deftest test-76cf99ed-0ff0-4b00-94af-4dfb43fe5caa
  (testing "At start of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [0 1 2])))))

(deftest test-b83989ec-8bdf-4655-95aa-9f38f3e357fd
  (testing "In middle of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [2 3])))))

(deftest test-26f9f7c3-6cf6-4610-984a-662f71f8689b
  (testing "At end of superlist"
    (is (= :superlist (sublist/classify [0 1 2 3 4 5] [3 4 5])))))

(deftest test-0a6db763-3588-416a-8f47-76b1cedde31e
  (testing "First list missing element from second list"
    (is (= :unequal (sublist/classify [1 3] [1 2 3])))))

(deftest test-83ffe6d8-a445-4a3c-8795-1e51a95e65c3
  (testing "Second list missing element from first list"
    (is (= :unequal (sublist/classify [1 2 3] [1 3])))))

(deftest test-7bc76cb8-5003-49ca-bc47-cdfbe6c2bb89
  (testing "First list missing additional digits from second list"
    (is (= :unequal (sublist/classify [1 2] [1 22])))))

(deftest test-0d7ee7c1-0347-45c8-9ef5-b88db152b30b
  (testing "Order matters to a list"
    (is (= :unequal (sublist/classify [1 2 3] [3 2 1])))))

(deftest test-5f47ce86-944e-40f9-9f31-6368aad70aa6
  (testing "Same digits but different numbers"
    (is (= :unequal (sublist/classify [1 0 1] [10 1])))))
