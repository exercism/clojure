(ns robot-name.test (:require [clojure.test :refer :all]))
(load-file "robot.clj")

(def robbie (robot/robot))
(def clutz  (robot/robot))

(deftest name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot/robot-name robbie)))))

(deftest name-is-persistent
  (is (= (robot/robot-name robbie) (robot/robot-name robbie))))

(deftest different-robots-have-different-names
  (is (not (= (robot/robot-name clutz) (robot/robot-name robbie)))))

(def original-name (robot/robot-name robbie))
(robot/reset-name robbie)

(deftest new-name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot/robot-name robbie)))))

(deftest new-name-is-persistent
  (is (= (robot/robot-name robbie) (robot/robot-name robbie))))

(deftest new-name-is-different-than-old-name
  (is (not (= original-name (robot/robot-name robbie)))))

(run-tests)
