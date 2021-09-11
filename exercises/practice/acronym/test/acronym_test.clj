(ns acronym-test
  (:require [clojure.test :refer [deftest is]]
            acronym))

(deftest test-acronym-empty-string
  (is (= "" (acronym/acronym ""))))

(deftest test-acronym-png
  (is (= "PNG" (acronym/acronym "Portable Network Graphics"))))

(deftest test-acronym-ror
  (is (= "ROR" (acronym/acronym "Ruby on Rails"))))

(deftest test-acronym-html
  (is (= "HTML" (acronym/acronym "HyperText Markup Language"))))

(deftest test-acronym-fifo
  (is (= "FIFO" (acronym/acronym "First In, First Out"))))

(deftest test-acronym-php
  (is (= "PHP" (acronym/acronym "PHP: Hypertext Preprocessor"))))

(deftest test-acronym-cmos
  (is (= "CMOS" (acronym/acronym "Complementary metal-oxide semiconductor"))))
