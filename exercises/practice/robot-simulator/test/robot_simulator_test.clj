(ns robot-simulator-test
  (:require [clojure.test :refer [deftest is testing]]
            [robot-simulator :refer [robot simulate]]))

;; Tests for create robot
(deftest create-robot-at-origin-facing-north
  (testing "Create robot at origin facing north"
    (let [molly (robot {:x 0 :y 0} :north)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             molly)))))

(deftest create-robot-at-negative-facing-south
  (testing "Create robot at negative position facing south"
    (let [molly (robot {:x -1 :y -1} :south)]
      (is (= {:bearing :south :coordinates {:x -1 :y -1}}
             molly)))))

;; Tests for rotate clockwise
(deftest rotate-clockwise-north-to-east
  (testing "Rotate clockwise -> Changes north to east"
    (let [molly (robot {:x 0 :y 0} :north)]
      (is (= {:bearing :east :coordinates {:x 0 :y 0}}
             (simulate "R" molly))))))

(deftest rotate-clockwise-east-to-south
  (testing "Rotate clockwise -> Changes east to south"
    (let [molly (robot {:x 0 :y 0} :east)]
      (is (= {:bearing :south :coordinates {:x 0 :y 0}}
             (simulate "R" molly))))))

(deftest rotate-clockwise-south-to-test
  (testing "Rotate clockwise -> Changes south to west"
    (let [molly (robot {:x 0 :y 0} :south)]
      (is (= {:bearing :west :coordinates {:x 0 :y 0}}
             (simulate "R" molly))))))

(deftest rotate-clockwise-west-to-north
  (testing "Rotate clockwise -> Changes west to north"
    (let [molly (robot {:x 0 :y 0} :west)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             (simulate "R" molly))))))

;; Tests for rotate counter-clockwise
(deftest rotate-counter-clockwise-north-to-west
  (testing "Rotate counter-clockwise -> Changes north to west"
    (let [molly (robot {:x 0 :y 0} :north)]
      (is (= {:bearing :west :coordinates {:x 0 :y 0}}
             (simulate "L" molly))))))

(deftest rotate-counter-clockwise-west-to-south
  (testing "Rotate counter-clockwise -> Changes west to south"
    (let [molly (robot {:x 0 :y 0} :west)]
      (is (= {:bearing :south :coordinates {:x 0 :y 0}}
             (simulate "L" molly))))))

(deftest rotate-counter-clockwise-south-to-east
  (testing "Rotate counter-clockwise -> Changes south to east"
    (let [molly (robot {:x 0 :y 0} :south)]
      (is (= {:bearing :east :coordinates {:x 0 :y 0}}
             (simulate "L" molly))))))

(deftest rotate-counter-clockwise-east-to-north
  (testing "Rotate counter-clockwise -> Changes east to north"
    (let [molly (robot {:x 0 :y 0} :east)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             (simulate "L" molly))))))

;; Tests for moving forward one
(deftest moving-forward-facing-north
  (testing "Moving forward one -> Facing north increments Y"
    (let [molly (robot {:x 0 :y 0} :north)]
      (is (= {:bearing :north :coordinates {:x 0 :y 1}}
             (simulate "A" molly))))))

(deftest moving-forward-facing-south
  (testing "Moving forward one -> Facing south decrements Y"
    (let [molly (robot {:x 0 :y 0} :south)]
      (is (= {:bearing :south :coordinates {:x 0 :y -1}}
             (simulate "A" molly))))))

(deftest moving-forward-facing-east
  (testing "Moving forward one -> Facing east increments X"
    (let [molly (robot {:x 0 :y 0} :east)]
      (is (= {:bearing :east :coordinates {:x 1 :y 0}}
             (simulate "A" molly))))))

(deftest moving-forward-facing-west
  (testing "Moving forward one -> Facing west decrements X"
    (let [molly (robot {:x 0 :y 0} :west)]
      (is (= {:bearing :west :coordinates {:x -1 :y 0}}
             (simulate "A" molly))))))

;; Tests for Follow series of instructions
(deftest moving-east-and-north-from-readme
  (testing "Follow series of instructions -> Moving east and north from README"
    (let [molly (robot {:x 7 :y 3} :north)]
      (is (= {:bearing :west :coordinates {:x 9 :y 4}}
             (simulate "RAALAL" molly))))))

(deftest moving-west-and-north
  (testing "Follow series of instructions -> Moving west and north"
    (let [molly (robot {:x 0 :y 0} :north)]
      (is (= {:bearing :west :coordinates {:x -4 :y 1}}
             (simulate "LAAARALA" molly))))))

(deftest moving-west-and-south
  (testing "Follow series of instructions -> Moving west and south"
    (let [molly (robot {:x 2 :y -7} :east)]
      (is (= {:bearing :south :coordinates {:x -3 :y -8}}
             (simulate "RRAAAAALA" molly))))))

(deftest moving-east-and-north
  (testing "Follow series of instructions -> Moving east and north"
    (let [molly (robot {:x 8 :y 4} :south)]
      (is (= {:bearing :north :coordinates {:x 11 :y 5}}
             (simulate "LAAARRRALLLL" molly))))))
