(ns scrabble-score-test
  (:require [clojure.test :refer [deftest testing is]]
            scrabble-score))

{{#test_cases.score}}
(deftest score-word_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (scrabble-score/score-word {{input.word}})))))
{{/test_cases.score}}
