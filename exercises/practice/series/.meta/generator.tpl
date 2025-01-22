(ns series-test
  (:require [clojure.test :refer [deftest testing is]]
            series))

{{#test_cases.slices}}
(deftest slices_test_{{idx}}
  (testing {{description}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (series/slices {{input.series}} {{input.sliceLength}})))))
    {{else}}
    (is (= {{expected}}
           (series/slices {{input.series}} {{input.sliceLength}})))))
    {{/if~}}
{{/test_cases.slices}}
