(ns bank-account-test
  (:require
    [clojure.test :refer [deftest testing is use-fixtures]]
    [bank-account]))

(defn shutdown-agents-fixture [f]
  (f)
  (shutdown-agents))

(use-fixtures :once shutdown-agents-fixture)

(deftest initial-account-state
  (testing "Accounts are opened with a balance of 0"
    (is (= 0 (-> (bank-account/open-account)
                 (bank-account/get-balance))))))

(deftest increment-and-get-balance
  (testing "Adding money to the account works"
    (let [account (bank-account/open-account)]
      (is (= 0 (bank-account/get-balance account)))
      (bank-account/update-balance account 10)
      (is (= 10 (bank-account/get-balance account))))))

(deftest increment-decrement-and-get-balance
  (testing "Taking money out of the account works"
    (let [account (bank-account/open-account)]
      (is (= 0 (bank-account/get-balance account)))
      (bank-account/update-balance account 10)
      (is (= 10 (bank-account/get-balance account)))
      (bank-account/update-balance account -10)
      (is (= 0 (bank-account/get-balance account))))))

(deftest closed-accounts-are-nil
  (testing "Closing an account makes it nil"
    (let [account (bank-account/open-account)]
      (bank-account/close-account account)
      (is (nil? (bank-account/get-balance account))))))

(deftest check-concurrent-access
  (testing "The account can handle parallel access"
    (let [account (bank-account/open-account)
          add-10 #(bank-account/update-balance account 10)]
      (doall (pcalls add-10 add-10 add-10 add-10 add-10))
      (is (= 50 (bank-account/get-balance account))))))
