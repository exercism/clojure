(ns collatz-conjecture-test
  (:require [clojure.test :refer [deftest is testing]]
            [collatz-conjecture :refer [collatz]]))

(deftest steps-for-1
  (testing "zero steps for one"
    (is (= 0 (collatz 1)))))

(deftest steps-for-16
  (testing "divide if even"
    (is (= 4 (collatz 16)))))

(deftest steps-for-12
  (testing "even and odd steps"
    (is (= 9 (collatz 12)))))

(deftest steps-for-1000000
  (testing "Large number of even and odd steps"
    (is (= 152 (collatz 1000000)))))

(deftest steps-for-0
  (testing "zero is an error"
    (is (thrown? Throwable
                 (collatz 0)))))

(deftest steps-for-negative
  (testing "negative value is an error"
    (is (thrown? Throwable
                 (collatz -15)))))
