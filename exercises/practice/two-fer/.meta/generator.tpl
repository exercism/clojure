(ns two-fer-test
  (:require [clojure.test :refer [deftest testing is]]
            two-fer))
{{#test_cases.twoFer}}
(deftest two-fer_test_{{idx}}
  (testing {{string description}}
    (is (= {{string expected}} (two-fer/two-fer{{#input.name}} {{string input.name}}{{/input.name}})))))
{{/test_cases.twoFer~}}
