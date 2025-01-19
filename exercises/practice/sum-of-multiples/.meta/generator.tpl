(ns sum-of-multiples-test
  (:require [clojure.test :refer [deftest testing is]]
            sum-of-multiples))

{{#test_cases.sum}}
(deftest sum-of-multiples_test_{{idx}}
  (testing {{description}}
    (is ({{#ifzero expected}}zero?{{else}}= {{expected}}{{/ifzero}} (sum-of-multiples/sum-of-multiples {{input.factors}} {{input.limit}})))))
{{/test_cases.sum}}
