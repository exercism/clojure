(ns exercism.lasagna-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.lasagna))

(deftest expected-time-test
  (is (= 40 (exercism.lasagna/expected-time))))

(deftest remaining-time-test
  (is (= 15 (exercism.lasagna/remaining-time 25))))

(deftest prep-time-test
  (testing "Preparation time in minutes"
    (testing "for one layer"
      (is (= 2 (exercism.lasagna/prep-time 1))))
    (testing "for multiple layers"
      (is (= 8 (exercism.lasagna/prep-time 4))))))

(deftest total-time-test
  (testing "Total elapsed time in minutes"
    (testing "for one layer"
      (is (= 32 (exercism.lasagna/total-time 1 30))))
    (testing "for multiple layers"
      (is (= 16 (exercism.lasagna/total-time 4 8))))))