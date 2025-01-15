(ns simple-cipher-test
  (:require [clojure.test :refer [deftest testing is]]
            simple-cipher))
{{#test_cases.key}}
(deftest key_test_{{idx}}
  (testing {{description}}
    (is (true? (boolean (re-matches #{{expected.match}} (simple-cipher/rand-key)))))))
{{/test_cases.key~}}
{{#test_cases.encode}}
(deftest encode_test_{{idx}}
  (testing {{description}}
    {{#if input.key~}}
    (is (= {{expected}} (simple-cipher/encode {{input.key}} {{input.plaintext}})))))
    {{else~}}
    (let [key (simple-cipher/rand-key)]
      (is (= (subs key 0 (count {{input.plaintext}})) (simple-cipher/encode key {{input.plaintext}}))))))    
    {{/if~}}
{{/test_cases.encode~}}
{{#test_cases.decode}}
(deftest decode_test_{{idx}}
  (testing {{description}}
    {{#if input.key~}}
    (is (= {{expected}} (simple-cipher/decode {{input.key}} {{#if input.plaintext}}(simple-cipher/encode {{input.key}} {{input.plaintext}}{{else}}{{input.ciphertext}}{{/if}}))))))
    {{else~}}
    (let [key (simple-cipher/rand-key)]
      (is (= {{expected}} (simple-cipher/decode key {{#if input.plaintext}}(simple-cipher/encode key {{input.plaintext}}{{else}}(subs key 0 (count {{expected}})){{/if}})))))
    {{/if~}}
{{/test_cases.decode~}}
