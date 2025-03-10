(ns luhn-test
  (:require [clojure.test :refer [deftest testing is]]
            luhn))

{{#test_cases.valid}}
(deftest valid?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (luhn/valid? {{input.value}})))))
{{/test_cases.valid}}
