(ns pig-latin-test
  (:require [clojure.test :refer [deftest testing is]]
            pig-latin))
{{#test_cases.translate}}
(deftest translate_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (pig-latin/translate {{input.phrase}})))))
{{/test_cases.translate~}}
