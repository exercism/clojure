(ns annalyns-infiltration-test
  (:require [clojure.test :refer [deftest testing is]]
            annalyns-infiltration))

(deftest fast-attack-test
  (testing "Fast attack if knight is"
    (testing "awake"
      (is (= false (annalyns-infiltration/can-fast-attack? true))))
    (testing "sleeping"
      (is (= true (annalyns-infiltration/can-fast-attack? false))))))

(deftest spy-test
  (testing "Cannot spy if everyone is sleeping"
    (is (= false (annalyns-infiltration/can-spy? false false false))))
  (testing "Can spy if everyone but knight is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true false false))))
  (testing "Can spy if everyone but archer is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false true false))))
  (testing "Can spy if everyone but prisoner is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false false true))))
  (testing "Can spy if only knight is sleeping"
    (is (= true (annalyns-infiltration/can-spy? false true true))))
  (testing "Can spy if only archer is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true false true))))
  (testing "Can spy if only prisoner is sleeping"
    (is (= true (annalyns-infiltration/can-spy? true true false))))
  (testing "Can spy if everyone is awake"
    (is (= true (annalyns-infiltration/can-spy? true true true)))))

(deftest signal-prisoner-test
  (testing "Can signal prisoner if archer is sleeping and prisoner is awake"
    (is (= true (annalyns-infiltration/can-signal-prisoner? false true))))
  (testing "Cannot signal prisoner if"
    (testing "archer is awake and prisoner is sleeping"
      (is (= false (annalyns-infiltration/can-signal-prisoner? true false))))
    (testing "archer and prisoner are both sleeping"
      (is (= false (annalyns-infiltration/can-signal-prisoner? false false))))
    (testing "archer and prisoner are both awake"
      (is (= false (annalyns-infiltration/can-signal-prisoner? true true))))))

(deftest release-prisoner-test
  (testing "Cannot release prisoner if"
    (testing "everyone is awake and pet dog is present"
      (is (= false (annalyns-infiltration/can-free-prisoner? true true true true))))
    (testing "everyone is awake and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? true true true false))))
    (testing "everyone is asleep and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? false false false false))))
    (testing "only archer is awake and pet dog is present"
      (is (= false (annalyns-infiltration/can-free-prisoner? false true false true))))
    (testing "only archer is awake and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? false true false false))))
    (testing "only knight is awake and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? true false false false))))
    (testing "only knight is asleep and pet dog is present"
      (is (= false (annalyns-infiltration/can-free-prisoner? false true true true))))
    (testing "only knight is asleep and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? false true true false))))
    (testing "only archer is asleep and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? true false true false))))
    (testing "only prisoner is asleep and pet dog is present"
      (is (= false (annalyns-infiltration/can-free-prisoner? true true false true))))
    (testing "only prisoner is asleep and pet dog is absent"
      (is (= false (annalyns-infiltration/can-free-prisoner? true true false false)))))
  (testing "Can release prisoner if"
    (testing "everyone is asleep and pet dog is present"
      (is (= true (annalyns-infiltration/can-free-prisoner? false false false true))))
    (testing "only prisoner is awake and pet dog is present"
      (is (= true (annalyns-infiltration/can-free-prisoner? false false true true))))
    (testing "only prisoner is awake and pet dog is absent"
      (is (= true (annalyns-infiltration/can-free-prisoner? false false true false))))
    (testing "only knight is awake and pet dog is present"
      (is (= true (annalyns-infiltration/can-free-prisoner? true false false true))))
    (testing "only archer is asleep and pet dog is present"
      (is (= true (annalyns-infiltration/can-free-prisoner? true false true true))))))
