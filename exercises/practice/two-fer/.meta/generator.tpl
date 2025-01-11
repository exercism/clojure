(ns two-fer-test
  (:require [clojure.test :refer [deftest testing is]]
             two-fer))
{{#test_cases.twoFer}}
(deftest two-fer_test_{{idx}}
  (testing "{{description}}"
    (is (= "{{expected}}" (two-fer/two-fer{{#input.name}} "{{input.name}}"{{/input.name}})))))
{{/test_cases.twoFer}}
