(ns twelve-days-test
  (:require [clojure.test :refer [deftest testing is]]
            twelve-days))
{{#test_cases.recite}}
(deftest recite_test_{{idx}}
  (testing {{description}}
    (is (= (twelve-days/recite {{input.startVerse}} {{input.endVerse}})
           [{{~#expected}}
             {{.}}
             {{~/expected}}
           ]))))
{{/test_cases.recite~}}
