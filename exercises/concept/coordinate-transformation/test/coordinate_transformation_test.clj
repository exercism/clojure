(ns coordinate-transformation-test
  (:require [clojure.test :refer [deftest testing is function?]]
            [coordinate-transformation :refer [translate2d scale2d compose-transform memoize-transform]]))

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
         (true? (function? (compose-transform translator scaler))))))
  (testing "should compose two translate functions"
   (is (let [dx         -6
             dy         10
             translator (translate2d dx dy)
             compose-translate (compose-transform translator translator)]
         (= [-12 20] (compose-translate 0 0)))))
         (testing
          "should compose two scale functions"
          (is (let [sx         3
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
                  composed (compose-transform scaler translator)]
              (= [-6 10] (composed 0 0)))))
         (testing "should compose in the opposite order: g(f(x))"
          (is (let [dx         -6
                    dy         10
                    translator (translate2d dx dy)
                    sx         3
                    sy         2
                    scaler     (scale2d sx sy)
                    composed (compose-transform translator scaler)]
                (= [-18 20] (composed 0 0))))))

(deftest memoize-transform-test
  (testing "should return a function"
    (is (function? (memoize-transform (translate2d 2 2)))))
  (testing "should return the same result if given the same input"
    (is (= [4 4] (let [memoized-translate (memoize-transform (translate2d 2 2))]
                   (memoized-translate 2 2))))
    (is (= [4 4] (let [memoized-translate (memoize-transform (translate2d 2 2))]
                   (memoized-translate 2 2)))))
  (testing "should return different results for different inputs"
    (is (= [3 4] (let [memoized-translate (memoize-transform (translate2d 1 2))]
                   (memoized-translate 2 2))))
    (is (= [7 8] (let [memoized-translate (memoize-transform (translate2d 1 2))]
                   (memoized-translate 6 6)))))
  (testing "should not call the memoized function if the input is the same"
    (let [fake-first (atom true)
          fake-transform (fn [_ _]
                           (if @fake-first
                             (do (reset! fake-first false)
                                 [1 1])
                             false))
          memoized-transform (memoize-transform fake-transform)]
      (is (= [1 1] (memoized-transform 5 5)))
      (is (= [1 1] (memoized-transform 5 5)))))
  (testing "should only remember the last result"
    (let [mock-fn (let [n (atom 0)]
                    (with-meta
                      (fn [x y]
                        (swap! n inc)
                        [(* x 2) (* y 2)])
                      {::call-count (fn [] @n)}))
          memoized-transform (memoize-transform mock-fn)]
      (is (= [2 2] (memoized-transform 1 1)))
      (is (= [4 4] (memoized-transform 2 2)))
      (is (= [2 2] (memoized-transform 1 1)))
      (is (= 3 ((::call-count (meta mock-fn))))))))
