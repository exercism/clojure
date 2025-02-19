(ns dominoes-test
  (:require [clojure.test :refer [deftest testing is]]
            dominoes))

{{#test_cases.canChain}}
(deftest can-chain?_test_{{idx}}
  (testing {{description}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (dominoes/can-chain? {{input.dominoes}})))))
{{/test_cases.canChain}}
