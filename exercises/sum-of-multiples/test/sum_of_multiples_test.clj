(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest is]]
            sum-of-multiples))

(deftest sum-to-1
  (is (zero? (sum-of-multiples/sum-of-multiples '(3 5) 1))))

(deftest sum-to-4
  (is (= 3 (sum-of-multiples/sum-of-multiples '(3 5) 4))))

(deftest sum-to-10
  (is (= 23 (sum-of-multiples/sum-of-multiples '(3 5) 10))))

(deftest sum-to-100
  (is (= 2318 (sum-of-multiples/sum-of-multiples '(3 5) 100))))

(deftest sum-to-1000
  (is (= 233168 (sum-of-multiples/sum-of-multiples '(3 5) 1000))))

(deftest sum-to-20-using-7-13-17
  (is (= 51 (sum-of-multiples/sum-of-multiples '(7 13 17) 20))))

(deftest sum-to-15-using-4-6
  (is (= 30 (sum-of-multiples/sum-of-multiples '(4 6) 15))))

(deftest sum-to-150-using-5-6-8
  (is (= 4419 (sum-of-multiples/sum-of-multiples '(5 6 8) 150))))

(deftest sum-to-51-using-5-25
  (is (= 275 (sum-of-multiples/sum-of-multiples '(5 25) 51))))

(deftest sum-to-10_000-using-43-47
  (is (= 2203160 (sum-of-multiples/sum-of-multiples '(43 47) 10000))))

(deftest sum-to-100-using-1
  (is (= 4950 (sum-of-multiples/sum-of-multiples '(1) 100))))

(deftest sum-to-10_000-using-empty
  (is (zero? (sum-of-multiples/sum-of-multiples '() 10000))))
