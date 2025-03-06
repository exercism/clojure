(ns raindrops-test
  (:require [clojure.test :refer [deftest testing is]]
            raindrops))

(deftest convert_test_1
  (testing "the sound for 1 is 1"
    (is (= "1" (raindrops/convert 1)))))

(deftest convert_test_2
  (testing "the sound for 3 is Pling"
    (is (= "Pling" (raindrops/convert 3)))))

(deftest convert_test_3
  (testing "the sound for 5 is Plang"
    (is (= "Plang" (raindrops/convert 5)))))

(deftest convert_test_4
  (testing "the sound for 7 is Plong"
    (is (= "Plong" (raindrops/convert 7)))))

(deftest convert_test_5
  (testing "the sound for 6 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 6)))))

(deftest convert_test_6
  (testing "2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base"
    (is (= "8" (raindrops/convert 8)))))

(deftest convert_test_7
  (testing "the sound for 9 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 9)))))

(deftest convert_test_8
  (testing "the sound for 10 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 10)))))

(deftest convert_test_9
  (testing "the sound for 14 is Plong as it has a factor of 7"
    (is (= "Plong" (raindrops/convert 14)))))

(deftest convert_test_10
  (testing "the sound for 15 is PlingPlang as it has factors 3 and 5"
    (is (= "PlingPlang" (raindrops/convert 15)))))

(deftest convert_test_11
  (testing "the sound for 21 is PlingPlong as it has factors 3 and 7"
    (is (= "PlingPlong" (raindrops/convert 21)))))

(deftest convert_test_12
  (testing "the sound for 25 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 25)))))

(deftest convert_test_13
  (testing "the sound for 27 is Pling as it has a factor 3"
    (is (= "Pling" (raindrops/convert 27)))))

(deftest convert_test_14
  (testing "the sound for 35 is PlangPlong as it has factors 5 and 7"
    (is (= "PlangPlong" (raindrops/convert 35)))))

(deftest convert_test_15
  (testing "the sound for 49 is Plong as it has a factor 7"
    (is (= "Plong" (raindrops/convert 49)))))

(deftest convert_test_16
  (testing "the sound for 52 is 52"
    (is (= "52" (raindrops/convert 52)))))

(deftest convert_test_17
  (testing "the sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7"
    (is (= "PlingPlangPlong" (raindrops/convert 105)))))

(deftest convert_test_18
  (testing "the sound for 3125 is Plang as it has a factor 5"
    (is (= "Plang" (raindrops/convert 3125)))))
