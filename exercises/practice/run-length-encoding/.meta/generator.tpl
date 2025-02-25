(ns run-length-encoding-test
  (:require [clojure.test :refer [deftest testing is]]
            run-length-encoding))

{{#test_cases.encode}}
(deftest run-length-encode_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (run-length-encoding/run-length-encode {{input.string}})))))
{{/test_cases.encode}}

{{#test_cases.decode}}
(deftest run-length-decode_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (run-length-encoding/run-length-decode {{input.string}})))))
{{/test_cases.decode}}
