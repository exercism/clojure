(ns log-line-test
  (:require [clojure.test :refer [deftest testing is]]
            log-line))

(deftest message-test
  (testing "Message test"
    (testing "Error"
      (is (= "Stack overflow" (log-line/message "[ERROR]: Stack overflow"))))
    (testing "Warning"
      (is (= (log-line/message "[WARNING]: Disk almost full") "Disk almost full")))
    (testing "Info"
      (is (= (log-line/message "[INFO]: File moved") "File moved"))
      (testing "Trim whitespace"
        (is (= "Timezone not set" (log-line/message "[WARNING]:   \tTimezone not set  \r\n")))))))

(deftest log-level-test
  (testing "Log levels"
    (testing "Error"
      (is (= "error" (log-line/log-level "[ERROR]: Disk full"))))
    (testing "Warning"
      (is (= "warning" (log-line/log-level "[WARNING]: Unsafe password"))))
    (testing "Info"
      (is (= "info" (log-line/log-level "[INFO]: Timezone changed"))))))

(deftest reformat-test
  (testing "Reformat test"
    (testing "Error"
      (is (= "Segmentation fault (error)" (log-line/reformat "[ERROR]: Segmentation fault"))))
    (testing "Warning"
      (is (= "Decreased performance (warning)" (log-line/reformat "[WARNING]: Decreased performance"))))
    (testing "Info"
      (is (= "Disk defragmented (info)" (log-line/reformat "[INFO]: Disk defragmented"))))
    (testing "Trim whitespace"
      (is (= "Corrupt disk (error)" (log-line/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))))
