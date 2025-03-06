(ns flatten-array-test
  (:require [clojure.test :refer [deftest testing is]]
            flatten-array))

{{#test_cases.flatten}}
(deftest flatten_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (flatten-array/flatten {{input.array}})))))
{{/test_cases.flatten}}
