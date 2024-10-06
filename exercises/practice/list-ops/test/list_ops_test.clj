(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
             list-ops))

(deftest append-test
  (testing "empty vectors"
     (is (= [] (list-ops/append [] []))))
  (testing "vector to empty vector"
     (is (= [1 2 3 4] (list-ops/append [] [1 2 3 4]))))
  (testing "empty vector to vector"
     (is (= [1 2 3 4] (list-ops/append [1 2 3 4] []))))
  (testing "non-empty vectors"
     (is (= [1 2 2 3 4 5] (list-ops/append [1 2] [2 3 4 5])))))

(deftest concatenate-test
  (testing "empty vector"
     (is (= [] (list-ops/concatenate []))))
  (testing "vector of vectors"
     (is (= [1 2 3 4 5 6] (list-ops/concatenate [[1 2] [3] [] [4 5 6]]))))
  (testing "vector of nested vectors"
     (is (= [[1] [2] [3] [] [4 5 6]] (list-ops/concatenate [[[1] [2]] [[3]] [[]] [[4 5 6]]])))))

(deftest select-if-test
  (testing "empty vector"
     (is (= [] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [])))
  (testing "non-empty vector"
     (is (= [1 3 5] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [1 2 3 5]))))))

(deftest length-test
  (testing "empty vector"
     (is (= 0 (list-ops/length []))))
  (testing "non-empty vector"
     (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest apply-to-each-test
  (testing "empty vector"
     (is (= [] (list-ops/apply-to-each (fn [x] (+ x 1)) []))))
  (testing "non-empty vector"
     (is (= [2 4 6 8] (list-ops/apply-to-each (fn [x] (+ x 1)) [1 3 5 7])))))

(deftest foldl-test
  (testing "empty vector"
     (is (= 2 (list-ops/foldl (fn [acc el] (* el acc)) [] 2))))
  (testing "direction independent function applied to non-empty vector"
     (is (= 15 (list-ops/foldl (fn [acc el] (+ el acc)) [1 2 3 4] 5))))
  (testing "direction dependent function applied to non-empty vector"
     (is (= 64 (list-ops/foldl (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest foldr-test
  (testing "empty vector"
     (is (= 2 (list-ops/foldr (fn [acc el] (* el acc)) [] 2))))
  (testing "direction independent function applied to non-empty vector"
     (is (= 15 (list-ops/foldr (fn [acc el] (+ el acc)) [1 2 3 4] 5))))
  (testing "direction dependent function applied to non-empty vector"
     (is (= 9 (list-ops/foldr (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest reverse-order-test
  (testing "empty vector"
     (is (= [] (list-ops/reverse-order []))))
  (testing "non-empty vector"
     (is (= [7 5 3 1] (list-ops/reverse-order [1 3 5 7]))))
  (testing "vector of vectors is not flattened"
     (is (= [[4 5 6] [] [3] [1 2]] (list-ops/reverse-order [[1 2] [3] [] [4 5 6]])))))
