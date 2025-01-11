(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest testing is]]
            sum-of-multiples))
{{#test_cases.sum}}
(deftest sum-of-multiples?_test_{{idx}}
  (testing "{{description}}"
    (is ({{#ifequals expected compare=0}}zero?{{else}}= {{expected}}{{/ifequals}} (sum-of-multiples/sum-of-multiples {{list input.factors}} {{input.limit}})))))
{{/test_cases.sum~}}
