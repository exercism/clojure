(ns robot-simulator-test
  (:require [clojure.test :refer [deftest testing is]]
            robot-simulator))

(deftest robot_test_1
  (testing "Create robot ▶ at origin facing north"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :north)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             molly)))))

(deftest robot_test_2
  (testing "Create robot ▶ at negative position facing south"
    (let [molly (robot-simulator/robot {:x -1 :y -1} :south)]
      (is (= {:bearing :south :coordinates {:x -1 :y -1}}
             molly)))))

(deftest simulate_test_1
  (testing "Rotating clockwise ▶ changes north to east"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :north)]
      (is (= {:bearing :east :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "R" molly))))))

(deftest simulate_test_2
  (testing "Rotating clockwise ▶ changes east to south"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :east)]
      (is (= {:bearing :south :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "R" molly))))))

(deftest simulate_test_3
  (testing "Rotating clockwise ▶ changes south to west"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :south)]
      (is (= {:bearing :west :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "R" molly))))))

(deftest simulate_test_4
  (testing "Rotating clockwise ▶ changes west to north"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :west)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "R" molly))))))

(deftest simulate_test_5
  (testing "Rotating counter-clockwise ▶ changes north to west"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :north)]
      (is (= {:bearing :west :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "L" molly))))))

(deftest simulate_test_6
  (testing "Rotating counter-clockwise ▶ changes west to south"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :west)]
      (is (= {:bearing :south :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "L" molly))))))

(deftest simulate_test_7
  (testing "Rotating counter-clockwise ▶ changes south to east"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :south)]
      (is (= {:bearing :east :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "L" molly))))))

(deftest simulate_test_8
  (testing "Rotating counter-clockwise ▶ changes east to north"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :east)]
      (is (= {:bearing :north :coordinates {:x 0 :y 0}}
             (robot-simulator/simulate "L" molly))))))

(deftest simulate_test_9
  (testing "Moving forward one ▶ facing north increments Y"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :north)]
      (is (= {:bearing :north :coordinates {:x 0 :y 1}}
             (robot-simulator/simulate "A" molly))))))

(deftest simulate_test_10
  (testing "Moving forward one ▶ facing south decrements Y"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :south)]
      (is (= {:bearing :south :coordinates {:x 0 :y -1}}
             (robot-simulator/simulate "A" molly))))))

(deftest simulate_test_11
  (testing "Moving forward one ▶ facing east increments X"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :east)]
      (is (= {:bearing :east :coordinates {:x 1 :y 0}}
             (robot-simulator/simulate "A" molly))))))

(deftest simulate_test_12
  (testing "Moving forward one ▶ facing west decrements X"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :west)]
      (is (= {:bearing :west :coordinates {:x -1 :y 0}}
             (robot-simulator/simulate "A" molly))))))

(deftest simulate_test_13
  (testing "Follow series of instructions ▶ moving east and north from README"
    (let [molly (robot-simulator/robot {:x 7 :y 3} :north)]
      (is (= {:bearing :west :coordinates {:x 9 :y 4}}
             (robot-simulator/simulate "RAALAL" molly))))))

(deftest simulate_test_14
  (testing "Follow series of instructions ▶ moving west and north"
    (let [molly (robot-simulator/robot {:x 0 :y 0} :north)]
      (is (= {:bearing :west :coordinates {:x -4 :y 1}}
             (robot-simulator/simulate "LAAARALA" molly))))))

(deftest simulate_test_15
  (testing "Follow series of instructions ▶ moving west and south"
    (let [molly (robot-simulator/robot {:x 2 :y -7} :east)]
      (is (= {:bearing :south :coordinates {:x -3 :y -8}}
             (robot-simulator/simulate "RRAAAAALA" molly))))))

(deftest simulate_test_16
  (testing "Follow series of instructions ▶ moving east and north"
    (let [molly (robot-simulator/robot {:x 8 :y 4} :south)]
      (is (= {:bearing :north :coordinates {:x 11 :y 5}}
             (robot-simulator/simulate "LAAARRRALLLL" molly))))))
