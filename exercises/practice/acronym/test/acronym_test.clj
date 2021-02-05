(ns acronym-test
  (:require [clojure.test :refer [deftest is]]
            acronym))

(deftest test-acronym
  (is (= "" (acronym/acronym "")))
  (is (= "PNG" (acronym/acronym "Portable Network Graphics")))
  (is (= "ROR" (acronym/acronym "Ruby on Rails")))
  (is (= "HTML" (acronym/acronym "HyperText Markup Language")))
  (is (= "FIFO" (acronym/acronym "First In, First Out")))
  (is (= "PHP" (acronym/acronym "PHP: Hypertext Preprocessor")))
  (is (= "CMOS" (acronym/acronym "Complementary metal-oxide semiconductor"))))
