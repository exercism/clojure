(ns exercism.squeaky-clean-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.squeaky-clean))

(deftest clean-single-letter
  (is (= "A" (exercism.squeaky-clean/clean "A"))))

(deftest clean-clean-string
  (is (= "àḃç" (exercism.squeaky-clean/clean "àḃç"))))

(deftest clean-string-with-spaces
  (is (= "my___Id" (exercism.squeaky-clean/clean "my   Id"))))

(deftest clean-string-with-control-char
  (is (= "myCTRLId" (exercism.squeaky-clean/clean "my\u0000Id"))))

(deftest clean-string-with-no-letters
  (is (= "" (exercism.squeaky-clean/clean "😀😀😀"))))

(deftest clean-empty-string
  (is (= "" (exercism.squeaky-clean/clean ""))))

(deftest convert-kebab-to-camel-case
  (is (= "àḂç" (exercism.squeaky-clean/clean "à-ḃç"))))

(deftest omit-lower-case-greek-letters
  (is (= "MyΟFinder" (exercism.squeaky-clean/clean "MyΟβιεγτFinder"))))

(deftest combine-conversions
  (is (= "_AbcĐCTRL" (exercism.squeaky-clean/clean "9 -abcĐ😀ω\0"))))
