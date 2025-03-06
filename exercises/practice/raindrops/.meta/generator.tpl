(ns raindrops-test
  (:require [clojure.test :refer [deftest testing is]]
            raindrops))

{{#test_cases.convert}}
(deftest convert_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (raindrops/convert {{input.number}})))))
{{/test_cases.convert}}
