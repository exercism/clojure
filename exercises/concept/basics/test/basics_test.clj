(ns basics-test
  (:require [clojure.test :refer [deftest testing is]]
            basics))

(deftest expected-time-test
  (is (= 40 (basics/expected-time))))

(deftest remaining-time-test
  (is (= 15 (basics/remaining-time 25))))

(deftest prep-time-test
  (testing "Preparation time in minutes"
    (testing "for one layer"
      (is (= 2 (basics/prep-time 1))))
    (testing "for multiple layers"
      (is (= 8 (basics/prep-time 4))))))

(deftest total-time-test
  (testing "Total elapsed time in minutes"
    (testing "for one layer"
      (is (= 32 (basics/total-time 1 30))))
    (testing "for multiple layers"
      (is (= 16 (basics/total-time 4 8))))))