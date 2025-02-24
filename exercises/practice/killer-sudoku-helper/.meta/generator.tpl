(ns killer-sudoku-helper-test
  (:require [clojure.test :refer [deftest testing is]]
            killer-sudoku-helper))

{{#test_cases.combinations}}
(deftest combinations_test_{{idx}}
  (testing {{context}}
    (is (= {{expected}} (killer-sudoku-helper/combinations {:sum {{input.cage.sum}} :size {{input.cage.size}} :exclude {{input.cage.exclude~}} })))))
{{/test_cases.combinations}}
