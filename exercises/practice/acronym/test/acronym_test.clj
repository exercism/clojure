(ns acronym-test
  (:require [clojure.test :refer [deftest testing is]]
            acronym))

(deftest acronym_test_1
  (testing "basic"
    (is (= "PNG" (acronym/acronym "Portable Network Graphics")))))

(deftest acronym_test_2
  (testing "lowercase words"
    (is (= "ROR" (acronym/acronym "Ruby on Rails")))))

(deftest acronym_test_3
  (testing "punctuation"
    (is (= "FIFO" (acronym/acronym "First In, First Out")))))

(deftest acronym_test_4
  (testing "all caps word"
    (is (= "GIMP" (acronym/acronym "GNU Image Manipulation Program")))))

(deftest acronym_test_5
  (testing "punctuation without whitespace"
    (is (= "CMOS" (acronym/acronym "Complementary metal-oxide semiconductor")))))

(deftest acronym_test_6
  (testing "very long abbreviation"
    (is (= "ROTFLSHTMDCOALM" (acronym/acronym "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me")))))

(deftest acronym_test_7
  (testing "consecutive delimiters"
    (is (= "SIMUFTA" (acronym/acronym "Something - I made up from thin air")))))

(deftest acronym_test_8
  (testing "apostrophes"
    (is (= "HC" (acronym/acronym "Halley's Comet")))))

(deftest acronym_test_9
  (testing "underscore emphasis"
    (is (= "TRNT" (acronym/acronym "The Road _Not_ Taken")))))
