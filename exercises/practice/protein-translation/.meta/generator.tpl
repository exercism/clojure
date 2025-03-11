(ns protein-translation-test
  (:require [clojure.test :refer [deftest testing is]]
            protein-translation))

{{#test_cases.proteins}}
(deftest translate-rna_test_{{idx}}
  (testing {{context}}
    {{~#if error}}
    (is (thrown-with-msg? IllegalArgumentException #{{error}}
                          (protein-translation/translate-rna {{input.strand}})))))
    {{else}}
    (is (= {{expected}}
           (protein-translation/translate-rna {{input.strand}})))))
    {{/if~}}
{{/test_cases.proteins}}
