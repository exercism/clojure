(ns knapsack-test
  (:require [clojure.test :refer [deftest testing is]]
            knapsack))

{{#test_cases.maximumValue}}
(deftest maximum-value_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (knapsack/maximum-value {{input.maximumWeight}} [{{#input.items}}
     {{.}}{{/input.items}}])))))
{{/test_cases.maximumValue}}
