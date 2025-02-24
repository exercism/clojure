(ns space-age-test
  (:require [clojure.test :refer [deftest testing is]]
            space-age))

(defn- rounds-to
  [expected actual]
  (is (= (Math/round (* 100.0 expected))
         (Math/round (* 100.0 actual)))))

{{#test_cases.age}}
(deftest on-{{input.planet}}_test_1
  (testing {{context}}  
    (rounds-to {{expected}} (space-age/on-{{input.planet}} {{input.seconds}}))))
{{/test_cases.age}}
