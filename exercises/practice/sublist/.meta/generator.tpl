(ns sublist-test
  (:require [clojure.test :refer [deftest testing is]]
            sublist))
{{#test_cases.sublist}}
(deftest classify_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (sublist/classify {{input.listOne}} {{input.listTwo}})))))
{{/test_cases.sublist~}}
