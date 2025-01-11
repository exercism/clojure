(ns pangram-test
  (:require [clojure.test :refer [deftest testing is]]
             pangram))

{{#test_cases.isPangram~}}
(deftest pangram?_test_{{idx}}
  (testing "{{description}}"
    {{#expected~}}
    (is (pangram/pangram? "{{input.sentence}}"))))
    {{else~}}
    (is (not (pangram/pangram? "{{input.sentence}}")))))
    {{/expected}}
{{/test_cases.isPangram}}