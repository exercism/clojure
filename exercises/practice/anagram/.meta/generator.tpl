(ns anagram-test
  (:require [clojure.test :refer [deftest testing is]]
            anagram))
{{#test_cases.findAnagrams}}
(deftest anagrams-for_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
           (anagram/anagrams-for {{input.subject}} {{input.candidates}})))))
{{/test_cases.findAnagrams~}}
