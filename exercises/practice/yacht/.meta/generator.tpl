(ns yacht-test
  (:require [clojure.test :refer [deftest testing is]]
            yacht))
{{#test_cases.score}}
(deftest score_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (yacht/score {{input.dice}} {{input.category}})))))
{{/test_cases.score~}}
