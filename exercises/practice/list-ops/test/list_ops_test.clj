(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
             list-ops))

(deftest append-test
  (testing "empty lists"
     (is (= [] (list-ops/append [] []))))
  (testing "list to empty list"
     (is (= [1 2 3 4] (list-ops/append [] [1 2 3 4]))))
  (testing "empty list to list"
     (is (= [1 2 3 4] (list-ops/append [1 2 3 4] []))))
  (testing "non-empty lists"
     (is (= [1 2 2 3 4 5] (list-ops/append [1 2] [2 3 4 5])))))

(deftest concat-test
  (testing "empty list"
     (is (= [] (list-ops/concat []))))
  (testing "list of lists"
     (is (= [1 2 3 4 5 6] (list-ops/concat [[1 2] [3] [] [4 5 6]]))))
  (testing "list of nested lists"
     (is (= [[1] [2] [3] [] [4 5 6]] (list-ops/concat [[[1] [2]] [[3]] [[]] [[4 5 6]]])))))

(deftest filter-test
  (testing "empty list"
     (is (= [] (list-ops/filter [] "(x) -> x modulo 2 == 1"))))
  (testing "non-empty list"
     (is (= [1 3 5] (list-ops/filter [1 2 3 5] "(x) -> x modulo 2 == 1")))))

(deftest length-test
  (testing "empty list"
     (is (= 0 (list-ops/length []))))
  (testing "non-empty list"
     (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest map-test
  (testing "empty list"
     (is (= [] (list-ops/map [] "(x) -> x + 1"))))
  (testing "non-empty list"
     (is (= [2 4 6 8] (list-ops/map [1 3 5 7] "(x) -> x + 1")))))

(deftest foldl-test
  (testing "empty list"
     (is (= 2 (list-ops/foldl [] 2 "(x, y) -> x * y"))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldl [1 2 3 4] 5 "(x, y) -> x + y"))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 0 (list-ops/foldl [2 5] 5 "(x, y) -> x / y"))))
  (testing "empty list"
     (is (= 2 (list-ops/foldl [] 2 "(acc, el) -> el * acc"))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldl [1 2 3 4] 5 "(acc, el) -> el + acc"))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 64 (list-ops/foldl [1 2 3 4] 24 "(acc, el) -> el / acc")))))

(deftest foldr-test
  (testing "empty list"
     (is (= 2 (list-ops/foldr [] 2 "(x, y) -> x * y"))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldr [1 2 3 4] 5 "(x, y) -> x + y"))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 2 (list-ops/foldr [2 5] 5 "(x, y) -> x / y"))))
  (testing "empty list"
     (is (= 2 (list-ops/foldr [] 2 "(acc, el) -> el * acc"))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldr [1 2 3 4] 5 "(acc, el) -> el + acc"))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 9 (list-ops/foldr [1 2 3 4] 24 "(acc, el) -> el / acc")))))

(deftest reverse-test
  (testing "empty list"
     (is (= [] (list-ops/reverse []))))
  (testing "non-empty list"
     (is (= [7 5 3 1] (list-ops/reverse [1 3 5 7]))))
  (testing "list of lists is not flattened"
     (is (= [[4 5 6] [] [3] [1 2]] (list-ops/reverse [[1 2] [3] [] [4 5 6]])))))