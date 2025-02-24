(ns largest-series-product-test
  (:require [clojure.test :refer [deftest testing is]]
            largest-series-product))

{{#test_cases.largestProduct}}
(deftest largest-product_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}} (largest-series-product/largest-product {{input.span}} {{input.digits}})))))
    {{else}}
    (is (= {{expected}} (largest-series-product/largest-product {{input.span}} {{input.digits}})))))
    {{/if~}}
{{/test_cases.largestProduct}}
