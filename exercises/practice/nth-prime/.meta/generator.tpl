(ns nth-prime-test
  (:require [clojure.test :refer [deftest testing is]]
            nth-prime))

{{#test_cases.prime}}
(deftest nth-prime_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (nth-prime/nth-prime {{input.number}})))))
{{/test_cases.prime}}
