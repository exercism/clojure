(ns connect-test
  (:require [clojure.test :refer [deftest testing is]]
            connect))

{{#test_cases.winner}}
(deftest connect-winner_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
           (connect/connect-winner
             [{{#input.board~}}
              {{.}}
              {{/input.board}}])))))
{{/test_cases.winner}}
