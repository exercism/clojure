(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest testing is]]
             sum-of-multiples))

{{#test_cases.sum~}}
(deftest sum-of-multiples?_test_{{idx}}
  (testing "{{description}}"
    {{#ifequals expected compare=0~}}
    (is (zero? (sum-of-multiples/sum-of-multiples {{input.factors}} {{input.limit}})))))
    {{else~}}
    (is (= {{expected}} (sum-of-multiples/sum-of-multiples {{input.factors}} {{input.limit}})))))
    {{/ifequals}}
{{/test_cases.sum}}