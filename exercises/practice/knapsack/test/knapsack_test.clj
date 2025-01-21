(ns knapsack-test
  (:require [clojure.test :refer [deftest testing is]]
            knapsack))

(deftest maximum-value_test_1
  (testing "no items"
    (is (= 0 (knapsack/maximum-value 100 [])))))

(deftest maximum-value_test_2
  (testing "one item, too heavy"
    (is (= 0 (knapsack/maximum-value 10 [{:weight 100, :value 1}])))))

(deftest maximum-value_test_3
  (testing "five items (cannot be greedy by weight)"
    (is (= 21 (knapsack/maximum-value 10 [{:weight 2, :value 5}
                                          {:weight 2, :value 5}
                                          {:weight 2, :value 5}
                                          {:weight 2, :value 5}
                                          {:weight 10, :value 21}])))))

(deftest maximum-value_test_4
  (testing "five items (cannot be greedy by value)"
    (is (= 80 (knapsack/maximum-value 10 [{:weight 2, :value 20}
                                          {:weight 2, :value 20}
                                          {:weight 2, :value 20}
                                          {:weight 2, :value 20}
                                          {:weight 10, :value 50}])))))

(deftest maximum-value_test_5
  (testing "example knapsack"
    (is (= 90 (knapsack/maximum-value 10 [{:weight 5, :value 10}
                                          {:weight 4, :value 40}
                                          {:weight 6, :value 30}
                                          {:weight 4, :value 50}])))))

(deftest maximum-value_test_6
  (testing "8 items"
    (is (= 900 (knapsack/maximum-value 104 [{:weight 25, :value 350}
                                            {:weight 35, :value 400}
                                            {:weight 45, :value 450}
                                            {:weight 5, :value 20}
                                            {:weight 25, :value 70}
                                            {:weight 3, :value 8}
                                            {:weight 2, :value 5}
                                            {:weight 2, :value 5}])))))

(deftest maximum-value_test_7
  (testing "15 items"
    (is (= 1458 (knapsack/maximum-value 750 [{:weight 70, :value 135}
                                             {:weight 73, :value 139}
                                             {:weight 77, :value 149}
                                             {:weight 80, :value 150}
                                             {:weight 82, :value 156}
                                             {:weight 87, :value 163}
                                             {:weight 90, :value 173}
                                             {:weight 94, :value 184}
                                             {:weight 98, :value 192}
                                             {:weight 106, :value 201}
                                             {:weight 110, :value 210}
                                             {:weight 113, :value 214}
                                             {:weight 115, :value 221}
                                             {:weight 118, :value 229}
                                             {:weight 120, :value 240}])))))
