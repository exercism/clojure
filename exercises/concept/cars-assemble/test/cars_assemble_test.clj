(ns assembly-line-test
  (:require [clojure.test :refer [deftest testing is]]
            assembly-line))

(deftest production-rate-test
  (testing "Production rate for"
    (testing "speed 0"
      (is (= 0.0 (assembly-line/production-rate 0))))
    (testing "speed 1"
      (is (= 221.0 (assembly-line/production-rate 1))))
    (testing "speed 4"
      (is (= 884.0 (assembly-line/production-rate 4))))
    (testing "speed 7"
      (is (= 1392.3 (assembly-line/production-rate 7))))
    (testing "speed 9"
      (is (= 1591.2 (assembly-line/production-rate 9))))
    (testing "speed 10"
      (is (= 1701.7 (assembly-line/production-rate 10))))))

(deftest working-items-test
  (testing "Working items for"
    (testing "speed 0"
      (is (= 0 (assembly-line/working-items 0))))
    (testing "speed 1"
      (is (= 3 (assembly-line/working-items 1))))
    (testing "speed 5"
      (is (= 16 (assembly-line/working-items 5))))
    (testing "speed 8"
      (is (= 26 (assembly-line/working-items 8))))
    (testing "speed 9"
      (is (= 26 (assembly-line/working-items 9))))
    (testing "speed 10"
      (is (= 28 (assembly-line/working-items 10))))))
