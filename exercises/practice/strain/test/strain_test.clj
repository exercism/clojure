(ns strain-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            strain))

(deftest retain_test_1
  (testing "keep on empty vector returns empty vector"
    (is (= []
           (strain/retain (fn [_] true)
                          [])))))

(deftest retain_test_2
  (testing "keeps everything"
    (is (= [1 3 5]
           (strain/retain (fn [_] true)
                          [1 3 5])))))

(deftest retain_test_3
  (testing "keeps nothing"
    (is (= []
           (strain/retain (fn [_] false)
                          [1 3 5])))))

(deftest retain_test_4
  (testing "keeps first and last"
    (is (= [1 3]
           (strain/retain odd?
                          [1 2 3])))))

(deftest retain_test_5
  (testing "keeps neither first nor last"
    (is (= [2]
           (strain/retain even?
                          [1 2 3])))))

(deftest retain_test_6
  (testing "keeps strings"
    (is (= ["zebra" "zombies" "zealot"]
           (strain/retain (fn [x] (str/starts-with? x "z"))
                          ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])))))

(deftest retain_test_7
  (testing "keeps vectors"
    (is (= [[5 5 5] [5 1 2] [1 5 2] [1 2 5]]
           (strain/retain (fn [x] (boolean (some #{5} x)))
                          [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])))))

(deftest discard_test_1
  (testing "discard on empty vector returns empty vector"
    (is (= []
           (strain/discard (fn [_] true)
                           [])))))

(deftest discard_test_2
  (testing "discards everything"
    (is (= []
           (strain/discard (fn [_] true)
                           [1 3 5])))))

(deftest discard_test_3
  (testing "discards nothing"
    (is (= [1 3 5]
           (strain/discard (fn [_] false)
                           [1 3 5])))))

(deftest discard_test_4
  (testing "discards first and last"
    (is (= [2]
           (strain/discard odd?
                           [1 2 3])))))

(deftest discard_test_5
  (testing "discards neither first nor last"
    (is (= [1 3]
           (strain/discard even?
                           [1 2 3])))))

(deftest discard_test_6
  (testing "discards strings"
    (is (= ["apple" "banana" "cherimoya"]
           (strain/discard (fn [x] (str/starts-with? x "z"))
                           ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])))))

(deftest discard_test_7
  (testing "discards vectors"
    (is (= [[1 2 3] [2 1 2] [2 2 1]]
           (strain/discard (fn [x] (boolean (some #{5} x)))
                           [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])))))
