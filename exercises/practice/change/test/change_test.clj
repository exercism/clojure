(ns change-test
  (:require [clojure.test :refer [deftest is]]
            [change :refer [issue]]))

(deftest single-coin-change
  (is (= (issue 25 #{1 5 10 25 100})
         '(25))))

(deftest multiple-coin-change
  (is (= (issue 15 #{1 5 10 25 100})
         '(5 10))))

(deftest change-with-lilliputian-coins
  (is (= (issue 23 #{1 4 15 20 50})
         '(4 4 15))))

(deftest change-with-elbonia-coins
  (is (= (issue 63 #{1 5 10 21 25})
         '(21 21 21))))

(deftest large-target-values
  (is (= (issue 999 #{1 2 5 10 20 50 100})
         '(2 2 5 20 20 50 100 100 100 100 100 100 100 100 100))))

(deftest no-coins-make-zero-change
  (is (empty? (issue 0 #{1, 5, 10, 21, 25}))))

(deftest error-testing-for-change-smallet-than-the-smallest-coin
  (is (thrown-with-msg? IllegalArgumentException #"cannot change"
                        (issue 3 #{5 10}))))

(deftest cannot-find-negative-change-values
  (is (thrown-with-msg? IllegalArgumentException #"cannot change"
                        (issue -5 #{1 2 5}))))
