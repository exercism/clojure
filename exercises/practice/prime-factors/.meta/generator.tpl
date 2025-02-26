(ns prime-factors-test
  (:require [clojure.test :refer [deftest testing is]]
            prime-factors))

{{#test_cases.factors}}
(deftest of_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (prime-factors/of {{input.value}})))))
{{/test_cases.factors}}
