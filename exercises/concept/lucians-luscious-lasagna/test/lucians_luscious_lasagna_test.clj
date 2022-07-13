(ns lucians-luscious-lasagna-test
  (:require [clojure.test :refer [deftest is]]
            lucians-luscious-lasagna))

(deftest ^{:task 1} expected-time-test
  (is (= 40 lucians-luscious-lasagna/expected-time)))

(deftest ^{:task 2} remaining-time-test
  (is (= 15 (lucians-luscious-lasagna/remaining-time 25))))

(deftest ^{:task 3} prep-time-one-layer-test
  (is (= 2 (lucians-luscious-lasagna/prep-time 1))))

(deftest ^{:task 3} prep-time-multiple-layers-test
  (is (= 8 (lucians-luscious-lasagna/prep-time 4))))

(deftest ^{:task 4} total-time-one-layer-test
  (is (= 32 (lucians-luscious-lasagna/total-time 1 30))))

(deftest ^{:task 4} total-time-multiple-layers-test
  (is (= 16 (lucians-luscious-lasagna/total-time 4 8))))