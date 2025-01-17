(ns resistor-color-duo-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-duo))
{{#test_cases.value}}
(deftest value_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (resistor-color-duo/value {{input.colors}})))))
{{/test_cases.value~}}