(ns perfect-numbers-test
  (:require [clojure.test :refer [deftest testing is]]
            perfect-numbers))

{{#test_cases.classify}}
(deftest classify_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (perfect-numbers/classify {{input.number}})))))
    {{else}}
    (is (= {{expected}} (perfect-numbers/classify {{input.number}})))))
    {{/if~}}
{{/test_cases.classify}}
