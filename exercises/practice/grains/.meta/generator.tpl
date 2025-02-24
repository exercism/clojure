(ns grains-test
  (:require [clojure.test :refer [deftest testing is]]
            grains))

{{#test_cases.square}}
(deftest square_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (grains/square {{input.square}})))))
    {{else}}
    (is (= {{expected}} (grains/square {{input.square}})))))
    {{/if~}}
{{/test_cases.square}}

{{#test_cases.total}}
(deftest total_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (grains/total)))))
{{/test_cases.total}}
