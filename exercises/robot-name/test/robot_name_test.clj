(ns robot-name-test
  (:require [clojure.test :refer [deftest is testing]]
            robot-name))

(deftest robot-name
  (let [a-robot (robot-name/robot)
        its-name (robot-name/robot-name a-robot)]
    (testing "robot-name"
      (is (re-seq #"[A-Z]{2}\d{3}" its-name)
          "name matches expected pattern")
      (is (= its-name (robot-name/robot-name a-robot))
          "name doesn't change until you reset it")
      (is (not= its-name (-> (robot-name/robot) robot-name/robot-name))
          "different robots have different names"))))

(deftest reset-name
  (let [a-robot (robot-name/robot)
        its-original-name (robot-name/robot-name a-robot)
        its-new-name (do (robot-name/reset-name a-robot)
                         (robot-name/robot-name a-robot))]

    (testing "reset-name"
      (is (re-seq #"[A-Z]{2}\d{3}" its-new-name)
          "new name matches expected pattern")
      (is (not= its-original-name its-new-name)
          "new name is different from old name")
      (is (= its-new-name (robot-name/robot-name a-robot))
          "new name doesn't change until you reset it")
      (is (not= its-new-name (do (robot-name/reset-name a-robot)
                                 (robot-name/robot-name a-robot)))
          "new names are different each time"))))
