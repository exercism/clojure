(ns allergies-test
  (:require [clojure.test :refer [deftest testing is]]
            allergies))

{{#test_cases.allergicTo}}
(deftest allergic-to?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (allergies/allergic-to? {{input.score}} {{input.item}})))))
{{/test_cases.allergicTo}}

{{#test_cases.list}}
(deftest allergies_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (allergies/allergies {{input.score}})))))
{{/test_cases.list}}
