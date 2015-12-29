(ns raindrops-test
  (:require [clojure.test :refer [deftest is]]
            raindrops))

(deftest one
  (is (= "1" (raindrops/convert 1))))

(deftest three
  (is (= "Pling" (raindrops/convert 3))))

(deftest five
  (is (= "Plang" (raindrops/convert 5))))

(deftest seven
  (is (= "Plong" (raindrops/convert 7))))

(deftest six
  (is (= "Pling" (raindrops/convert 6))))

(deftest nine
  (is (= "Pling" (raindrops/convert 9))))

(deftest ten
  (is (= "Plang" (raindrops/convert 10))))

(deftest fourteen
  (is (= "Plong" (raindrops/convert 14))))

(deftest fifteen
  (is (= "PlingPlang" (raindrops/convert 15))))

(deftest twenty-one
  (is (= "PlingPlong" (raindrops/convert 21))))

(deftest twenty-five
  (is (= "Plang" (raindrops/convert 25))))

(deftest thirty-five
  (is (= "PlangPlong" (raindrops/convert 35))))

(deftest forty-nine
  (is (= "Plong" (raindrops/convert 49))))

(deftest fifty-two
  (is (= "52" (raindrops/convert 52))))

(deftest one-hundred-five
  (is (= "PlingPlangPlong" (raindrops/convert 105))))

(deftest twelve-thousand-one-hundred-twenty-one
  (is (= "12121" (raindrops/convert 12121))))
