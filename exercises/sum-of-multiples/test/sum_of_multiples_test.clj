(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest is]]
            sum-of-multiples))

(deftest sum-to-1
  (is (zero? (sum-of-multiples/sum-of-multiples 1))))

(deftest sum-to-3
  (is (= 3 (sum-of-multiples/sum-of-multiples 4))))

(deftest sum-to-10
  (is (= 23 (sum-of-multiples/sum-of-multiples 10))))

(deftest sum-to-100
  (is (= 2318 (sum-of-multiples/sum-of-multiples 100))))

(deftest sum-to-1000
  (is (= 233168 (sum-of-multiples/sum-of-multiples 1000))))

(deftest sum-of-configurable-to-20
  (is (= 51 (sum-of-multiples/sum-of-multiples [7 13 17] 20))))

(deftest sum-of-configurable-to-10000
  (is (= 2203160 (sum-of-multiples/sum-of-multiples [43 47] 10000))))
