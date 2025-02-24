(ns collatz-conjecture-test
  (:require [clojure.test :refer [deftest testing is]]
            collatz-conjecture))

{{#test_cases.steps}}
(deftest collatz_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (collatz-conjecture/collatz {{input.number}})))))
    {{else}}
    (is (= {{expected}} (collatz-conjecture/collatz {{input.number}})))))
    {{/if~}}
{{/test_cases.steps}}
