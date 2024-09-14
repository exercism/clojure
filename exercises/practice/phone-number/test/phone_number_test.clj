(ns phone-number-test
  (:require [clojure.test :refer [deftest testing is]]
            [phone-number :as phone]))

(deftest cleans-number
  (testing "Cleans the number"
    (is (= "2234567890" (phone/number "(223) 456-7890")))))

(deftest cleans-number-with-dots
  (testing "Cleans numbers with dots"
    (is (= "2234567890" (phone/number "223.456.7890")))))

(deftest cleans-number-with-spaces
  (testing "Cleans numbers with multiple spaces"
    (is (= "2234567890" (phone/number "223 456   7890   ")))))

(deftest invalid-when-9-digits
  (testing "Invalid when 9 digits"
    (is (= "0000000000" (phone/number "123456789")))))

(deftest invalid-when-11-digits-and-first-is-not-1
  (testing "Invalid when 11 digits does not start with a 1"
    (is (= "0000000000" (phone/number "22234567890")))))

(deftest valid-when-11-digits-and-first-is-1
  (testing "Valid when 11 digits and starting with 1"
    (is (= "2234567890" (phone/number "12234567890")))))

(deftest valid-when-11-digits-and-first-is-1-and-punctuation
  (testing "Valid when 11 digits and starting with 1 even with punctuation"
    (is (= "2234567890" (phone/number "+1 (223) 456-7890")))))

(deftest invalid-when-more-than-11-digits
  (testing "Invalid when more than 11 digits"
    (is (= "0000000000" (phone/number "321234567890")))))

(deftest invalid-with-letters
  (testing "Invalid with letters"
    (is (= "0000000000" (phone/number "523-abc-7890")))))

(deftest invalid-with-punctuations
  (testing "Invalid with punctuations"
    (is (= "0000000000" (phone/number "523-@:!-7890")))))

(deftest invalid-if-area-code-starts-with-0
  (testing "Invalid if area code starts with 0"
    (is (= "0000000000" (phone/number "(023) 456-7890")))))

(deftest invalid-if-area-code-starts-with-1
  (testing "invalid if area code starts with 1"
    (is (= "0000000000" (phone/number "(123) 456-7890")))))

(deftest invalid-if-exchange-code-starts-with-0
  (testing "Invalid if exchange code starts with 0"
    (is (= "0000000000" (phone/number "(223) 056-7890")))))

(deftest invalid-if-exchange-code-starts-with-1
  (testing "Invalid if exchange code starts with 1"
    (is (= "0000000000" (phone/number "(223) 156-7890")))))

(deftest invalid-if-area-code-starts-with-0-on-valid-11-digit-number
  (testing "Invalid if area code starts with 0 on valid 11-digit number"
    (is (= "0000000000" (phone/number "1 (023) 456-7890")))))

(deftest invalid-if-area-code-starts-with-1-on-valid-11-digit-number
  (testing "Invalid if area code starts with 1 on valid 11-digit number"
    (is (= "0000000000" (phone/number "1 (123) 456-7890")))))

(deftest invalid-if-exchange-code-starts-with-0-on-valid-11-digit-number
  (testing "Invalid if exchange code starts with 0 on valid 11-digit number"
    (is (= "0000000000" (phone/number "1 (223) 056-7890")))))

(deftest invalid-if-exchange-code-starts-with-1-on-valid-11-digit-number
  (testing "Invalid if exchange code starts with 1 on valid 11-digit number"
    (is (= "0000000000" (phone/number "1 (223) 156-7890")))))
