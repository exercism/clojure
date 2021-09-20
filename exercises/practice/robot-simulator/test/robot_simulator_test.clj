(ns robot-simulator-test
  (:require [clojure.test :refer [deftest is]]
            robot-simulator))

(def robbie (robot-simulator/robot {:x -2 :y 1} :east))

(deftest can-get-vals-bearing
  (is (= :east (:bearing robbie))))

(deftest can-get-vals-coords
  (is (= {:x -2 :y 1} (:coordinates robbie))))

(deftest can-turn-right
  (is (= :north (robot-simulator/turn-right :west))))

(deftest can-turn-left
  (is (= :west  (robot-simulator/turn-left :north))))

(deftest can-simulate-bearing
  (is (= :west (:bearing (robot-simulator/simulate "RLAALAL" robbie)))))

(deftest can-simulate-coords
  (is (= {:x 0 :y 2}
         (:coordinates (robot-simulator/simulate "RLAALAL" robbie)))))

(deftest simulate-clutz-bearing
  (let [clutz (->> (robot-simulator/robot {:x 0 :y  0} :north)
                   (robot-simulator/simulate "LAAARALA"))]
    (is (= :west (:bearing clutz)))))

(deftest simulate-clutz-coords
  (let [clutz (->> (robot-simulator/robot {:x 0 :y  0} :north)
                   (robot-simulator/simulate "LAAARALA"))]
    (is (= {:x -4 :y 1} (:coordinates clutz)))))

(deftest simulate-sphero-bearing
  (let [sphero (->> (robot-simulator/robot {:x 2 :y -7} :east)
                    (robot-simulator/simulate "RRAAAAALA"))]
    (is (= :south (:bearing sphero)))))

(deftest simulate-sphero-coords
  (let [sphero (->> (robot-simulator/robot {:x 2 :y -7} :east)
                    (robot-simulator/simulate "RRAAAAALA"))]
    (is (= {:x -3 :y -8} (:coordinates sphero)))))

(deftest simulate-roomba-bearing
  (let [roomba (->> (robot-simulator/robot {:x 8 :y  4} :south)
                    (robot-simulator/simulate "LAAARRRALLLL"))]
    (is (= :north (:bearing roomba)))))

(deftest simulate-roomba-coords
  (let [roomba (->> (robot-simulator/robot {:x 8 :y  4} :south)
                    (robot-simulator/simulate "LAAARRRALLLL"))]
    (is (= {:x 11 :y 5} (:coordinates roomba)))))
