(ns darts-test
  (:require [clojure.test :refer [deftest testing is]]
            darts))
{{#test_cases.score}}
(deftest score_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (darts/score {{input.x}} {{input.y}})))))
{{/test_cases.score~}}
