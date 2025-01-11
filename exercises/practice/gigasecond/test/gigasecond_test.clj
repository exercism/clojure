(ns gigasecond-test
  (:require [clojure.test :refer [deftest testing is]]
            gigasecond))

(deftest from_test_1
  (testing "date-only specification of time"
    (is (= [2043 1 1] (gigasecond/from 2011 4 25)))))

(deftest from_test_2
  (testing "second test for date-only specification of time"
    (is (= [2009 2 19] (gigasecond/from 1977 6 13)))))

(deftest from_test_3
  (testing "third test for date-only specification of time"
    (is (= [1991 3 27] (gigasecond/from 1959 7 19)))))

(deftest from_test_4
  (testing "does not mutate the input"
    (let [date [1959 7 19]
          new-date (apply gigasecond/from date)]
      (is (= [1959 7 19] date)))))
