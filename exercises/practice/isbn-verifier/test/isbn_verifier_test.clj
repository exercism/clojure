(ns isbn-verifier-test
  (:require [clojure.test :refer [deftest testing is]]
            isbn-verifier))

(deftest test-0caa3eac-d2e3-4c29-8df8-b188bc8c9292
  (testing "valid isbn"
    (is (true? (isbn-verifier/isbn? "3-598-21508-8")))))

(deftest test-19f76b53-7c24-45f8-87b8-4604d0ccd248
  (testing "invalid isbn check digit"
    (is (false? (isbn-verifier/isbn? "3-598-21508-9")))))

(deftest test-4164bfee-fb0a-4a1c-9f70-64c6a1903dcd
  (testing "valid isbn with a check digit of 10"
    (is (true? (isbn-verifier/isbn? "3-598-21507-X")))))

(deftest test-3ed50db1-8982-4423-a993-93174a20825c
  (testing "check digit is a character other than X"
    (is (false? (isbn-verifier/isbn? "3-598-21507-A")))))

(deftest test-9416f4a5-fe01-4b61-a07b-eb75892ef562
  (testing "invalid check digit in isbn is not treated as zero"
    (is (false? (isbn-verifier/isbn? "4-598-21507-B")))))

(deftest test-c19ba0c4-014f-4dc3-a63f-ff9aefc9b5ec
  (testing "invalid character in isbn is not treated as zero"
    (is (false? (isbn-verifier/isbn? "3-598-P1581-X")))))

(deftest test-28025280-2c39-4092-9719-f3234b89c627
  (testing "X is only valid as a check digit"
    (is (false? (isbn-verifier/isbn? "3-598-2X507-9")))))

(deftest test-f6294e61-7e79-46b3-977b-f48789a4945b
  (testing "valid isbn without separating dashes"
    (is (true? (isbn-verifier/isbn? "3598215088")))))

(deftest test-185ab99b-3a1b-45f3-aeec-b80d80b07f0b
  (testing "isbn without separating dashes and X as check digit"
    (is (true? (isbn-verifier/isbn? "359821507X")))))

(deftest test-7725a837-ec8e-4528-a92a-d981dd8cf3e2
  (testing "isbn without check digit and dashes"
    (is (false? (isbn-verifier/isbn? "359821507")))))

(deftest test-47e4dfba-9c20-46ed-9958-4d3190630bdf
  (testing "too long isbn and no dashes"
    (is (false? (isbn-verifier/isbn? "3598215078X")))))

(deftest test-737f4e91-cbba-4175-95bf-ae630b41fb60
  (testing "too short isbn"
    (is (false? (isbn-verifier/isbn? "00")))))

(deftest test-5458a128-a9b6-4ff8-8afb-674e74567cef
  (testing "isbn without check digit"
    (is (false? (isbn-verifier/isbn? "3-598-21507")))))

(deftest test-70b6ad83-d0a2-4ca7-a4d5-a9ab731800f7
  (testing "check digit of X should not be used for 0"
    (is (false? (isbn-verifier/isbn? "3-598-21515-X")))))

(deftest test-94610459-55ab-4c35-9b93-ff6ea1a8e562
  (testing "empty isbn"
    (is (false? (isbn-verifier/isbn? "")))))

(deftest test-7bff28d4-d770-48cc-80d6-b20b3a0fb46c
  (testing "input is 9 characters"
    (is (false? (isbn-verifier/isbn? "134456729")))))

(deftest test-ed6e8d1b-382c-4081-8326-8b772c581fec
  (testing "invalid characters are not ignored after checking length"
    (is (false? (isbn-verifier/isbn? "3132P34035")))))

(deftest test-daad3e58-ce00-4395-8a8e-e3eded1cdc86
  (testing "invalid characters are not ignored before checking length"
    (is (false? (isbn-verifier/isbn? "3598P215088")))))

(deftest test-fb5e48d8-7c03-4bfb-a088-b101df16fdc3
  (testing "input is too long but contains a valid isbn"
    (is (false? (isbn-verifier/isbn? "98245726788")))))
