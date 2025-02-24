(ns pythagorean-triplet-test
  (:require [clojure.test :refer [deftest testing is]]
            pythagorean-triplet))

{{#test_cases.tripletsWithSum}}
(deftest find-pythagorean-triplets_test_{{idx}}
  (testing {{context}}
    (is (= [{{#expected~}}
            {{.}}
            {{/expected}}]
           (pythagorean-triplet/find-pythagorean-triplets {{input.n}})))))
{{/test_cases.tripletsWithSum}}
