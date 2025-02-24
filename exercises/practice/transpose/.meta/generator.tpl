(ns transpose-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            transpose))

{{#test_cases.transpose}}
(deftest transpose_test_{{idx}}
  (testing {{context}}
    (is (= (str/join "\n" [{{#expected~}}
                           {{.}}
                           {{/expected}}])
           (transpose/transpose
             (str/join "\n" [{{#input.lines~}}
                             {{.}}
                             {{/input.lines}}]))))))
{{/test_cases.transpose}}
