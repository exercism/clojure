(ns square-root-test
  (:require [clojure.test :refer [deftest testing is]]
            square-root))
{{#test_cases.squareRoot}}
(deftest square-root_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (square-root/square-root {{input.radicand}})))))
{{/test_cases.squareRoot~}}
