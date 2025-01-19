(ns pangram-test
  (:require [clojure.test :refer [deftest testing is]]
            pangram))

{{#test_cases.isPangram}}
(deftest pangram?_test_{{idx}}
  (testing {{description}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (pangram/pangram? {{input.sentence}})))))
{{/test_cases.isPangram}}
