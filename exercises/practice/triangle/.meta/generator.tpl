(ns triangle-test
  (:require [clojure.test :refer [deftest testing is]]
            triangle))

{{#test_cases.equilateral}}
(deftest ^:equilateral? equilateral?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (triangle/equilateral? {{input.sides.0}} {{input.sides.1}} {{input.sides.2}})))))
{{/test_cases.equilateral}}

{{#test_cases.isosceles}}
(deftest ^:isosceles? isosceles?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (triangle/isosceles? {{input.sides.0}} {{input.sides.1}} {{input.sides.2}})))))
{{/test_cases.isosceles}}

{{#test_cases.scalene}}
(deftest ^:scalene? scalene?_test_{{idx}}
  (testing {{context}}
    (is ({{#expected}}true?{{else}}false?{{/expected}} (triangle/scalene? {{input.sides.0}} {{input.sides.1}} {{input.sides.2}})))))
{{/test_cases.scalene}}
