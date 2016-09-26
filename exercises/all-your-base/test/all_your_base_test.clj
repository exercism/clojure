(ns all-your-base-test
  (require [clojure.test :refer [deftest testing is]]
           [all-your-base]))

(deftest test-single-bit-to-one-decimal
  (testing "Base 2 '1' converts to base 10 '1'"
    (is (= '(1) (all-your-base/convert 2 '(1) 10)))))

(deftest test-binary-to-single-decimal
  (testing "Base 2 '1 0 1' converts to base 10 '5'"
    (is (= '(5) (all-your-base/convert 2 '(1 0 1) 10)))))

(deftest test-single-decimal-to-binary
  (testing "Base 10 '5' converts to base 2 '1 0 1'"
    (is (= '(1 0 1) (all-your-base/convert 10 '(5) 2)))))

(deftest test-binary-to-multiple-decimal
  (testing "Base 2 '1 0 1 0 1 0' converts to base 10 '4 2'"
    (is (= '(4 2) (all-your-base/convert 2 '(1 0 1 0 1 0) 10)))))

(deftest test-decimal-to-binary
  (testing "Base 10 '4 2' conves to base 2 '1 0 1 0 1 0'"
    (is (= '(1 0 1 0 1 0) (all-your-base/convert 10 '(4 2) 2)))))

(deftest test-trinary-to-hexadecimal
  (testing "Base 3 '1 1 2 0' converts to base 16 '2 10'"
    (is (= '(2 10) (all-your-base/convert 3 '(1 1 2 0) 16)))))

(deftest test-hexadecimal-to-trinary
  (testing "Base 16 '2 10' converts to base 3 '1 1 2 0'"
    (is (= '(1 1 2 0) (all-your-base/convert 16 '(2 10) 3)))))

(deftest test-15-bit-integer
  (testing "Base 97 '3 46 60' converts to base 73 '6 10 45'"
    (is (= '(6 10 45) (all-your-base/convert 97 '(3 46 60) 73)))))

(deftest test-empty-list
  (testing "Empty input digits returns empty sequence"
    (is (empty? (all-your-base/convert 2 () 10)))))

(deftest test-single-zero
  (testing "0 converts to 0, no matter the base"
    (is (= '(0) (all-your-base/convert 10 '(0) 2)))))

(deftest test-multiple-zeroes
  (testing "0 converts to 0, no matter the how many zeroes"
    (is (= '(0) (all-your-base/convert 10 '(0 0 0) 2)))))

(deftest test-leading-zeros
  (testing "Leading zeroes don't affect conversion"
    (is (= '(4 2) (all-your-base/convert 7 '(0 6 0) 10)))))

(deftest test-negative-digit
  (testing "Negative digits result in nil"
    (is (nil? (all-your-base/convert 2 '(1 -1 1 0 1 0) 10)))))

(deftest test-invalid-positive-digit
  (testing "Invalid digits return nil"
    (is (nil? (all-your-base/convert 2 '(1 2 1 0 1 0) 10)))))

(deftest test-first-base-is-one
  (testing "Input base of 1 returns nil"
    (is (nil? (all-your-base/convert 1 () 10)))))

(deftest test-second-base-is-one
  (testing "Output base of 1 returns nil"
    (is (nil? (all-your-base/convert 2 '(1 0 1 0 1 0) 1)))))

(deftest test-first-base-is-zero
  (testing "Input base of 0 returns nil"
    (is (nil? (all-your-base/convert 0 () 10)))))

(deftest test-second-base-is-zero
  (testing "Output base of 0 returns nil"
    (is (nil? (all-your-base/convert 10 '(7) 0)))))

(deftest test-first-base-is-negative
  (testing "Negative input base returns nil"
    (is (nil? (all-your-base/convert -2 '(1) 10)))))

(deftest test-second-base-is-negative
  (testing "Negative output base returns nil"
    (is (nil? (all-your-base/convert 2 '(1) -7)))))

(deftest test-both-bases-are-negative
  (testing "When both bases are negative, nil is returned"
    (is (nil? (all-your-base/convert -2 '(1) -7)))))
