(ns phone-number-test
  (:require [clojure.test :refer [deftest is]]
            phone-number))

(deftest cleans-number
  (is (= "2234567890" (phone-number/number "(223) 456-7890"))))

(deftest cleans-number-with-dots
  (is (= "5558675309" (phone-number/number "555.867.5309"))))

(deftest valid-when-11-digits-and-first-is-1
  (is (= "9876543210" (phone-number/number "19876543210"))))

(deftest invalid-when-area-code-starts-with-0
  (is (= "0000000000" (phone-number/number "0234567890"))))

(deftest invalid-when-area-code-starts-with-1
  (is (= "0000000000" (phone-number/number "1234567890"))))

(deftest invalid-when--code-starts-with-0
  (is (= "0000000000" (phone-number/number "0234567890"))))

(deftest invalid-when-exchange-code-starts-with-1
  (is (= "0000000000" (phone-number/number "2231567890"))))

(deftest invalid-when-exchange-code-starts-with-0
  (is (= "0000000000" (phone-number/number "2230567890"))))

(deftest invalid-when-area-code-starts-with-1
  (is (= "0000000000" (phone-number/number "1234567890"))))

(deftest invalid-when-11-digits
  (is (= "0000000000" (phone-number/number "22234567890"))))

(deftest invalid-when-9-digits
  (is (= "0000000000" (phone-number/number "123456789"))))

(deftest area-code
  (is (= "223" (phone-number/area-code "2234567890"))))

(deftest area-code-with-dots
  (is (= "555" (phone-number/area-code "555.867.5309"))))

(deftest area-code-with-parentheses
  (is (= "987" (phone-number/area-code "(987) 654-3210"))))

(deftest area-code-with-full-us-phone-number
  (is (= "223" (phone-number/area-code "12234567890"))))

(deftest pretty-print
  (is (= "(223) 456-7890" (phone-number/pretty-print "2234567890"))))

(deftest pretty-print-with-dots
  (is (= "(555) 867-5309" (phone-number/pretty-print "555.867.5309"))))

(deftest pretty-print-with-full-us-phone-number
  (is (= "(987) 654-3210" (phone-number/pretty-print "19876543210"))))
