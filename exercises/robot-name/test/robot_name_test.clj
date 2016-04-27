(ns robot-name-test
  (:require [clojure.test :refer [deftest is testing]]
            robot-name))

(def ^:private robbie (robot-name/robot))
(def ^:private clutz  (robot-name/robot))

(deftest robot-name
  (testing "robot-name"
    (is (re-seq #"[A-Z]{2}\d{3}" (robot-name/robot-name robbie))
        "name matches expected pattern")
    (is (= (robot-name/robot-name robbie) (robot-name/robot-name robbie))
        "name is persistent")
    (is (not= (robot-name/robot-name clutz) (robot-name/robot-name robbie))
        "different robots have different names")))

(deftest reset-name
  (testing "reset-name"
    (let [original-name (robot-name/robot-name robbie)]
      (robot-name/reset-name robbie)
      (is (re-seq #"[A-Z]{2}\d{3}" (robot-name/robot-name robbie))
          "new name matches expected pattern")
      (is (= (robot-name/robot-name robbie) (robot-name/robot-name robbie))
          "new name is persistent")
      (is (not= original-name (robot-name/robot-name robbie))
          "new name is different from old name"))))
