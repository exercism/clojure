(ns strings-test
  (:require [clojure.test :refer [deftest testing is]]
            strings))

(deftest message-test
  (testing "Message test"
    (testing "Error"
      (is (= "Stack overflow" (strings/message "[ERROR]: Stack overflow"))))
    (testing "Warning"
      (is (= (strings/message "[WARNING]: Disk almost full") "Disk almost full")))
    (testing "Info"
      (is (= (strings/message "[INFO]: File moved") "File moved"))
      (testing "Trim whitespace"
        (is (= "Timezone not set" (strings/message "[WARNING]:   \tTimezone not set  \r\n")))))))

(deftest log-level-test
  (testing "Log levels"
    (testing "Error"
      (is (= "error" (strings/log-level "[ERROR]: Disk full"))))
    (testing "Warning"
      (is (= "warning" (strings/log-level "[WARNING]: Unsafe password"))))
    (testing "Info"
      (is (= "info" (strings/log-level "[INFO]: Timezone changed"))))))

(deftest reformat-test
  (testing "Reformat test"
    (testing "Error"
      (is (= "Segmentation fault (error)" (strings/reformat "[ERROR]: Segmentation fault"))))
    (testing "Warning"
      (is (= "Decreased performance (warning)" (strings/reformat "[WARNING]: Decreased performance"))))
    (testing "Info"
      (is (= "Disk defragmented (info)" (strings/reformat "[INFO]: Disk defragmented"))))
    (testing "Trim whitespace"
      (is (= "Corrupt disk (error)" (strings/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))))
