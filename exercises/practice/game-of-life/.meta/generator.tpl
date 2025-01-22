(ns game-of-life-test
  (:require [clojure.test :refer [deftest testing is]]
            game-of-life))

{{#test_cases.tick}}
(deftest tick_test_{{idx}}
  (testing {{description}}
    (is
      (= [{{#expected~}}
          {{.}}
          {{/expected}}]
         (game-of-life/tick
           [{{#input.matrix~}}
            {{.}}
            {{/input.matrix}}])))))
{{/test_cases.tick}}
