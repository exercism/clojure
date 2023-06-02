(ns robot-name-test
  (:require [clojure.test :refer [deftest is testing]]
            robot-name))

(deftest robot-name
  (let [a-robot (robot-name/robot)
        its-name (robot-name/robot-name a-robot)]
      (is (re-seq #"[A-Z]{2}\d{3}" its-name))))

(deftest name-matches-pattern
   (let [a-robot (robot-name/robot)
         its-name (robot-name/robot-name a-robot)]
     (is (= its-name (robot-name/robot-name a-robot)))))

(deftest different-robots-different-names
 (let [a-robot (robot-name/robot)
        its-name (robot-name/robot-name a-robot)]
      (is (not= its-name (-> (robot-name/robot) robot-name/robot-name)))))

(deftest new-name-matches
  (let [a-robot (robot-name/robot)
        its-original-name (robot-name/robot-name a-robot)
        its-new-name (do (robot-name/reset-name a-robot)
                         (robot-name/robot-name a-robot))]
      (is (re-seq #"[A-Z]{2}\d{3}" its-new-name))))

(deftest new-name-different
  (let [a-robot (robot-name/robot)
        its-original-name (robot-name/robot-name a-robot)
        its-new-name (do (robot-name/reset-name a-robot)
                         (robot-name/robot-name a-robot))]
      (is (not= its-original-name its-new-name))))

(deftest new-name-does-not-change-until-reset
  (let [a-robot (robot-name/robot)
        its-original-name (robot-name/robot-name a-robot)
        its-new-name (do (robot-name/reset-name a-robot)
                         (robot-name/robot-name a-robot))]
      (is (= its-new-name (robot-name/robot-name a-robot)))))

(deftest new-names-different-each-time
  (let [four-thousand-names (repeatedly 4000 #(robot-name/robot-name (robot-name/robot)))]
    (is (= 4000 (count (set four-thousand-names))))))
