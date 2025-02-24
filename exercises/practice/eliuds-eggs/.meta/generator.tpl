(ns eliuds-eggs-test
  (:require [clojure.test :refer [deftest testing is]]
            eliuds-eggs))

{{#test_cases.eggCount}}
(deftest egg-count_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (eliuds-eggs/egg-count {{input.number}})))))
{{/test_cases.eggCount}}
