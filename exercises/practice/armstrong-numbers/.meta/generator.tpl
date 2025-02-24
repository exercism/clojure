(ns armstrong-numbers-test
  (:require [clojure.test :refer [deftest testing is]]
            armstrong-numbers))

{{#test_cases.isArmstrongNumber}}
(deftest armstrong?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (armstrong-numbers/armstrong? {{input.number}})))))
{{/test_cases.isArmstrongNumber}}
