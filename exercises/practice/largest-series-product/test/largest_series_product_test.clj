(ns largest-series-product-test
  (:require [clojure.test :refer [deftest testing is]]
            largest-series-product))

(deftest largest-product_test_1
  (testing "finds the largest product if span equals length"
    (is (= 18 (largest-series-product/largest-product 2 "29")))))

(deftest largest-product_test_2
  (testing "can find the largest product of 2 with numbers in order"
    (is (= 72 (largest-series-product/largest-product 2 "0123456789")))))

(deftest largest-product_test_3
  (testing "can find the largest product of 2"
    (is (= 48 (largest-series-product/largest-product 2 "576802143")))))

(deftest largest-product_test_4
  (testing "can find the largest product of 3 with numbers in order"
    (is (= 504 (largest-series-product/largest-product 3 "0123456789")))))

(deftest largest-product_test_5
  (testing "can find the largest product of 3"
    (is (= 270 (largest-series-product/largest-product 3 "1027839564")))))

(deftest largest-product_test_6
  (testing "can find the largest product of 5 with numbers in order"
    (is (= 15120 (largest-series-product/largest-product 5 "0123456789")))))

(deftest largest-product_test_7
  (testing "can get the largest product of a big number"
    (is (= 23520 (largest-series-product/largest-product 6 "73167176531330624919225119674426574742355349194934")))))

(deftest largest-product_test_8
  (testing "reports zero if the only digits are zero"
    (is (= 0 (largest-series-product/largest-product 2 "0000")))))

(deftest largest-product_test_9
  (testing "reports zero if all spans include zero"
    (is (= 0 (largest-series-product/largest-product 3 "99099")))))

(deftest largest-product_test_10
  (testing "rejects span longer than string length"
    (is (thrown-with-msg? IllegalArgumentException #"^span must not exceed string length$" (largest-series-product/largest-product 4 "123")))))

(deftest largest-product_test_11
  (testing "rejects empty string and nonzero span"
    (is (thrown-with-msg? IllegalArgumentException #"^span must not exceed string length$" (largest-series-product/largest-product 1 "")))))

(deftest largest-product_test_12
  (testing "rejects invalid character in digits"
    (is (thrown-with-msg? IllegalArgumentException #"^digits input must only contain digits$" (largest-series-product/largest-product 2 "1234a5")))))

(deftest largest-product_test_13
  (testing "rejects negative span"
    (is (thrown-with-msg? IllegalArgumentException #"^span must not be negative$" (largest-series-product/largest-product -1 "12345")))))
