(ns isogram-test
  (:require [clojure.test :refer [deftest testing is]]
             isogram))

(deftest isogram_test_1
  (testing "empty string"
    (is (isogram/isogram? ""))))
    
(deftest isogram_test_2
  (testing "isogram with only lower case characters"
    (is (isogram/isogram? "isogram"))))
    
(deftest isogram_test_3
  (testing "word with one duplicated character"
    (is (not (isogram/isogram? "eleven")))))
    
(deftest isogram_test_4
  (testing "word with one duplicated character from the end of the alphabet"
    (is (not (isogram/isogram? "zzyzx")))))
    
(deftest isogram_test_5
  (testing "longest reported english isogram"
    (is (isogram/isogram? "subdermatoglyphic"))))
    
(deftest isogram_test_6
  (testing "word with duplicated character in mixed case"
    (is (not (isogram/isogram? "Alphabet")))))
    
(deftest isogram_test_7
  (testing "word with duplicated character in mixed case, lowercase first"
    (is (not (isogram/isogram? "alphAbet")))))
    
(deftest isogram_test_8
  (testing "hypothetical isogrammic word with hyphen"
    (is (isogram/isogram? "thumbscrew-japingly"))))
    
(deftest isogram_test_9
  (testing "hypothetical word with duplicated character following hyphen"
    (is (not (isogram/isogram? "thumbscrew-jappingly")))))
    
(deftest isogram_test_10
  (testing "isogram with duplicated hyphen"
    (is (isogram/isogram? "six-year-old"))))
    
(deftest isogram_test_11
  (testing "made-up name that is an isogram"
    (is (isogram/isogram? "Emily Jung Schwartzkopf"))))
    
(deftest isogram_test_12
  (testing "duplicated character in the middle"
    (is (not (isogram/isogram? "accentor")))))
    
(deftest isogram_test_13
  (testing "same first and last characters"
    (is (not (isogram/isogram? "angola")))))
    
(deftest isogram_test_14
  (testing "word with duplicated character and with two hyphens"
    (is (not (isogram/isogram? "up-to-date")))))
    

