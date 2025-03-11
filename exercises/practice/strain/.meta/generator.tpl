(ns strain-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            strain))

{{#test_cases.keep}}
(deftest retain_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (strain/retain {{input.predicate}}
                          {{input.list}})))))
{{/test_cases.keep}}

{{#test_cases.discard}}
(deftest discard_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (strain/discard {{input.predicate}}
                           {{input.list}})))))
{{/test_cases.discard}}
