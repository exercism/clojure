(ns atbash-cipher-test
  (:require [clojure.test :refer [deftest testing is]]
            atbash-cipher))

{{#test_cases.encode}}
(deftest encode_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
        (atbash-cipher/encode {{input.phrase}})))))
{{/test_cases.encode}}

{{#test_cases.decode}}
(deftest decode_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
        (atbash-cipher/decode {{input.phrase}})))))
{{/test_cases.decode}}
