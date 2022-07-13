(ns bird-watcher-test
  (:require bird-watcher
            [clojure.test :refer [deftest is testing]]))

(deftest ^{:task 1} last-week-test
  (is (= [0 2 5 3 7 8 4] bird-watcher/last-week)))

(deftest ^{:task 2} today-disappointing-week-test
  (testing "Today's bird count of disappointing week"
    (is (= 0 (bird-watcher/today [0 0 2 0 0 1 0])))))

(deftest ^{:task 2} today-busy-week-test
  (testing "Today's bird count of busy week"
    (is (= 10 (bird-watcher/today [8 8 9 5 4 7 10])))))

(deftest ^{:task 3} increment-bird-no-visits-test
  (testing "Increment today's count with no previous visits"
    (is (= [6 5 5 11 2 5 1] (bird-watcher/inc-bird [6 5 5 11 2 5 0])))))

(deftest ^{:task 3} increment-bird-multiple-visits-test
  (testing "Increment today's count with multiple previous visits"
    (is (= [5 2 4 2 4 5 8] (bird-watcher/inc-bird [5 2 4 2 4 5 7])))))

(deftest ^{:task 4} day-without-birds-test
  (testing "Has day without birds with day without birds"
    (is (= true (bird-watcher/day-without-birds? [5 5 4 0 7 6 7])))))

(deftest ^{:task 4} no-day-without-birds-test
  (testing "Has day without birds with no day without birds"
    (is (= false (bird-watcher/day-without-birds? [5 5 4 1 7 6 7])))))

(deftest ^{:task 5} n-days-count-disappointing-week-test
  (testing "Count for first three days of disappointing week"
    (is (= 1 (bird-watcher/n-days-count [0, 0, 1, 0, 0, 1, 0] 3)))))

(deftest ^{:task 5} n-days-count-busy-week-test
  (testing "Count for first 6 days of busy week"
    (is (= 48 (bird-watcher/n-days-count [5, 9, 12, 6, 8, 8, 17] 6)))))

(deftest ^{:task 6} busy-days-disappointing-week-test
  (testing "Busy days for disappointing week"
    (is (= 0 (bird-watcher/busy-days [1 1 1 0 0 0 0])))))

(deftest ^{:task 6} busy-days-busy-week-test
  (testing "Busy days for busy week"
    (is (= 5 (bird-watcher/busy-days [4 9 5 7 8 8 2])))))

(deftest ^{:task 7} odd-week-matching-test
  (testing "Odd week for week matching odd pattern"
    (is (= true (bird-watcher/odd-week? [1 0 1 0 1 0 1])))))

(deftest ^{:task 7} odd-week-not-matching-test
  (testing "Odd week for week that does not match pattern"
    (is (= false (bird-watcher/odd-week? [2 2 1 0 1 1 1])))))