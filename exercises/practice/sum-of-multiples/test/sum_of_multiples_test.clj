(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest testing is]]
            sum-of-multiples))

(deftest sum-of-multiples_test_1
  (testing "no multiples within limit"
    (is (zero? (sum-of-multiples/sum-of-multiples '(3 5) 1)))))

(deftest sum-of-multiples_test_2
  (testing "one factor has multiples within limit"
    (is (= 3 (sum-of-multiples/sum-of-multiples '(3 5) 4)))))

(deftest sum-of-multiples_test_3
  (testing "more than one multiple within limit"
    (is (= 9 (sum-of-multiples/sum-of-multiples '(3) 7)))))

(deftest sum-of-multiples_test_4
  (testing "more than one factor with multiples within limit"
    (is (= 23 (sum-of-multiples/sum-of-multiples '(3 5) 10)))))

(deftest sum-of-multiples_test_5
  (testing "each multiple is only counted once"
    (is (= 2318 (sum-of-multiples/sum-of-multiples '(3 5) 100)))))

(deftest sum-of-multiples_test_6
  (testing "a much larger limit"
    (is (= 233168 (sum-of-multiples/sum-of-multiples '(3 5) 1000)))))

(deftest sum-of-multiples_test_7
  (testing "three factors"
    (is (= 51 (sum-of-multiples/sum-of-multiples '(7 13 17) 20)))))

(deftest sum-of-multiples_test_8
  (testing "factors not relatively prime"
    (is (= 30 (sum-of-multiples/sum-of-multiples '(4 6) 15)))))

(deftest sum-of-multiples_test_9
  (testing "some pairs of factors relatively prime and some not"
    (is (= 4419 (sum-of-multiples/sum-of-multiples '(5 6 8) 150)))))

(deftest sum-of-multiples_test_10
  (testing "one factor is a multiple of another"
    (is (= 275 (sum-of-multiples/sum-of-multiples '(5 25) 51)))))

(deftest sum-of-multiples_test_11
  (testing "much larger factors"
    (is (= 2203160 (sum-of-multiples/sum-of-multiples '(43 47) 10000)))))

(deftest sum-of-multiples_test_12
  (testing "all numbers are multiples of 1"
    (is (= 4950 (sum-of-multiples/sum-of-multiples '(1) 100)))))

(deftest sum-of-multiples_test_13
  (testing "no factors means an empty sum"
    (is (zero? (sum-of-multiples/sum-of-multiples '() 10000)))))

(deftest sum-of-multiples_test_14
  (testing "solutions using include-exclude must extend to cardinality greater than 3"
    (is (= 39614537 (sum-of-multiples/sum-of-multiples '(2 3 5 7 11) 10000)))))
