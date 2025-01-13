(ns square-root-test
  (:require [clojure.test :refer [deftest testing is]]
            square-root))

(deftest square-root_test_1
  (testing "root of 1"
    (is (= 1 (square-root/square-root 1)))))

(deftest square-root_test_2
  (testing "root of 4"
    (is (= 2 (square-root/square-root 4)))))

(deftest square-root_test_3
  (testing "root of 25"
    (is (= 5 (square-root/square-root 25)))))

(deftest square-root_test_4
  (testing "root of 81"
    (is (= 9 (square-root/square-root 81)))))

(deftest square-root_test_5
  (testing "root of 196"
    (is (= 14 (square-root/square-root 196)))))

(deftest square-root_test_6
  (testing "root of 65025"
    (is (= 255 (square-root/square-root 65025)))))
