(ns phone-number-test
  (:require [clojure.test :refer [deftest is]]
            phone-number))

(deftest cleans-number
  (is (= "1234567890" (phone-number/number "(123) 456-7890"))))

(deftest cleans-number-with-dots
  (is (= "5558675309" (phone-number/number "555.867.5309"))))

(deftest valid-when-11-digits-and-first-is-1
  (is (= "9876543210" (phone-number/number "19876543210"))))

(deftest invalid-when-11-digits
  (is (= "0000000000" (phone-number/number "21234567890"))))

(deftest invalid-when-9-digits
  (is (= "0000000000" (phone-number/number "123456789"))))

(deftest area-code
  (is (= "123" (phone-number/area-code "1234567890"))))

(deftest area-code-with-dots
  (is (= "555" (phone-number/area-code "555.867.5309"))))

(deftest area-code-with-parentheses
  (is (= "987" (phone-number/area-code "(987) 654-3210"))))

(deftest area-code-with-full-us-phone-number
  (is (= "123" (phone-number/area-code "11234567890"))))

(deftest pretty-print
  (is (= "(123) 456-7890" (phone-number/pretty-print "1234567890"))))

(deftest pretty-print-with-dots
  (is (= "(555) 867-5309" (phone-number/pretty-print "555.867.5309"))))

(deftest pretty-print-with-full-us-phone-number
  (is (= "(987) 654-3210" (phone-number/pretty-print "19876543210"))))
