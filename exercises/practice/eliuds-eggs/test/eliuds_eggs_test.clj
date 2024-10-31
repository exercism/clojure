(ns eliuds-eggs-test
  (:require [clojure.test :refer [deftest is]]
            eliuds-eggs))

(deftest no-eggs
  (is (= 0 (eliuds-eggs/egg-count 0))))

(deftest one-egg
  (is (= 1 (eliuds-eggs/egg-count 16))))

(deftest four-eggs
  (is (= 4 (eliuds-eggs/egg-count 89))))

(deftest thirteen-eggs
  (is (= 13 (eliuds-eggs/egg-count 2000000000))))