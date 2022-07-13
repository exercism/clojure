(ns annalyns-infiltration-test
  (:require annalyns-infiltration
            [clojure.test :refer [deftest is testing]]))

(deftest ^{:task 1} fast-attack-awake-test
  (testing "Fast attack if knight is awake"
    (is (= false (annalyns-infiltration/can-fast-attack? true)))))

(deftest ^{:task 1} fast-attack-asleep-test
  (testing "Fast attack if knight is sleeping"
    (is (= true (annalyns-infiltration/can-fast-attack? false)))))

(deftest ^{:task 2} spy-everyone-sleeping-test
  (testing "Cannot spy if everyone is sleeping"
    (is (= false (annalyns-infiltration/can-spy? false false false)))))

(deftest ^{:task 2} spy-but-knight-sleeping-test
  (testing "Can spy if everyone but knight is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true false false)))))

(deftest ^{:task 2} spy-but-archer-sleeping-test
  (testing "Can spy if everyone but archer is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false true false)))))

(deftest ^{:task 2} spy-but-prisoner-sleeping-test
  (testing "Can spy if everyone but prisoner is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false false true)))))

(deftest ^{:task 2} spy-only-knight-sleeping-test
  (testing "Can spy if only knight is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false true true)))))

(deftest ^{:task 2} spy-only-archer-sleeping-test
  (testing "Can spy if only archer is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true false true)))))

(deftest ^{:task 2} spy-only-prisoner-sleeping-test
  (testing "Can spy if only prisoner is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true true false)))))

(deftest ^{:task 2} spy-everyone-awake-test
  (testing "Can spy if everyone is awake"
    (is (= true (annalyns-infiltration/can-spy? true true true)))))

(deftest ^{:task 3} signal-prisoner-archer-sleeping-prisoner-awake-test
  (testing "Can signal prisoner if archer is sleeping and prisoner is awake"
    (is (= true (annalyns-infiltration/can-signal-prisoner? false true)))))

(deftest ^{:task 3} signal-prisoner-archer-awake-prisoner-sleeping-test
  (testing "Cannot signal prisoner if archer is awake and prisoner is sleeping"
    (is (= false (annalyns-infiltration/can-signal-prisoner? true false)))))

(deftest ^{:task 3} signal-prisoner-both-sleeping-test
  (testing "Cannot signal prisoner if archer and prisoner are both sleeping"
    (is (= false (annalyns-infiltration/can-signal-prisoner? false false)))))

(deftest ^{:task 3} signal-prisoner-both-awake-test
  (testing "Cannot signal prisoner if archer and prisoner are both awake"
    (is (= false (annalyns-infiltration/can-signal-prisoner? true true)))))

(deftest ^{:task 4} release-prisoner-everyone-awake-dog-present-test
  (testing "Cannot release prisoner if everyone is awake and pet dog is present"
    (is (= false (annalyns-infiltration/can-free-prisoner? true true true true)))))

(deftest ^{:task 4} release-prisoner-everyone-awake-dog-absent-test
  (testing "Cannot release prisoner if everyone is awake and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? true true true false)))))

(deftest ^{:task 4} release-prisoner-everyone-asleep-dog-absent-test
  (testing "Cannot release prisoner if everyone is asleep and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? false false false false)))))

(deftest ^{:task 4} release-prisoner-archer-awake-dog-present-test
  (testing "Cannot release prisoner if only archer is awake and pet dog is present"
    (is (= false (annalyns-infiltration/can-free-prisoner? false true false true)))))

(deftest ^{:task 4} release-prisoner-archer-awake-dog-absent-test
  (testing "Cannot release prisoner if only archer is awake and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? false true false false)))))

(deftest ^{:task 4} release-prisoner-knight-awake-dog-absent-test
  (testing "Cannot release prisoner if only knight is awake and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? true false false false)))))

(deftest ^{:task 4} release-prisoner-knight-awake-dog-present-test
  (testing "Cannot release prisoner if only knight is asleep and pet dog is present"
    (is (= false (annalyns-infiltration/can-free-prisoner? false true true true)))))

(deftest ^{:task 4} release-prisoner-knight-asleep-dog-absent-test
  (testing "Cannot release prisoner if only knight is asleep and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? false true true false)))))

(deftest ^{:task 4} release-prisoner-archer-asleep-dog-absent-test
  (testing "Cannot release prisoner if only archer is asleep and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? true false true false)))))

(deftest ^{:task 4} release-prisoner-prisoner-asleep-dog-present-test
  (testing "Cannot release prisoner if only prisoner is asleep and pet dog is present"
    (is (= false (annalyns-infiltration/can-free-prisoner? true true false true)))))

(deftest ^{:task 4} release-prisoner-prisoner-asleep-dog-absent-test
  (testing "Cannot release prisoner if only prisoner is asleep and pet dog is absent"
    (is (= false (annalyns-infiltration/can-free-prisoner? true true false false)))))

(deftest ^{:task 4} release-prisoner-everyone-asleep-dog-present-test
  (testing "Can release prisoner if everyone is asleep and pet dog is present"
    (is (= true (annalyns-infiltration/can-free-prisoner? false false false true)))))

(deftest ^{:task 4} release-prisoner-prisoner-awake-dog-present-test
  (testing "Can release prisoner if only prisoner is awake and pet dog is present"
    (is (= true (annalyns-infiltration/can-free-prisoner? false false true true)))))

(deftest ^{:task 4} release-prisoner-prisoner-awake-dog-absent-test
  (testing "Can release prisoner if only prisoner is awake and pet dog is absent"
    (is (= true (annalyns-infiltration/can-free-prisoner? false false true false)))))

(deftest ^{:task 4} release-prisoner-knight-awake-dog-present-test
  (testing "Can release prisoner if only knight is awake and pet dog is present"
    (is (= true (annalyns-infiltration/can-free-prisoner? true false false true)))))

(deftest ^{:task 4} release-prisoner-archer-asleep-dog-present-test
  (testing "Can release prisoner if only archer is asleep and pet dog is present"
    (is (= true (annalyns-infiltration/can-free-prisoner? true false true true)))))
