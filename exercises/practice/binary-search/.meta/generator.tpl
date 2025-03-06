(ns binary-search-test
  (:require [clojure.test :refer [deftest testing is]]
            binary-search))

{{#test_cases.find}}
(deftest search-for_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (= -1 (binary-search/search-for {{input.value}} {{input.array}})))))
    {{else}}
    (is (= {{expected}} (binary-search/search-for {{input.value}} {{input.array}})))))
    {{/if~}}
{{/test_cases.find}}
