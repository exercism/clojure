(ns exercism.savings-account-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.savings-account))

(deftest interest-rate-test
  (testing "Minimal first interest rate"
    (is (= 0.5 (exercism.savings-account/interest-rate 0M))))
  (testing "Tiny first interest rate"
    (is (= 0.5 (exercism.savings-account/interest-rate 0.000001M))))
  (testing "Maximum first interest rate"
    (is (= 0.5 (exercism.savings-account/interest-rate 999.9999M))))
  (testing "Minimal second interest rate"
    (is (= 1.621 (exercism.savings-account/interest-rate 1000.0M))))
  (testing "Tiny second interest rate"
    (is (= 1.621 (exercism.savings-account/interest-rate 1000.0001M))))
  (testing "Maximum second interest rate"
    (is (= 1.621 (exercism.savings-account/interest-rate 4999.9990M))))
  (testing "Minimal third interest rate"
    (is (= 2.475 (exercism.savings-account/interest-rate 5000.0000M))))
  (testing "Tiny third interest rate"
    (is (= 2.475 (exercism.savings-account/interest-rate 5000.0001M))))
  (testing "Large third interest rate"
    (is (= 2.475 (exercism.savings-account/interest-rate 5639998.742909M))))
  (testing "Minimal negative interest rate"
    (is (= -3.213 (exercism.savings-account/interest-rate -0.000001M))))
  (testing "Small negative interest rate"
    (is (= -3.213 (exercism.savings-account/interest-rate -0.123M))))
  (testing "Regular negative interest rate"
    (is (= -3.213 (exercism.savings-account/interest-rate -300.0M))))
  (testing "Large negative interest rate"
    (is (= -3.213 (exercism.savings-account/interest-rate -152964.231M)))))

(deftest annual-balance-update-test
  (testing "Empty balance"
    (is (= 0.0000M (exercism.savings-account/annual-balance-update 0.0M))))
  (testing "Small positive balance"
    (is (= 0.000001005M (exercism.savings-account/annual-balance-update 0.000001M))))
  (testing "Average positive balance"
    (is (= 1016.210000M (exercism.savings-account/annual-balance-update 1000.0M))))
  (testing "Large positive balance"
    (is (= 1016.2101016209999M (exercism.savings-account/annual-balance-update 1000.0001M))))
  (testing "Huge positive balance"
    (is (= 920352587.267443M (exercism.savings-account/annual-balance-update 898124017.826243404425M))))
  (testing "Small negative balance"
    (is (= -0.11904801M (exercism.savings-account/annual-balance-update -0.123M))))
  (testing "Large negative balance"
    (is (= -148049.49025797M (exercism.savings-account/annual-balance-update -152964.231M)))))

(deftest amount-to-donate-test
  (testing "Empty balance"
    (is (= 0 (exercism.savings-account/amount-to-donate 0.0M 2.0))))
  (testing "Small positive balance"
    (is (= 0 (exercism.savings-account/amount-to-donate 0.000001M 2.1))))
  (testing "Average positive balance"
    (is (= 40 (exercism.savings-account/amount-to-donate 1000.0M 2.0))))
  (testing "Large positive balance"
    (is (= 19 (exercism.savings-account/amount-to-donate 1000.0001M 0.99))))
  (testing "Huge positive balance"
    (is (= 47600572 (exercism.savings-account/amount-to-donate 898124017.826243404425M 2.65))))
  (testing "Small negative balance"
    (is (= 0 (exercism.savings-account/amount-to-donate -0.123M 3.33))))
  (testing "Large negative balance"
    (is (= 0 (exercism.savings-account/amount-to-donate -152964.231M 5.4))))
  )