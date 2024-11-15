(ns gigasecond-test
  (:require [clojure.test :refer [deftest testing is]]
            gigasecond))

(deftest test-92fbe71c-ea52-4fac-bd77-be38023cacf7
  (testing "Date-only specification of time"
    (is (= [2043 1 1] (gigasecond/from 2011 4 25)))))

(deftest test-6d86dd16-6f7a-47be-9e58-bb9fb2ae1433
  (testing "Second test for date-only specification of time"
    (is (= [2009 2 19] (gigasecond/from 1977 6 13)))))

(deftest test-77eb8502-2bca-4d92-89d9-7b39ace28dd5
  (testing "Third test for date-only specification of time"
    (is (= [1991 3 27] (gigasecond/from 1959 7 19)))))

(deftest test-fcec307c-7529-49ab-b0fe-20309197618a
  (testing "Does not mutate the input"
    (let [date [1959 7 19]
          new-date (apply gigasecond/from date)]
      (is (= [1959 7 19] date)))))
