(ns exercism.assembly-line-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.assembly-line))

(deftest production-rate-test
  (testing "Production rate for"
    (testing "speed 0"
      (is (= 0.0 (exercism.assembly-line/production-rate 0))))
    (testing "speed 1"
      (is (= 221.0 (exercism.assembly-line/production-rate 1))))
    (testing "speed 4"
      (is (= 884.0 (exercism.assembly-line/production-rate 4))))
    (testing "speed 7"
      (is (= 1392.3 (exercism.assembly-line/production-rate 7))))
    (testing "speed 9"
      (is (= 1591.2 (exercism.assembly-line/production-rate 9))))
    (testing "speed 10"
      (is (= 1701.7 (exercism.assembly-line/production-rate 10))))))

(deftest working-items-test
  (testing "Working items for"
    (testing "speed 0"
      (is (= 0 (exercism.assembly-line/working-items 0))))
    (testing "speed 1"
      (is (= 3 (exercism.assembly-line/working-items 1))))
    (testing "speed 5"
      (is (= 16 (exercism.assembly-line/working-items 5))))
    (testing "speed 8"
      (is (= 26 (exercism.assembly-line/working-items 8))))
    (testing "speed 9"
      (is (= 26 (exercism.assembly-line/working-items 9))))
    (testing "speed 10"
      (is (= 28 (exercism.assembly-line/working-items 10))))))
