(ns reverse-string-test
  (:require [clojure.test :refer [deftest testing is]]
            reverse-string))

{{#test_cases.reverse}}
(deftest reverse-string_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (reverse-string/reverse-string {{input.value}})))))
{{/test_cases.reverse}}
