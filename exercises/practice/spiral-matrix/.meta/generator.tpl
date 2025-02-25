(ns spiral-matrix-test
  (:require [clojure.test :refer [deftest testing is]]
            spiral-matrix))

{{#test_cases.spiralMatrix}}
(deftest spiral_test_{{idx}}
  (testing {{context}}
    (is (= [{{#expected}}
            {{.}}
            {{~/expected}}]
           (spiral-matrix/spiral {{input.size}})))))
{{/test_cases.spiralMatrix}}
