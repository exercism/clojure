(ns coordinate-transformation-test
  (:require [clojure.test :refer [deftest testing is function?]]
            [coordinate-transformation :refer [translate2d scale2d compose-transform]]))

(deftest translate2d-test
  (testing "should return a function"
    (is (true? (function? translate2d))))
  (testing "should be predictable"
    (is (let [dx 3 dy -5
              translator (translate2d dx dy)
              x1 0 y1 0
              expected [3 -5]]
          (= expected (translator x1 y1)))))
  (testing "should be reusable"
    (is (let [dx 3 dy -5
              translator (translate2d dx dy)
              x2 4 y2 5
              reusedExpected [7 0]]
          (= reusedExpected (translator x2 y2))))))

(deftest scale2d-test
  (testing "should return a function"
    (is (true? (function? scale2d))))
  (testing "should be predictable"
    (is (let [dx             4
              dy             2
              scaler         (scale2d dx dy)
              x1             1
              y1             1
              expected       [4 2]]
          (= expected (scaler x1 y1)))))
  (testing "should be reusable"
    (is (let [dx             4
              dy             2
              scaler         (scale2d dx dy)
              x2             -2
              y2             5
              reusedExpected [-8 10]]
          (= reusedExpected (scaler x2 y2))))))

(deftest compose-transform-test
 (testing "should return a function"
   (is (let [dx         -6
             dy         10
             translator (translate2d dx dy)
             sx         3
             sy         2
             scaler     (scale2d sx sy)]
         (true? (function? (compose-transform translate2d scale2d))))))
  (testing "should compose two translate functions"
   (is (let [dx         -6
             dy         10
             translator (translate2d dx dy)
             sx         3
             sy         2
             scaler     (scale2d sx sy)
             compose-translate (compose-transform translator translator)]
         (= [-12 20] (compose-translate 0 0)))))
         (testing
          "should compose two scale functions"
          (is (let [dx         -6
                    dy         10
                    translator (translate2d dx dy)
                    sx         3
                    sy         2
                    scaler     (scale2d sx sy)
                    compose-scale (compose-transform scaler scaler)]
                (= [9 4] (compose-scale 1 1)))))
         (testing "should compose in the correct order: g(f(x))"
          (is
            (let [dx         -6
                  dy         10
                  translator (translate2d dx dy)
                  sx         3
                  sy         2
                  scaler     (scale2d sx sy)
                  compose-scale (compose-transform scaler scaler)
                  composed (compose-transform scaler translator)]
              (= [-6 10] (composed 0 0)))))
         (testing "should compose in the opposite order: g(f(x))"
          (is (let [dx         -6
                    dy         10
                    translator (translate2d dx dy)
                    sx         3
                    sy         2
                    scaler     (scale2d sx sy)
                    compose-scale (compose-transform scaler scaler)
                    composed (compose-transform translator scaler)]
                (= [-18 20] (composed 0 0))))))
