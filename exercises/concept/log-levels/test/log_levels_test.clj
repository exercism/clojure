(ns log-levels-test
  (:require [clojure.test :refer [deftest testing is]]
            log-levels))

(deftest message-error-test
  (is (= "Stack overflow" (log-levels/message "[ERROR]: Stack overflow"))))

(deftest message-warning-test
  (is (= (log-levels/message "[WARNING]: Disk almost full") "Disk almost full")))

(deftest message-info-test
  (is (= (log-levels/message "[INFO]: File moved") "File moved")))

(deftest message-trim-whitespace-test
  (is (= "Timezone not set" (log-levels/message "[WARNING]:   \tTimezone not set  \r\n"))))

(deftest log-level-error-test
  (is (= "error" (log-levels/log-level "[ERROR]: Disk full"))))

(deftest log-level-warning-test
  (is (= "warning" (log-levels/log-level "[WARNING]: Unsafe password"))))

(deftest log-level-info-test
  (is (= "info" (log-levels/log-level "[INFO]: Timezone changed"))))

(deftest reformat-error-test
  (is (= "Segmentation fault (error)" (log-levels/reformat "[ERROR]: Segmentation fault"))))

(deftest reformat-warning-test
  (is (= "Decreased performance (warning)" (log-levels/reformat "[WARNING]: Decreased performance"))))

(deftest reformat-info-test
  (is (= "Disk defragmented (info)" (log-levels/reformat "[INFO]: Disk defragmented"))))

(deftest reformat-trim-whitespace-test
  (is (= "Corrupt disk (error)" (log-levels/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))
