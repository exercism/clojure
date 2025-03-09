(ns list-ops-test
  (:require [clojure.test :refer [deftest testing is]]
            list-ops))

{{#test_cases.append}}
(deftest append_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (list-ops/append {{input.list1}} {{input.list2}})))))
{{/test_cases.append}}

{{#test_cases.concat}}
(deftest concatenate_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (list-ops/concatenate {{input.lists}})))))
{{/test_cases.concat}}

{{#test_cases.filter}}
(deftest select-if_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (list-ops/select-if {{input.function}} {{input.list}})))))
{{/test_cases.filter}}

{{#test_cases.length}}
(deftest length_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (list-ops/length {{input.list}})))))
{{/test_cases.length}}

{{#test_cases.map}}
(deftest apply-to-each_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (list-ops/apply-to-each {{input.function}} {{input.list}})))))
{{/test_cases.map}}

{{#test_cases.foldl}}
(deftest foldl_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (list-ops/foldl {{input.function}} {{input.list}} {{input.initial}})))))
{{/test_cases.foldl}}

{{#test_cases.foldr}}
(deftest foldr_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (list-ops/foldr {{input.function}} {{input.list}} {{input.initial}})))))
{{/test_cases.foldr}}

{{#test_cases.reverse}}
(deftest reverse-order_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}}
           (list-ops/reverse-order {{input.list}})))))
{{/test_cases.reverse}}
