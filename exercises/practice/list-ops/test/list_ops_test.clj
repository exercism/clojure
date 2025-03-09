(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
            list-ops))

(deftest append_test_1
  (testing "Append ▶ empty vectors"
    (is (= []
           (list-ops/append [] [])))))

(deftest append_test_2
  (testing "Append ▶ vector to empty vector"
    (is (= [1 2 3 4]
           (list-ops/append [] [1 2 3 4])))))

(deftest append_test_3
  (testing "Append ▶ empty vector to vector"
    (is (= [1 2 3 4]
           (list-ops/append [1 2 3 4] [])))))

(deftest append_test_4
  (testing "Append ▶ non-empty vectors"
    (is (= [1 2 2 3 4 5]
           (list-ops/append [1 2] [2 3 4 5])))))

(deftest concatenate_test_1
  (testing "Concatenate ▶ empty vector"
    (is (= []
           (list-ops/concatenate [])))))

(deftest concatenate_test_2
  (testing "Concatenate ▶ vector of vectors"
    (is (= [1 2 3 4 5 6]
           (list-ops/concatenate [[1 2] [3] [] [4 5 6]])))))

(deftest concatenate_test_3
  (testing "Concatenate ▶ vector of nested vectors"
    (is (= [[1] [2] [3] [] [4 5 6]]
           (list-ops/concatenate [[[1] [2]] [[3]] [[]] [[4 5 6]]])))))

(deftest select-if_test_1
  (testing "Filter ▶ empty vector"
    (is (= []
           (list-ops/select-if odd? [])))))

(deftest select-if_test_2
  (testing "Filter ▶ non-empty vector"
    (is (= [1 3 5]
           (list-ops/select-if odd? [1 2 3 5])))))

(deftest length_test_1
  (testing "Length ▶ empty vector"
    (is (= 0 (list-ops/length [])))))

(deftest length_test_2
  (testing "Length ▶ non-empty vector"
    (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest apply-to-each_test_1
  (testing "Map ▶ empty vector"
    (is (= []
           (list-ops/apply-to-each inc [])))))

(deftest apply-to-each_test_2
  (testing "Map ▶ non-empty vector"
    (is (= [2 4 6 8]
           (list-ops/apply-to-each inc [1 3 5 7])))))

(deftest foldl_test_1
  (testing "Foldl ▶ empty vector"
    (is (= 2 (list-ops/foldl (fn [acc el] (* el acc)) [] 2)))))

(deftest foldl_test_2
  (testing "Foldl ▶ direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldl (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest foldl_test_3
  (testing "Foldl ▶ direction dependent function applied to non-empty vector"
    (is (= 64 (list-ops/foldl (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest foldr_test_1
  (testing "Foldr ▶ empty vector"
    (is (= 2 (list-ops/foldr (fn [acc el] (* el acc)) [] 2)))))

(deftest foldr_test_2
  (testing "Foldr ▶ direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldr (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest foldr_test_3
  (testing "Foldr ▶ direction dependent function applied to non-empty vector"
    (is (= 9 (list-ops/foldr (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest reverse-order_test_1
  (testing "Reverse ▶ empty vector"
    (is (= []
           (list-ops/reverse-order [])))))

(deftest reverse-order_test_2
  (testing "Reverse ▶ non-empty vector"
    (is (= [7 5 3 1]
           (list-ops/reverse-order [1 3 5 7])))))

(deftest reverse-order_test_3
  (testing "Reverse ▶ vector of vectors is not flattened"
    (is (= [[4 5 6] [] [3] [1 2]]
           (list-ops/reverse-order [[1 2] [3] [] [4 5 6]])))))
