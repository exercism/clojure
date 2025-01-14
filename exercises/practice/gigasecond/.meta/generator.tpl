(ns gigasecond-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.instant :refer [read-instant-date]]
            gigasecond))
{{#test_cases.add}}
(deftest from_test_{{idx}}
  (testing {{string description}}
    (is (read-instant-date {{string expected}}) (gigasecond/from (read-instant-date {{string input.moment}})))))
{{/test_cases.add}}
(deftest from_test_4
  (testing "does not mutate the input"
    (let [date (read-instant-date "{{test_cases.isEqual.0.input.moment}}")
          _ (apply gigasecond/from date)]
      (is (= [1959 7 19] date)))))
