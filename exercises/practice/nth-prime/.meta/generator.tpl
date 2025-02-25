(ns nth-prime-test
  (:require [clojure.test :refer [deftest testing is]]
            nth-prime))

{{#test_cases.prime}}
(deftest nth-prime_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (nth-prime/nth-prime {{input.number}})))))
    {{else}}
    (is (= {{expected}} (nth-prime/nth-prime {{input.number}})))))
    {{/if~}}
{{/test_cases.prime}}
