(ns isbn-verifier-test
  (:require [clojure.test :refer [deftest testing is]]
            isbn-verifier))

(deftest isbn?_test_1
  (testing "valid isbn"
    (is (true? (isbn-verifier/isbn? "3-598-21508-8")))))

(deftest isbn?_test_2
  (testing "invalid isbn check digit"
    (is (false? (isbn-verifier/isbn? "3-598-21508-9")))))

(deftest isbn?_test_3
  (testing "valid isbn with a check digit of 10"
    (is (true? (isbn-verifier/isbn? "3-598-21507-X")))))

(deftest isbn?_test_4
  (testing "check digit is a character other than X"
    (is (false? (isbn-verifier/isbn? "3-598-21507-A")))))

(deftest isbn?_test_5
  (testing "invalid check digit in isbn is not treated as zero"
    (is (false? (isbn-verifier/isbn? "4-598-21507-B")))))

(deftest isbn?_test_6
  (testing "invalid character in isbn is not treated as zero"
    (is (false? (isbn-verifier/isbn? "3-598-P1581-X")))))

(deftest isbn?_test_7
  (testing "X is only valid as a check digit"
    (is (false? (isbn-verifier/isbn? "3-598-2X507-9")))))

(deftest isbn?_test_8
  (testing "X is not substituted by the value 10"
    (is (false? (isbn-verifier/isbn? "3-598-2X507-5")))))

(deftest isbn?_test_9
  (testing "valid isbn without separating dashes"
    (is (true? (isbn-verifier/isbn? "3598215088")))))

(deftest isbn?_test_10
  (testing "isbn without separating dashes and X as check digit"
    (is (true? (isbn-verifier/isbn? "359821507X")))))

(deftest isbn?_test_11
  (testing "isbn without check digit and dashes"
    (is (false? (isbn-verifier/isbn? "359821507")))))

(deftest isbn?_test_12
  (testing "too long isbn and no dashes"
    (is (false? (isbn-verifier/isbn? "3598215078X")))))

(deftest isbn?_test_13
  (testing "too short isbn"
    (is (false? (isbn-verifier/isbn? "00")))))

(deftest isbn?_test_14
  (testing "isbn without check digit"
    (is (false? (isbn-verifier/isbn? "3-598-21507")))))

(deftest isbn?_test_15
  (testing "check digit of X should not be used for 0"
    (is (false? (isbn-verifier/isbn? "3-598-21515-X")))))

(deftest isbn?_test_16
  (testing "empty isbn"
    (is (false? (isbn-verifier/isbn? "")))))

(deftest isbn?_test_17
  (testing "input is 9 characters"
    (is (false? (isbn-verifier/isbn? "134456729")))))

(deftest isbn?_test_18
  (testing "invalid characters are not ignored after checking length"
    (is (false? (isbn-verifier/isbn? "3132P34035")))))

(deftest isbn?_test_19
  (testing "invalid characters are not ignored before checking length"
    (is (false? (isbn-verifier/isbn? "3598P215088")))))

(deftest isbn?_test_20
  (testing "input is too long but contains a valid isbn"
    (is (false? (isbn-verifier/isbn? "98245726788")))))
