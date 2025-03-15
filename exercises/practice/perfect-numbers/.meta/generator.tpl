(ns perfect-numbers-test
  (:require [clojure.test :refer [deftest testing is]]
            perfect-numbers))

{{#test_cases.classify}}
(deftest classify_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (perfect-numbers/classify {{input.number}})))))
{{/test_cases.classify}}
