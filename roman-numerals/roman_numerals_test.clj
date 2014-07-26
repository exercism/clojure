(ns roman-numerals.test (:require [clojure.test :refer :all]))
(load-file "roman_numerals.clj")

(deftest one
  (is (= "I" (roman_numerals/numerals 1))))

(deftest two
  (is (= "II" (roman_numerals/numerals 2))))

(deftest three
  (is (= "III" (roman_numerals/numerals 3))))

(deftest four
  (is (= "IV" (roman_numerals/numerals 4))))

(deftest five
  (is (= "V" (roman_numerals/numerals 5))))

(deftest six
  (is (= "VI" (roman_numerals/numerals 6))))

(deftest nine
  (is (= "IX" (roman_numerals/numerals 9))))

(deftest twenty-seven
  (is (= "XXVII" (roman_numerals/numerals 27))))

(deftest forty-eight
  (is (= "XLVIII" (roman_numerals/numerals 48))))

(deftest fifty-nine
  (is (= "LIX" (roman_numerals/numerals 59))))

(deftest ninety-three
  (is (= "XCIII" (roman_numerals/numerals 93))))

(deftest one-hundred-forty-one
  (is (= "CXLI" (roman_numerals/numerals 141))))

(deftest one-hundred-sixty-three
  (is (= "CLXIII" (roman_numerals/numerals 163))))

(deftest four-hundred-two
  (is (= "CDII" (roman_numerals/numerals 402))))

(deftest five-hundred-seventy-five
  (is (= "DLXXV" (roman_numerals/numerals 575))))

(deftest nine-hundred-eleven
  (is (= "CMXI" (roman_numerals/numerals 911))))

(deftest one-thousand-twenty-four
  (is (= "MXXIV" (roman_numerals/numerals 1024))))

(deftest three-thousand
  (is (= "MMM" (roman_numerals/numerals 3000))))

(run-tests)
