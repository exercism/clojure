(ns squeaky-clean-test
  (:require [clojure.test :refer [deftest is]]
            squeaky-clean))

(deftest ^{:task 1 :task-1 true} clean-single-letter
  (is (= "A" (squeaky-clean/clean "A"))))

(deftest ^{:task 1 :task-1 true} clean-clean-string
  (is (= "àḃç" (squeaky-clean/clean "àḃç"))))

(deftest ^{:task 1 :task-1 true} clean-string-with-spaces
  (is (= "my___Id" (squeaky-clean/clean "my   Id"))))

(deftest ^{:task 1 :task-1 true} clean-empty-string
  (is (= "" (squeaky-clean/clean ""))))

(deftest ^{:task 2 :task-2 true} clean-string-with-control-char
  (is (= "myCTRLId" (squeaky-clean/clean "my\u0080Id"))))

(deftest ^{:task 3 :task-3 true} convert-kebab-to-camel-case
  (is (= "àḂç" (squeaky-clean/clean "à-ḃç"))))

(deftest ^{:task 4 :task-4 true} clean-string-with-special-characters
  (is (= "MyFinder" (squeaky-clean/clean "My😀😀Finder😀"))))

(deftest ^{:task 4 :task-4 true} clean-string-with-numbers
  (is (= "MyFinder" (squeaky-clean/clean "1My2Finder3"))))

(deftest ^{:task 5 :task-5 true} omit-lower-case-greek-letters
  (is (= "MyΟFinder" (squeaky-clean/clean "MyΟβιεγτFinder"))))

(deftest ^{:task 5 :task-5 true} combine-conversions
  (is (= "_AbcĐCTRL" (squeaky-clean/clean "9 -abcĐ😀ω\0"))))
