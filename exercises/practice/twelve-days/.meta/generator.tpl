(ns twelve-days-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            twelve-days))
{{#test_cases.recite}}
(deftest recite_test_{{idx}}
  (testing {{description}}
    (is (= (str/join "\n" [{{#expected~}}{{.}}{{#if @last}}]){{else}}
                           {{/if}}{{/expected}}
           (twelve-days/recite {{input.startVerse}} {{input.endVerse}})))))
{{/test_cases.recite~}}
