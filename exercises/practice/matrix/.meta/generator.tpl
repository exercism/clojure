(ns matrix-test
  (:require [clojure.test :refer [deftest testing is]]
            matrix))

{{#test_cases.row}}
(deftest get-row_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (matrix/get-row {{input.string}} {{input.index}})))))
{{/test_cases.row}}

{{#test_cases.column}}
(deftest get-column_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (matrix/get-column {{input.string}} {{input.index}})))))
{{/test_cases.column}}
