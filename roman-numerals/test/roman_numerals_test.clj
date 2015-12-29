(ns roman-numerals-test
  (:require [clojure.test :refer [deftest is]]
            roman-numerals))

(deftest one
  (is (= "I" (roman-numerals/numerals 1))))

(deftest two
  (is (= "II" (roman-numerals/numerals 2))))

(deftest three
  (is (= "III" (roman-numerals/numerals 3))))

(deftest four
  (is (= "IV" (roman-numerals/numerals 4))))

(deftest five
  (is (= "V" (roman-numerals/numerals 5))))

(deftest six
  (is (= "VI" (roman-numerals/numerals 6))))

(deftest nine
  (is (= "IX" (roman-numerals/numerals 9))))

(deftest twenty-seven
  (is (= "XXVII" (roman-numerals/numerals 27))))

(deftest forty-eight
  (is (= "XLVIII" (roman-numerals/numerals 48))))

(deftest fifty-nine
  (is (= "LIX" (roman-numerals/numerals 59))))

(deftest ninety-three
  (is (= "XCIII" (roman-numerals/numerals 93))))

(deftest one-hundred-forty-one
  (is (= "CXLI" (roman-numerals/numerals 141))))

(deftest one-hundred-sixty-three
  (is (= "CLXIII" (roman-numerals/numerals 163))))

(deftest four-hundred-two
  (is (= "CDII" (roman-numerals/numerals 402))))

(deftest five-hundred-seventy-five
  (is (= "DLXXV" (roman-numerals/numerals 575))))

(deftest nine-hundred-eleven
  (is (= "CMXI" (roman-numerals/numerals 911))))

(deftest one-thousand-twenty-four
  (is (= "MXXIV" (roman-numerals/numerals 1024))))

(deftest three-thousand
  (is (= "MMM" (roman-numerals/numerals 3000))))
