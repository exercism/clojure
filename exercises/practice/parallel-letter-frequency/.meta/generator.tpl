(ns parallel-letter-frequency-test
  (:require [clojure.test :refer [deftest testing is]]
            parallel-letter-frequency))
{{#test_cases.calculateFrequencies}}
(deftest calculate-frequencies_test_{{idx}}
  (testing {{string description}}
    (is (= {{expected}}
           (parallel-letter-frequency/calculate-frequencies {{input.texts}})))))
{{/test_cases.calculateFrequencies~}}
