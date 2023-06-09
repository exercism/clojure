(ns squeaky-clean-test
  (:require [clojure.test :refer [deftest is]]
            squeaky-clean))

(deftest ^{:task 1} clean-single-letter
  (is (= "A" (squeaky-clean/clean "A"))))

(deftest ^{:task 1} clean-clean-string
  (is (= "àḃç" (squeaky-clean/clean "àḃç")))) 

(deftest ^{:task 1} clean-string-with-spaces
  (is (= "my___Id" (squeaky-clean/clean "my   Id"))))

(deftest ^{:task 1} clean-string-with-no-letters
  (is (= "" (squeaky-clean/clean "😀😀😀"))))

(deftest ^{:task 1} clean-empty-string
  (is (= "" (squeaky-clean/clean ""))))

(deftest ^{:task 2} clean-string-with-control-char
  (is (= "myCTRLId" (squeaky-clean/clean "my\u0000Id"))))

(deftest ^{:task 3} convert-kebab-to-camel-case
  (is (= "àḂç" (squeaky-clean/clean "à-ḃç"))))

(deftest ^{:task 4} omit-lower-case-greek-letters
  (is (= "MyΟFinder" (squeaky-clean/clean "MyΟβιεγτFinder"))))

(deftest ^{:task 3} combine-conversions
  (is (= "_AbcĐCTRL" (squeaky-clean/clean "9 -abcĐ😀ω\0"))))

(comment
  (clojure.test/run-tests)
  )