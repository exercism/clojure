(ns roman-numerals-test
  (:require [clojure.test :refer [deftest testing is]]
            roman-numerals))

(deftest numerals_test_1
  (testing "1 is I"
    (is (= "I" (roman-numerals/numerals 1)))))

(deftest numerals_test_2
  (testing "2 is II"
    (is (= "II" (roman-numerals/numerals 2)))))

(deftest numerals_test_3
  (testing "3 is III"
    (is (= "III" (roman-numerals/numerals 3)))))

(deftest numerals_test_4
  (testing "4 is IV"
    (is (= "IV" (roman-numerals/numerals 4)))))

(deftest numerals_test_5
  (testing "5 is V"
    (is (= "V" (roman-numerals/numerals 5)))))

(deftest numerals_test_6
  (testing "6 is VI"
    (is (= "VI" (roman-numerals/numerals 6)))))

(deftest numerals_test_7
  (testing "9 is IX"
    (is (= "IX" (roman-numerals/numerals 9)))))

(deftest numerals_test_8
  (testing "16 is XVI"
    (is (= "XVI" (roman-numerals/numerals 16)))))

(deftest numerals_test_9
  (testing "27 is XXVII"
    (is (= "XXVII" (roman-numerals/numerals 27)))))

(deftest numerals_test_10
  (testing "48 is XLVIII"
    (is (= "XLVIII" (roman-numerals/numerals 48)))))

(deftest numerals_test_11
  (testing "49 is XLIX"
    (is (= "XLIX" (roman-numerals/numerals 49)))))

(deftest numerals_test_12
  (testing "59 is LIX"
    (is (= "LIX" (roman-numerals/numerals 59)))))

(deftest numerals_test_13
  (testing "66 is LXVI"
    (is (= "LXVI" (roman-numerals/numerals 66)))))

(deftest numerals_test_14
  (testing "93 is XCIII"
    (is (= "XCIII" (roman-numerals/numerals 93)))))

(deftest numerals_test_15
  (testing "141 is CXLI"
    (is (= "CXLI" (roman-numerals/numerals 141)))))

(deftest numerals_test_16
  (testing "163 is CLXIII"
    (is (= "CLXIII" (roman-numerals/numerals 163)))))

(deftest numerals_test_17
  (testing "166 is CLXVI"
    (is (= "CLXVI" (roman-numerals/numerals 166)))))

(deftest numerals_test_18
  (testing "402 is CDII"
    (is (= "CDII" (roman-numerals/numerals 402)))))

(deftest numerals_test_19
  (testing "575 is DLXXV"
    (is (= "DLXXV" (roman-numerals/numerals 575)))))

(deftest numerals_test_20
  (testing "666 is DCLXVI"
    (is (= "DCLXVI" (roman-numerals/numerals 666)))))

(deftest numerals_test_21
  (testing "911 is CMXI"
    (is (= "CMXI" (roman-numerals/numerals 911)))))

(deftest numerals_test_22
  (testing "1024 is MXXIV"
    (is (= "MXXIV" (roman-numerals/numerals 1024)))))

(deftest numerals_test_23
  (testing "1666 is MDCLXVI"
    (is (= "MDCLXVI" (roman-numerals/numerals 1666)))))

(deftest numerals_test_24
  (testing "3000 is MMM"
    (is (= "MMM" (roman-numerals/numerals 3000)))))

(deftest numerals_test_25
  (testing "3001 is MMMI"
    (is (= "MMMI" (roman-numerals/numerals 3001)))))

(deftest numerals_test_26
  (testing "3888 is MMMDCCCLXXXVIII"
    (is (= "MMMDCCCLXXXVIII" (roman-numerals/numerals 3888)))))

(deftest numerals_test_27
  (testing "3999 is MMMCMXCIX"
    (is (= "MMMCMXCIX" (roman-numerals/numerals 3999)))))
