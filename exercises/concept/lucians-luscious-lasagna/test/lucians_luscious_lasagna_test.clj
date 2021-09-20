(ns lucians-luscious-lasagna-test
  (:require [clojure.test :refer [deftest testing is]]
            lucians-luscious-lasagna))

(deftest expected-time-test
  (is (= 40 lucians-luscious-lasagna/expected-time)))

(deftest remaining-time-test
  (is (= 15 (lucians-luscious-lasagna/remaining-time 25))))

(deftest prep-time-one-layer-test
  (is (= 2 (lucians-luscious-lasagna/prep-time 1))))

(deftest prep-time-multiple-layers-test
  (is (= 8 (lucians-luscious-lasagna/prep-time 4))))

(deftest total-time-one-layer-test
  (is (= 32 (lucians-luscious-lasagna/total-time 1 30))))

(deftest total-time-multiple-layers-test
  (is (= 16 (lucians-luscious-lasagna/total-time 4 8))))