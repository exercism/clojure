(ns food-chain-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            food-chain))

{{#test_cases.recite}}
(deftest recite_test_{{idx}}
  (testing {{context}}
    (is (= (str/join "\n" [{{#expected~}}{{.}}{{#if @last}}]){{else}}
                           {{/if}}{{/expected}}
           (food-chain/recite {{input.startVerse}} {{input.endVerse}})))))
{{/test_cases.recite}}
