(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest testing is]]
            [sum-of-multiples :refer [sum-of-multiples]]))

(deftest no-multiples
  (testing "No multiples within limit"
    (is (zero? (sum-of-multiples '(3 5) 1)))))

(deftest one-factor-multiples
  (testing "One factor has multiples within limit"
    (is (= 3 (sum-of-multiples '(3 5) 4)))))

(deftest more-than-one-multiple
  (testing "More than one multiple within limit"
    (is (= 9 (sum-of-multiples '(3) 7)))))

(deftest more-than-one-factor-multiples
  (testing "More than one factor with multiples within limit"
    (is (= 23 (sum-of-multiples '(3 5) 10)))))

(deftest count-multiples-once
  (testing "Each multiple is only counted once"
    (is (= 2318 (sum-of-multiples '(3 5) 100)))))

(deftest larger-limit
  (testing "A much larger limit"
    (is (= 233168 (sum-of-multiples '(3 5) 1000)))))

(deftest three-factors
  (testing "Three factors"
    (is (= 51 (sum-of-multiples '(7 13 17) 20)))))

(deftest factors-not-relatively-prime
  (testing "Factors not relatively prime"
    (is (= 30 (sum-of-multiples '(4 6) 15)))))

(deftest some-factors-relatively-prime
  (testing "Some pairs of factors relatively prime and some not"
    (is (= 4419 (sum-of-multiples '(5 6 8) 150)))))

(deftest factor-multiple-of-other-factor
  (testing "One factor is a multiple of another"
    (is (= 275 (sum-of-multiples '(5 25) 51)))))

(deftest larger-factors
  (testing "Much larger factors"
    (is (= 2203160 (sum-of-multiples '(43 47) 10000)))))

(deftest all-factors-multiples-of-1
  (testing "All factors are multiples of 1"
    (is (= 4950 (sum-of-multiples '(1) 100)))))

(deftest no-factors
  (testing "No factors means sum is 0"
    (is (zero? (sum-of-multiples '() 10000)))))

(deftest more-than-three-factors
  (testing "More than 3 factors"
    (is (= 39614537 (sum-of-multiples '(2 3 5 7 11) 10000)))))
