(ns matching-brackets-test
  (:require [clojure.test :refer [deftest testing is]]
            matching-brackets))

{{#test_cases.isPaired}}
(deftest valid?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (matching-brackets/valid? {{input.value}})))))
{{/test_cases.isPaired}}
