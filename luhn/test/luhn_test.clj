(ns luhn-test
  (:require [clojure.test :refer [deftest is]]
            luhn))

(deftest checksum-works
  (is (= 2 (luhn/checksum 10)))
  (is (= 9 (luhn/checksum 90)))
  (is (= 1 (luhn/checksum 100)))
  (is (= 2 (luhn/checksum 1000)))
  (is (= 1 (luhn/checksum 10000000000000000)))
  (is (= 6 (luhn/checksum 1111)))
  (is (= 0 (luhn/checksum 8763)))
  (is (= 0 (luhn/checksum 2323200577663554))))

(deftest valid?-works
  (is (= true (luhn/valid? 18)))
  (is (= true (luhn/valid? 59)))
  (is (= false (luhn/valid? 63)))
  (is (= true (luhn/valid? 8763)))
  (is (= false (luhn/valid? 1111)))
  (is (= true (luhn/valid? 4242424242424242)))
  (is (= true (luhn/valid? 2323200577663554)))
  (is (= false (luhn/valid? 2323200577663555)))
  (is (= false (luhn/valid? 2223200577663554)))
  (is (= false (luhn/valid? 3323200577663554))))

(deftest add-check-digit-works
  (is (= 18 (luhn/add-check-digit 1)))
  (is (= 59 (luhn/add-check-digit 5)))
  (is (= 8763 (luhn/add-check-digit 876)))
  (is (= 4242424242424242 (luhn/add-check-digit 424242424242424)))
  (is (= 2323200577663554 (luhn/add-check-digit 232320057766355))))
