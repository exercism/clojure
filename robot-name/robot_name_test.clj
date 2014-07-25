(ns robot-name.test (:require [clojure.test :refer :all]))
(load-file "robot_name.clj")

(def robbie (robot_name/robot))
(def clutz  (robot_name/robot))

(deftest name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot_name/robot-name robbie)))))

(deftest name-is-persistent
  (is (= (robot_name/robot-name robbie) (robot_name/robot-name robbie))))

(deftest different-robots-have-different-names
  (is (not (= (robot_name/robot-name clutz) (robot_name/robot-name robbie)))))

(def original-name (robot_name/robot-name robbie))
(robot_name/reset-name robbie)

(deftest new-name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot_name/robot-name robbie)))))

(deftest new-name-is-persistent
  (is (= (robot_name/robot-name robbie) (robot_name/robot-name robbie))))

(deftest new-name-is-different-than-old-name
  (is (not (= original-name (robot_name/robot-name robbie)))))

(run-tests)
