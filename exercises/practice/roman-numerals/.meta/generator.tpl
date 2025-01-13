(ns roman-numerals-test
  (:require [clojure.test :refer [deftest testing is]]
            roman-numerals))
{{#test_cases.roman}}
(deftest numerals_test_{{idx}}
  (testing {{string description}}
    (is (= {{string expected}} (roman-numerals/numerals {{input.number}})))))
{{/test_cases.roman~}}
