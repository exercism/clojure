(ns squeaky-clean-test
  (:require [clojure.test :refer [deftest testing is]]
            squeaky-clean))

(deftest clean-single-letter
  (is (= "A" (squeaky-clean/clean "A"))))

(deftest clean-clean-string
  (is (= "àḃç" (squeaky-clean/clean "àḃç"))))

(deftest clean-string-with-spaces
  (is (= "my___Id" (squeaky-clean/clean "my   Id"))))

(deftest clean-string-with-control-char
  (is (= "myCTRLId" (squeaky-clean/clean "my\u0000Id"))))

(deftest clean-string-with-no-letters
  (is (= "" (squeaky-clean/clean "😀😀😀"))))

(deftest clean-empty-string
  (is (= "" (squeaky-clean/clean ""))))

(deftest convert-kebab-to-camel-case
  (is (= "àḂç" (squeaky-clean/clean "à-ḃç"))))

(deftest omit-lower-case-greek-letters
  (is (= "MyΟFinder" (squeaky-clean/clean "MyΟβιεγτFinder"))))

(deftest combine-conversions
  (is (= "_AbcĐCTRL" (squeaky-clean/clean "9 -abcĐ😀ω\0"))))
