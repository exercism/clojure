(ns robot-simulator-test
  (:require [clojure.test :refer [deftest testing is]]
            robot-simulator))

{{#test_cases.create}}
(deftest robot_test_{{idx}}
  (testing {{context}}
    (let [molly (robot-simulator/robot {:x {{input.position.x}} :y {{input.position.y}} } {{input.direction}})]
      (is (= {:bearing {{expected.direction}} :coordinates {:x {{expected.position.x}} :y {{expected.position.y}} }}
             molly)))))
{{/test_cases.create}}

{{#test_cases.move}}
(deftest simulate_test_{{idx}}
  (testing {{context}}
    (let [molly (robot-simulator/robot {:x {{input.position.x}} :y {{input.position.y}} } {{input.direction}})]
      (is (= {:bearing {{expected.direction}} :coordinates {:x {{expected.position.x}} :y {{expected.position.y}} }}
             (robot-simulator/simulate {{input.instructions}} molly))))))
{{/test_cases.move}}
