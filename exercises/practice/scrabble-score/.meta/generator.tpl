(ns scrabble-score-test
  (:require [clojure.test :refer [deftest testing is]]
            scrabble-score))
{{#test_cases.score}}
(deftest score-word_test_{{idx}}
  (testing {{string description}}
    (is (= {{expected}} (scrabble-score/score-word {{string input.word}})))))
{{/test_cases.score~}}
