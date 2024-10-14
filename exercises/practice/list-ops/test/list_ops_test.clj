(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
             list-ops))

(deftest test-485b9452-bf94-40f7-a3db-c3cf4850066a
  (testing "append entries to a vector and return the new vector -> empty vectors"
    (is (= [] (list-ops/append [] [])))))

(deftest test-2c894696-b609-4569-b149-8672134d340a
  (testing "append entries to a vector and return the new vector -> vector to empty vector"
    (is (= [1 2 3 4] (list-ops/append [] [1 2 3 4])))))

(deftest test-e842efed-3bf6-4295-b371-4d67a4fdf19c
  (testing "append entries to a vector and return the new vector -> empty vector to vector"
    (is (= [1 2 3 4] (list-ops/append [1 2 3 4] [])))))

(deftest test-71dcf5eb-73ae-4a0e-b744-a52ee387922f
  (testing "append entries to a vector and return the new vector -> non-empty vectors"
    (is (= [1 2 2 3 4 5] (list-ops/append [1 2] [2 3 4 5])))))

(deftest test-28444355-201b-4af2-a2f6-5550227bde21
  (testing "concatenate a vector of vectors -> empty vector"
    (is (= [] (list-ops/concatenate [])))))

(deftest test-331451c1-9573-42a1-9869-2d06e3b389a9
  (testing "concatenate a vector of vectors -> vector of vectors"
    (is (= [1 2 3 4 5 6] (list-ops/concatenate [[1 2] [3] [] [4 5 6]])))))

(deftest test-d6ecd72c-197f-40c3-89a4-aa1f45827e09
  (testing "concatenate a vector of vectors -> vector of nested vectors"
    (is (= [[1] [2] [3] [] [4 5 6]] (list-ops/concatenate [[[1] [2]] [[3]] [[]] [[4 5 6]]])))))

(deftest test-0524fba8-3e0f-4531-ad2b-f7a43da86a16
  (testing "filter vector returning only values that satisfy the filter function -> empty vector"
    (is (= [] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [])))))

(deftest test-88494bd5-f520-4edb-8631-88e415b62d24
  (testing "filter vector returning only values that satisfy the filter function -> non-empty vector"
    (is (= [1 3 5] (list-ops/select-if (fn [x] (= (mod x 2) 1)) [1 2 3 5])))))

(deftest test-1cf0b92d-8d96-41d5-9c21-7b3c37cb6aad
  (testing "returns the length of a vector -> empty vector"
    (is (= 0 (list-ops/length [])))))

(deftest test-d7b8d2d9-2d16-44c4-9a19-6e5f237cb71e
  (testing "returns the length of a vector -> non-empty vector"
    (is (= 4 (list-ops/length [1 2 3 4])))))

(deftest test-c0bc8962-30e2-4bec-9ae4-668b8ecd75aa
  (testing "return a vector of elements whose values equal the vector value transformed by the mapping function -> empty vector"
    (is (= [] (list-ops/apply-to-each (fn [x] (+ x 1)) [])))))

(deftest test-11e71a95-e78b-4909-b8e4-60cdcaec0e91
  (testing "return a vector of elements whose values equal the vector value transformed by the mapping function -> non-empty vector"
    (is (= [2 4 6 8] (list-ops/apply-to-each (fn [x] (+ x 1)) [1 3 5 7])))))

(deftest test-36549237-f765-4a4c-bfd9-5d3a8f7b07d2
  (testing "folds (reduces) the given vector from the left with a function -> empty vector"
    (is (= 2 (list-ops/foldl (fn [acc el] (* el acc)) [] 2)))))

(deftest test-7a626a3c-03ec-42bc-9840-53f280e13067
  (testing "folds (reduces) the given vector from the left with a function -> direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldl (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest test-d7fcad99-e88e-40e1-a539-4c519681f390
  (testing "folds (reduces) the given vector from the left with a function -> direction dependent function applied to non-empty vector"
    (is (= 64 (list-ops/foldl (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest test-17214edb-20ba-42fc-bda8-000a5ab525b0
  (testing "folds (reduces) the given vector from the right with a function -> empty vector"
    (is (= 2 (list-ops/foldr (fn [acc el] (* el acc)) [] 2)))))

(deftest test-e1c64db7-9253-4a3d-a7c4-5273b9e2a1bd
  (testing "folds (reduces) the given vector from the right with a function -> direction independent function applied to non-empty vector"
    (is (= 15 (list-ops/foldr (fn [acc el] (+ el acc)) [1 2 3 4] 5)))))

(deftest test-8066003b-f2ff-437e-9103-66e6df474844
  (testing "folds (reduces) the given vector from the right with a function -> direction dependent function applied to non-empty vector"
    (is (= 9 (list-ops/foldr (fn [acc el] (/ el acc)) [1 2 3 4] 24)))))

(deftest test-94231515-050e-4841-943d-d4488ab4ee30
  (testing "reverse the elements of the vector -> empty vector"
    (is (= [] (list-ops/reverse-order [])))))

(deftest test-fcc03d1e-42e0-4712-b689-d54ad761f360
  (testing "reverse the elements of the vector -> non-empty vector"
    (is (= [7 5 3 1] (list-ops/reverse-order [1 3 5 7])))))

(deftest test-40872990-b5b8-4cb8-9085-d91fc0d05d26
  (testing "reverse the elements of the vector -> vector of vectors is not flattened"
    (is (= [[4 5 6] [] [3] [1 2]] (list-ops/reverse-order [[1 2] [3] [] [4 5 6]])))))
