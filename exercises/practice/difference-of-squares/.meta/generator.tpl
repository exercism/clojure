(ns difference-of-squares-test
  (:require [clojure.test :refer [deftest testing is]]
            difference-of-squares))
{{#test_cases.squareOfSum}}
(deftest square-of-sum_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (difference-of-squares/square-of-sum {{input.number}})))))
{{/test_cases.squareOfSum~}}
{{#test_cases.sumOfSquares}}
(deftest sum-of-squares_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (difference-of-squares/sum-of-squares {{input.number}})))))
{{/test_cases.sumOfSquares~}}
{{#test_cases.differenceOfSquares}}
(deftest difference_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (difference-of-squares/difference {{input.number}})))))
{{/test_cases.differenceOfSquares~}}
