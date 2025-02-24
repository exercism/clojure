(ns wordy-test
  (:require [clojure.test :refer [deftest testing is]]
            wordy))

{{#test_cases.answer}}
(deftest evaluate_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}} (wordy/evaluate {{input.question}})))))
    {{else}}
    (is (= {{expected}} (wordy/evaluate {{input.question}})))))
    {{/if~}}
{{/test_cases.answer}}
