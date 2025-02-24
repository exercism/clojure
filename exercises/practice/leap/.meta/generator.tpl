(ns leap-test
  (:require [clojure.test :refer [deftest testing is]]
            leap))

{{#test_cases.leapYear}}
(deftest leap-year?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (leap/leap-year? {{input.year}})))))
{{/test_cases.leapYear}}
