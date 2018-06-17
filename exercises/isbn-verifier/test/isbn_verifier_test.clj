(ns isbn-verifier-test
  (:require [clojure.test :refer [deftest is]]
            [isbn-verifier :refer [isbn?]]))

(deftest valid-isbn-number
  (is (= true (isbn? "3-598-21508-8"))))

(deftest invalid-isbn-check-digit
  (is (= false (isbn? "3-598-21508-9"))))

(deftest valid-isbn-number-with-a-check-digit-of-10
  (is (= true (isbn? "3-598-21507-X"))))

(deftest check-digit-is-a-character-other-than-X
  (is (= false (isbn? "3-598-21507-A"))))

(deftest invalid-character-in-isbn
  (is (= false (isbn? "3-598-2K507-0"))))

(deftest X-is-only-valid-as-a-check-digit
  (is (= false (isbn? "3-598-2X507-9"))))

(deftest valid-isbn-without-separating-dashes
  (is (= true (isbn? "3598215088"))))

(deftest isbn-without-separating-dashes-and-X-as-check-digit
  (is (= true (isbn? "359821507X"))))

(deftest isbn-without-check-digit-and-dashes
  (is (= false (isbn? "359821507"))))

(deftest too-long-isbn-and-no-dashes
  (is (= false (isbn? "3598215078X"))))

(deftest too-short-isbn
  (is (= false (isbn? "00"))))

(deftest isbn-without-check-digit
  (is (= false (isbn? "3-598-21507"))))

(deftest too-long-isbn
  (is (= false (isbn? "3-598-21507-XX"))))

(deftest check-digit-of-X-should-not-be-used-for-0
  (is (= false (isbn? "3-598-21515-X"))))
