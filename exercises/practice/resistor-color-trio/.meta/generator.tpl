(ns resistor-color-trio-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color-trio))

{{#test_cases.label}}
(deftest resistor-label_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (resistor-color-trio/resistor-label {{input.colors}})))))
{{/test_cases.label}}
