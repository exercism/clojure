(ns resistor-color-duo-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-duo))

{{#test_cases.value}}
(deftest resistor-value_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (resistor-color-duo/resistor-value {{input.colors}})))))
{{/test_cases.value}}