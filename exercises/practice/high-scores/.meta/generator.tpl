(ns high-scores-test
  (:require [clojure.test :refer [deftest testing is]]
            high-scores))
{{#test_cases.scores}}
(deftest scores_test_{{idx}}
  (testing {{string description}}
    (is (= {{list expected}} (high-scores/scores {{list input.scores}})))))
{{/test_cases.scores~}}
{{#test_cases.latest}}
(deftest latest_test_{{idx}}
  (testing {{string description}}
    (is (= {{expected}} (high-scores/latest {{list input.scores}})))))
{{/test_cases.latest~}}
{{#test_cases.personalBest}}
(deftest personal-best_test_{{idx}}
  (testing {{string description}}
    (is (= {{expected}} (high-scores/personal-best {{list input.scores}})))))
{{/test_cases.personalBest~}}
{{#test_cases.personalTopThree}}
(deftest personal-top-three_test_{{idx}}
  (testing {{string description}}
    (is (= {{list expected}} (high-scores/personal-top-three {{list input.scores}})))))
{{/test_cases.personalTopThree~}}
