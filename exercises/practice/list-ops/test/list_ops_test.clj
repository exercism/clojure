(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
             list-ops))

(deftest append_test_1
  (testing "append entries to a vector and return the new vector -> empty vectors"
    (is (= [] (list-ops/append [] [])))))

(deftest append_test_2
  (testing "append entries to a vector and return the new vector -> vector to empty vector"
    (is (= [1 2 3 4] (list-ops/append [] [1 2 3 4])))))

(deftest append_test_3
  (testing "append entries to a vector and return the new vector -> empty vector to vector"
    (is (= [1 2 3 4] (list-ops/append [1 2 3 4] [])))))

(deftest append_test_4
  (testing "append entries to a vector and return the new vector -> non-empty vectors"
    (is (= [1 2 2 3 4 5] (list-ops/append [1 2] [2 3 4 5])))))

(deftest concatenate_test_1
  (testing "concatenate a vector of vectors -> empty vector"
    (is (= [] (list-ops/concatenate [])))))

(deftest concatenate_test_2
  (testing "concatenate a vector of vectors -> vector of vectors"
    (is (= [1 2 3 4 5 6] (list-ops/concatenate [[1 2] [3] [] [4 5 6]])))))

(deftest concatenate_test_3
  (testing "concatenate a vector of vectors -> vector of nested vectors"
    (is (= [[1] [2] [3] [] [4 5 6]] (list-ops/concatenate [[[1] [2]] [[3]] [[]] [[4 5 6]]])))))

(deftest select-if_test_1
  (testing "filter vector returning only values that satisfy the filter function -> empty vector"
    (is (= [] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [])))))

(deftest select-if_test_2
  (testing "filter vector returning only values that satisfy the filter function -> non-empty vector"
    (is (= [1 3 5] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [1 2 3 5])))))

(deftest length_test_1
  (testing "returns the length of a vector -> empty vector"
    (is (= 0 (list-ops/length [])))))

(deftest length_test_2
  (testing "returns the length of a vector -> non-empty vector"
    (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest apply-to-each_test_1
  (testing "return a vector of elements whose values equal the vector value transformed by the mapping function -> empty vector"
    (is (= [] (list-ops/apply-to-each (fn [x] (+ x 1)) [])))))

(deftest apply-to-each_test_2
  (testing "return a vector of elements whose values equal the vector value transformed by the mapping function -> non-empty vector"
    (is (= [2 4 6 8] (list-ops/apply-to-each (fn [x] (+ x 1)) [1 3 5 7])))))

(deftest foldl_test_1
  (testing "folds (reduces) the given vector from the left with a function -> empty vector"
    (is (= 2 (list-ops/foldl (fn [acc el] (* el acc)) [] 2)))))

(deftest foldl_test_2
  (testing "folds (reduces) the given vector from the left with a function -> direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldl (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest foldl_test_3
  (testing "folds (reduces) the given vector from the left with a function -> direction dependent function applied to non-empty vector"
    (is (= 64 (list-ops/foldl (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest foldr_test_1
  (testing "folds (reduces) the given vector from the right with a function -> empty vector"
    (is (= 2 (list-ops/foldr (fn [acc el] (* el acc)) [] 2)))))

(deftest foldr_test_2
  (testing "folds (reduces) the given vector from the right with a function -> direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldr (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest foldr_test_3
  (testing "folds (reduces) the given vector from the right with a function -> direction dependent function applied to non-empty vector"
    (is (= 9 (list-ops/foldr (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest reverse-order_test_1
  (testing "reverse the elements of the vector -> empty vector"
    (is (= [] (list-ops/reverse-order [])))))

(deftest reverse-order_test_2
  (testing "reverse the elements of the vector -> non-empty vector"
    (is (= [7 5 3 1] (list-ops/reverse-order [1 3 5 7])))))

(deftest reverse-order_test_3
  (testing "reverse the elements of the vector -> vector of vectors is not flattened"
    (is (= [[4 5 6] [] [3] [1 2]] (list-ops/reverse-order [[1 2] [3] [] [4 5 6]])))))
