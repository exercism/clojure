(ns zebra-puzzle-test
  (:require [clojure.test :refer [deftest testing is]]
            zebra-puzzle))

(deftest drinks-water_test_1
  (testing "resident who drinks water"
    (is (= :norwegian (zebra-puzzle/drinks-water)))))

(deftest owns-zebra_test_1
  (testing "resident who owns zebra"
    (is (= :japanese (zebra-puzzle/owns-zebra)))))
