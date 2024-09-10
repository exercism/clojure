(ns raindrops-test
  (:require [clojure.test :refer [deftest is testing]]
            raindrops))

(deftest sound-for-1
  (testing "The sound for 1 is 1"
    (is (= "1" (raindrops/convert 1)))))

(deftest sound-for-3
  (testing "The sound for 3 is Pling"
    (is (= "Pling" (raindrops/convert 3)))))

(deftest sound-for-5
  (testing "The sound for 5 is Plang"
    (is (= "Plang" (raindrops/convert 5)))))

(deftest sound-for-7
  (testing "The sound for 7 is Plong"
    (is (= "Plong" (raindrops/convert 7)))))

(deftest sound-for-6
  (testing "The sound for 6 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 6)))))

(deftest sound-for-8
  (testing "2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base"
    (is (= "8" (raindrops/convert 8)))))

(deftest sound-for-9
  (testing "The sound for 9 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 9)))))

(deftest sound-for-10
  (testing "The sound for 10 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 10)))))

(deftest sound-for-14
  (testing "The sound for 14 is Plong as it has a factor of 7"
    (is (= "Plong" (raindrops/convert 14)))))

(deftest sound-for-15
  (testing "The sound for 15 is PlingPlang as it has factors 3 and 5"
    (is (= "PlingPlang" (raindrops/convert 15)))))

(deftest sound-for-21
  (testing "The sound for 21 is PlingPlong as it has factors 3 and 7"
    (is (= "PlingPlong" (raindrops/convert 21)))))

(deftest sound-for-25
  (testing "The sound for 25 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 25)))))

(deftest sound-for-27
  (testing "The sound for 27 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 27)))))

(deftest sound-for-35
  (testing "The sound for 35 is PlangPlong as it has factors 5 and 7"
    (is (= "PlangPlong" (raindrops/convert 35)))))

(deftest sound-for-49
  (testing "The sound for 49 is Plong as it has a factor 7"
    (is (= "Plong" (raindrops/convert 49)))))

(deftest sound-for-52
  (testing "The sound for 52 is 52"
    (is (= "52" (raindrops/convert 52)))))

(deftest sound-for-105
  (testing "The sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7"
    (is (= "PlingPlangPlong" (raindrops/convert 105)))))

(deftest sound-for-3125
  (testing "The sound for 3125 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 3125)))))
