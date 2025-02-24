(ns hamming-test
  (:require [clojure.test :refer [deftest testing is]]
            hamming))

{{#test_cases.distance}}
(deftest distance_test_{{idx}}
  (testing {{description}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (hamming/distance {{input.strand1}} {{input.strand2}})))))
    {{else}}
    (is (= {{expected}} (hamming/distance {{input.strand1}} {{input.strand2}})))))
    {{/if~}}
{{/test_cases.distance}}
