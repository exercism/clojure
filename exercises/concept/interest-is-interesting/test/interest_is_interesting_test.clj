(ns interest-is-interesting-test
  (:require [clojure.test :refer [deftest is]]
            interest-is-interesting))

(deftest ^{:task 1} minimal-first-interest-rate-test
  (is (= 0.5 (interest-is-interesting/interest-rate 0M))))

(deftest ^{:task 1} tiny-first-interest-rate-test
  (is (= 0.5 (interest-is-interesting/interest-rate 0.000001M))))

(deftest ^{:task 1} maximum-first-interest-rate-test
  (is (= 0.5 (interest-is-interesting/interest-rate 999.9999M))))

(deftest ^{:task 1} minimal-second-interest-rate-test
  (is (= 1.621 (interest-is-interesting/interest-rate 1000.0M))))

(deftest ^{:task 1} tiny-second-interest-rate-test
  (is (= 1.621 (interest-is-interesting/interest-rate 1000.0001M))))

(deftest ^{:task 1} maximum-second-interest-rate-test
  (is (= 1.621 (interest-is-interesting/interest-rate 4999.9990M))))

(deftest ^{:task 1} minimal-third-interest-rate-test
  (is (= 2.475 (interest-is-interesting/interest-rate 5000.0000M))))

(deftest ^{:task 1} tiny-third-interest-rate-test
  (is (= 2.475 (interest-is-interesting/interest-rate 5000.0001M))))

(deftest ^{:task 1} large-third-interest-rate-test
  (is (= 2.475 (interest-is-interesting/interest-rate 5639998.742909M))))

(deftest ^{:task 1} minimal-negative-interest-rate-test
  (is (= -3.213 (interest-is-interesting/interest-rate -0.000001M))))

(deftest ^{:task 1} small-negative-interest-rate-test
  (is (= -3.213 (interest-is-interesting/interest-rate -0.123M))))

(deftest ^{:task 1} regular-negative-interest-rate-test
  (is (= -3.213 (interest-is-interesting/interest-rate -300.0M))))

(deftest ^{:task 1} large-negative-interest-rate-test
  (is (= -3.213 (interest-is-interesting/interest-rate -152964.231M))))

(deftest ^{:task 2} annual-balance-update-empty-balance-test
  (is (= 0.0000M (interest-is-interesting/annual-balance-update 0.0M))))

(deftest ^{:task 2} annual-balance-update-small-positive-balance-test
  (is (= 0.000001005M (interest-is-interesting/annual-balance-update 0.000001M))))

(deftest ^{:task 2} annual-balance-update-average-positive-balance-test
  (is (= 1016.210000M (interest-is-interesting/annual-balance-update 1000.0M))))

(deftest ^{:task 2} annual-balance-update-large-positive-balance-test
  (is (= 1016.210101621M (interest-is-interesting/annual-balance-update 1000.0001M))))

(deftest ^{:task 2} annual-balance-update-huge-positive-balance-test
  (is (= 920352587.26744292868451875M (interest-is-interesting/annual-balance-update 898124017.826243404425M))))

(deftest ^{:task 2} annual-balance-update-small-negative-balance-test
  (is (= -0.12695199M (interest-is-interesting/annual-balance-update -0.123M))))

(deftest ^{:task 2} annual-balance-update-large-negative-balance-test
  (is (= -157878.97174203M (interest-is-interesting/annual-balance-update -152964.231M))))

(deftest ^{:task 3} amount-to-donate-empty-balance-test
  (is (= 0 (interest-is-interesting/amount-to-donate 0.0M 2.0))))

(deftest ^{:task 3} amount-to-donate-small-positive-balance-test
  (is (= 0 (interest-is-interesting/amount-to-donate 0.000001M 2.1))))

(deftest ^{:task 3} amount-to-donate-average-positive-balance-test
  (is (= 40 (interest-is-interesting/amount-to-donate 1000.0M 2.0))))

(deftest ^{:task 3} amount-to-donate-large-positive-balance-test
  (is (= 19 (interest-is-interesting/amount-to-donate 1000.0001M 0.99))))

(deftest ^{:task 3} amount-to-donate-huge-positive-balance-test
  (is (= 47600572 (interest-is-interesting/amount-to-donate 898124017.826243404425M 2.65))))

(deftest ^{:task 3} amount-to-donate-small-negative-balance-test
  (is (= 0 (interest-is-interesting/amount-to-donate -0.123M 3.33))))

(deftest ^{:task 3} amount-to-donate-large-negative-balance-test
  (is (= 0 (interest-is-interesting/amount-to-donate -152964.231M 5.4))))
