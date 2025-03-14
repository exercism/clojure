(ns collatz-conjecture-test
  (:require [clojure.test :refer [deftest testing is]]
            collatz-conjecture))

{{#test_cases.steps}}
(deftest collatz_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (collatz-conjecture/collatz {{input.number}})))))
{{/test_cases.steps}}
