(ns change-test
  (:require [clojure.test :refer [deftest testing is]]
            change))

{{#test_cases.findFewestCoins}}
(deftest issue_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (change/issue {{input.target}} {{input.coins}})))))
    {{else}}
    (is (= {{expected}}
           (change/issue {{input.target}} {{input.coins}})))))
    {{/if~}}
{{/test_cases.findFewestCoins}}
