(ns exercism.log-line-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.log-line))

(deftest message-test
  (testing "Message test"
    (testing "Error"
      (is (= "Stack overflow" (exercism.log-line/message "[ERROR]: Stack overflow"))))
    (testing "Warning"
      (is (= (exercism.log-line/message "[WARNING]: Disk almost full") "Disk almost full")))
    (testing "Info"
      (is (= (exercism.log-line/message "[INFO]: File moved") "File moved"))
      (testing "Trim whitespace"
        (is (= "Timezone not set" (exercism.log-line/message "[WARNING]:   \tTimezone not set  \r\n")))))))

(deftest log-level-test
  (testing "Log levels"
    (testing "Error"
      (is (= "error" (exercism.log-line/log-level "[ERROR]: Disk full"))))
    (testing "Warning"
      (is (= "warning" (exercism.log-line/log-level "[WARNING]: Unsafe password"))))
    (testing "Info"
      (is (= "info" (exercism.log-line/log-level "[INFO]: Timezone changed"))))))

(deftest reformat-test
  (testing "Reformat test"
    (testing "Error"
      (is (= "Segmentation fault (error)" (exercism.log-line/reformat "[ERROR]: Segmentation fault"))))
    (testing "Warning"
      (is (= "Decreased performance (warning)" (exercism.log-line/reformat "[WARNING]: Decreased performance"))))
    (testing "Info"
      (is (= "Disk defragmented (info)" (exercism.log-line/reformat "[INFO]: Disk defragmented"))))
    (testing "Trim whitespace"
      (is (= "Corrupt disk (error)" (exercism.log-line/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))))
