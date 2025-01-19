(ns zebra-puzzle-test
  (:require [clojure.test :refer [deftest testing is]]
            zebra-puzzle))

{{#test_cases.drinksWater}}
(deftest drinks-water_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (zebra-puzzle/drinks-water)))))
{{/test_cases.drinksWater}}

{{#test_cases.ownsZebra}}
(deftest owns-zebra_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (zebra-puzzle/owns-zebra)))))
{{/test_cases.ownsZebra}}
