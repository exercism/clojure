(ns acronym-test
  (:require [clojure.test :refer [deftest testing is]]
            acronym))

{{#test_cases.abbreviate}}
(deftest acronym_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (acronym/acronym {{input.phrase}})))))
{{/test_cases.abbreviate}}
