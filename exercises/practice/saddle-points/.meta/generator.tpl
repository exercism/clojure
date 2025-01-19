(ns saddle-points-test
  (:require [clojure.test :refer [deftest testing is]]
            saddle-points))

{{#test_cases.saddlePoints}}
(deftest saddle-points_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}}
           (saddle-points/saddle-points
             [{{#input.matrix}}
              {{.}}
              {{~/input.matrix}}])))))
{{/test_cases.saddlePoints}}
