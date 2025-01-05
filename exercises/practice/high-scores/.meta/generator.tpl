(ns high-scores-test
  (:require [clojure.test :refer [deftest testing is]]
            high-scores))
{{#test_cases.scores}}
(deftest scores_test_{{idx}}
  (testing "{{description}}"
    (is (= {{expected}} (high-scores/scores {{input.scores}})))))
{{/test_cases.scores~}}
{{#test_cases.latest}}
(deftest latest_test_{{idx}}
  (testing "{{description}}"
    (is (= {{expected}} (high-scores/latest {{input.scores}})))))
{{/test_cases.latest~}}
{{#test_cases.personalBest}}
(deftest personal-best_test_{{idx}}
  (testing "{{description}}"
    (is (= {{expected}} (high-scores/personal-best {{input.scores}})))))
{{/test_cases.personalBest~}}
{{#test_cases.personalTopThree}}
(deftest personal-top-three_test_{{idx}}
  (testing "{{description}}"
    (is (= {{expected}} (high-scores/personal-top-three {{input.scores}})))))
{{/test_cases.personalTopThree~}}
