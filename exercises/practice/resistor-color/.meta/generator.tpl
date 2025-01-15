(ns resistor-color-test
  (:require [clojure.test :refer [deftest testing is]]
            resistor-color))
{{#test_cases.colors}}
(deftest colors_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
           resistor-color/colors))))
{{/test_cases.colors~}}
{{#test_cases.colorCode}}
(deftest color-code_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (resistor-color/color-code {{input.color}})))))
{{/test_cases.colorCode~}}
