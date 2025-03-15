(ns nth-prime-test
  (:require [clojure.test :refer [deftest testing is]]
            nth-prime))

(deftest nth-prime_test_1
  (testing "first prime"
    (is (= 2 (nth-prime/nth-prime 1)))))

(deftest nth-prime_test_2
  (testing "second prime"
    (is (= 3 (nth-prime/nth-prime 2)))))

(deftest nth-prime_test_3
  (testing "sixth prime"
    (is (= 13 (nth-prime/nth-prime 6)))))

(deftest nth-prime_test_4
  (testing "big prime"
    (is (= 104743 (nth-prime/nth-prime 10001)))))
