(ns sieve-test
  (:require [clojure.test :refer [deftest testing is]]
            sieve))

{{#test_cases.primes}}
(deftest sieve_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
           (sieve/sieve {{input.limit}})))))
{{/test_cases.primes}}
