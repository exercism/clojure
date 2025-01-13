(ns isogram-test
  (:require [clojure.test :refer [deftest testing is]]
            isogram))
{{#test_cases.isIsogram}}
(deftest isogram?_test_{{idx}}
  (testing {{string description}}
    (is ({{#expected~}}true?{{else}}false?{{/expected}} (isogram/isogram? {{string input.phrase}})))))
{{/test_cases.isIsogram~}}
