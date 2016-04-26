(ns robot-name-test
  (:require [clojure.test :refer [deftest is]]
            robot-name))

(def robbie (robot-name/robot))

(def clutz  (robot-name/robot))

(deftest name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot-name/robot-name robbie)))))

(deftest name-is-persistent
  (is (= (robot-name/robot-name robbie) (robot-name/robot-name robbie))))

(deftest different-robots-have-different-names
  (let [robbie (robot-name/robot)
        clutz (robot-name/robot)]
    (is (not (= (robot-name/robot-name clutz) (robot-name/robot-name robbie))))))

(def original-name (robot-name/robot-name robbie))
(robot-name/reset-name robbie)

(deftest new-name-matches-expected-pattern
  (is (re-find (re-matcher #"[A-Z]{2}\d{3}" (robot-name/robot-name robbie)))))

(deftest new-name-is-persistent
  (is (= (robot-name/robot-name robbie) (robot-name/robot-name robbie))))

(deftest new-name-is-different-than-old-name
  (is (not (= original-name (robot-name/robot-name robbie)))))
