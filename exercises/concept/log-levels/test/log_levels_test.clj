(ns log-levels-test
  (:require [clojure.test :refer [deftest is]]
            log-levels))

(deftest ^{:task 1} message-error-test
  (is (= "Stack overflow" (log-levels/message "[ERROR]: Stack overflow"))))

(deftest ^{:task 1} message-warning-test
  (is (= (log-levels/message "[WARNING]: Disk almost full") "Disk almost full")))

(deftest ^{:task 1} message-info-test
  (is (= (log-levels/message "[INFO]: File moved") "File moved")))

(deftest ^{:task 1} message-trim-whitespace-test
  (is (= "Timezone not set" (log-levels/message "[WARNING]:   \tTimezone not set  \r\n"))))

(deftest ^{:task 2} log-level-error-test
  (is (= "error" (log-levels/log-level "[ERROR]: Disk full"))))

(deftest ^{:task 2} log-level-warning-test
  (is (= "warning" (log-levels/log-level "[WARNING]: Unsafe password"))))

(deftest ^{:task 2} log-level-info-test
  (is (= "info" (log-levels/log-level "[INFO]: Timezone changed"))))

(deftest ^{:task 3} reformat-error-test
  (is (= "Segmentation fault (error)" (log-levels/reformat "[ERROR]: Segmentation fault"))))

(deftest ^{:task 3} reformat-warning-test
  (is (= "Decreased performance (warning)" (log-levels/reformat "[WARNING]: Decreased performance"))))

(deftest ^{:task 3} reformat-info-test
  (is (= "Disk defragmented (info)" (log-levels/reformat "[INFO]: Disk defragmented"))))

(deftest ^{:task 3} reformat-trim-whitespace-test
  (is (= "Corrupt disk (error)" (log-levels/reformat "[ERROR]: \t Corrupt disk\t \t \r\n"))))
