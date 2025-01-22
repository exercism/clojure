(ns diamond-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            diamond))

{{#test_cases.rows}}
(deftest diamond_test_{{idx}}
  (testing {{description}}
    (is (= (str/join "\n" [{{#expected}}
                           {{.}}{{/expected}}])
           (diamond/diamond {{input.letter}})))))
{{/test_cases.rows}}
