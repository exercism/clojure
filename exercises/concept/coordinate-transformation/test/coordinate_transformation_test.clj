(ns coordinate-transformation-test
  (:require [clojure.test :refer [deftest testing is function?]]
            coordinate-transformation))

(deftest translate2d-test
  (testing "should return a function"
    (is (true? (function? coordinate-transformation/translate2d))))
  (testing "should be predictable"
    (is (let [dx 3 dy -5
              translator (coordinate-transformation/translate2d dx dy)
              x1 0 y1 0
              expected [3 -5]]
          (= expected (translator x1 y1)))))
  (testing "should be reusable"
    (is (let [dx 3 dy -5
              translator (coordinate-transformation/translate2d dx dy)
              x1 0 y1 0
              x2 4 y2 5
              expected [3 -5]
              reusedExpected [7 0]]
          (= reusedExpected (translator x2 y2))))))
