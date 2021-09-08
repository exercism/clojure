(ns log-levels-test
  (:require [clojure.test :refer [deftest testing is]]
            log-levels))

(deftest message-test
  (testing "Message test"
    (testing "Error"
      (is (= "Stack overflow" (log-levels/message "[ERROR]: Stack overflow"))))
    (testing "Warning"
      (is (= (log-levels/message "[WARNING]: Disk almost full") "Disk almost full")))
    (testing "Info"
      (is (= (log-levels/message "[INFO]: File moved") "File moved"))
      (testing "Trim whitespace"
        (is (= "Timezone not set" (log-levels/message "[WARNING]:   \tTimezone not set  \r\n")))))))

(deftest log-level-test
  (testing "Log levels"
    (testing "Error"
      (is (= "error" (log-levels/log-level "[ERROR]: Disk full"))))
    (testing "Warning"
      (is (= "warning" (log-levels/log-level "[WARNING]: Unsafe password"))))
    (testing "Info"
      (is (= "info" (log-levels/log-level "[INFO]: Timezone changed"))))))

(deftest reformat-test
  (testing "Reformat test"
    (testing "Error"
      (is (= "Segmentation fault (error)" (log-levels/reformat "[ERROR]: Segmentation fault"))))
    (testing "Warning"
      (is (= "Decreased performance (warning)" (log-levels/reformat "[WARNING]: Decreased performance"))))
    (testing "Info"
      (is (= "Disk defragmented (info)" (log-levels/reformat "[INFO]: Disk defragmented"))))
    (testing "Trim whitespace"
      (is (= "Corrupt disk (error)" (log-levels/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))))
