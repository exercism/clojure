(ns rna-transcription-test
  (:require [clojure.test :refer [deftest testing is]]
            rna-transcription))

{{#test_cases.toRna}}
(deftest to-rna_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (rna-transcription/to-rna {{input.dna}})))))
{{/test_cases.toRna}}
