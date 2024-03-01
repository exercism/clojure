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
     (is (= [] (list-ops/filter (fn [x] (= (mod x 2) 1)) [])))
  (testing "non-empty list"
     (is (= [1 3 5] (list-ops/filter (fn [x] (= (mod x 2) 1)) [1 2 3 5]))))))

(deftest length-test
  (testing "empty list"
     (is (= 0 (list-ops/length []))))
  (testing "non-empty list"
     (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest map-test
  (testing "empty list"
     (is (= [] (list-ops/map (fn [x] (+ x 1)) []))))
  (testing "non-empty list"
     (is (= [2 4 6 8] (list-ops/map (fn [x] (+ x 1)) [1 3 5 7])))))

(deftest foldl-test
  (testing "empty list"
     (is (= 2 (list-ops/foldl (fn [acc el] (* el acc)) [] 2))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldl (fn [acc el] (+ el acc)) [1 2 3 4] 5))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 64 (list-ops/foldl (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest foldr-test
  (testing "empty list"
     (is (= 2 (list-ops/foldr (fn [acc el] (* el acc)) [] 2))))
  (testing "direction independent function applied to non-empty list"
     (is (= 15 (list-ops/foldr (fn [acc el] (+ el acc)) [1 2 3 4] 5))))
  (testing "direction dependent function applied to non-empty list"
     (is (= 9 (list-ops/foldr (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest reverse-test
  (testing "empty list"
     (is (= [] (list-ops/reverse []))))
  (testing "non-empty list"
     (is (= [7 5 3 1] (list-ops/reverse [1 3 5 7]))))
  (testing "list of lists is not flattened"
     (is (= [[4 5 6] [] [3] [1 2]] (list-ops/reverse [[1 2] [3] [] [4 5 6]])))))

;(clojure.test/run-tests)