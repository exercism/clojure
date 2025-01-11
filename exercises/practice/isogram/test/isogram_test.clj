(ns isogram-test
  (:require [clojure.test :refer [deftest testing is]]
            isogram))

(deftest isogram?_test_1
  (testing "empty string"
    (is (true? (isogram/isogram? "")))))

(deftest isogram?_test_2
  (testing "isogram with only lower case characters"
    (is (true? (isogram/isogram? "isogram")))))

(deftest isogram?_test_3
  (testing "word with one duplicated character"
    (is (false? (isogram/isogram? "eleven")))))

(deftest isogram?_test_4
  (testing "word with one duplicated character from the end of the alphabet"
    (is (false? (isogram/isogram? "zzyzx")))))

(deftest isogram?_test_5
  (testing "longest reported english isogram"
    (is (true? (isogram/isogram? "subdermatoglyphic")))))

(deftest isogram?_test_6
  (testing "word with duplicated character in mixed case"
    (is (false? (isogram/isogram? "Alphabet")))))

(deftest isogram?_test_7
  (testing "word with duplicated character in mixed case, lowercase first"
    (is (false? (isogram/isogram? "alphAbet")))))

(deftest isogram?_test_8
  (testing "hypothetical isogrammic word with hyphen"
    (is (true? (isogram/isogram? "thumbscrew-japingly")))))

(deftest isogram?_test_9
  (testing "hypothetical word with duplicated character following hyphen"
    (is (false? (isogram/isogram? "thumbscrew-jappingly")))))

(deftest isogram?_test_10
  (testing "isogram with duplicated hyphen"
    (is (true? (isogram/isogram? "six-year-old")))))

(deftest isogram?_test_11
  (testing "made-up name that is an isogram"
    (is (true? (isogram/isogram? "Emily Jung Schwartzkopf")))))

(deftest isogram?_test_12
  (testing "duplicated character in the middle"
    (is (false? (isogram/isogram? "accentor")))))

(deftest isogram?_test_13
  (testing "same first and last characters"
    (is (false? (isogram/isogram? "angola")))))

(deftest isogram?_test_14
  (testing "word with duplicated character and with two hyphens"
    (is (false? (isogram/isogram? "up-to-date")))))
