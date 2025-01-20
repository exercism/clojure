(ns resistor-color-trio-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-trio))

{{#test_cases.label}}
(deftest label_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (resistor-color-trio/label {{input.colors}})))))
{{/test_cases.label}}
