(ns state-of-tic-tac-toe-test
  (:require [clojure.test :refer [deftest testing is]]
            state-of-tic-tac-toe))
{{#test_cases.gamestate}}
(deftest gamestate_test_{{idx}}
  (testing {{context}}
    {{~#if expected.error}}
    (is (thrown-with-msg? IllegalArgumentException #{{expected.error}}
                          (state-of-tic-tac-toe/gamestate 
                            [{{~#input.board}}
                             {{.}}
                             {{~/input.board}}
                            ])))))
    {{else}}
    (is (= {{expected}}
           (state-of-tic-tac-toe/gamestate
             [{{~#input.board}}
              {{.}}
              {{~/input.board}}
             ])))))
    {{/if~}}
{{/test_cases.gamestate}}
