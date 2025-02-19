(ns eliuds-eggs-test
  (:require [clojure.test :refer [deftest testing is]]
            eliuds-eggs))

(deftest egg-count_test_1
  (testing "0 eggs"
    (is (= 0 (eliuds-eggs/egg-count 0)))))

(deftest egg-count_test_2
  (testing "1 egg"
    (is (= 1 (eliuds-eggs/egg-count 16)))))

(deftest egg-count_test_3
  (testing "4 eggs"
    (is (= 4 (eliuds-eggs/egg-count 89)))))

(deftest egg-count_test_4
  (testing "13 eggs"
    (is (= 13 (eliuds-eggs/egg-count 2000000000)))))
