(ns isbn-verifier-test
  (:require [clojure.test :refer [deftest testing is]]
            isbn-verifier))
{{#test_cases.isValid}}
(deftest isbn?_test_{{idx}}
  (testing {{string description}}
    (is ({{#expected~}}true?{{else}}false?{{/expected}} (isbn-verifier/isbn? {{string input.isbn}})))))
{{/test_cases.isValid~}}
