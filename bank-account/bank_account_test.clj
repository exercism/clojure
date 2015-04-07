(ns bank-account-test
  (:refer-clojure :exclude (replace))
  (:require [clojure.walk :refer (postwalk)]
            [clojure.string :refer (capitalize replace)]
            [clojure.test :refer :all]))

(load-file "bank_account.clj")

;; The BankAccount module should support four calls:
;;
;; open-account
;; Called at the start of each test. Returns a BankAccount.
;;
;; close-account account
;; Called at the end of each test.
;;
;; balance account
;; Get the balance of the bank account.
;;
;; update-balance account amount
;; Increment the balance of the bank account by the given amount.
;; The amount may be negative for a withdrawal.
;;
;; The initial balance of the bank account should be 0.

(defmacro bank-test
  "Helper for writing cleaner bank-tests"
  [testname & body]
  (let [label (capitalize (replace (name testname) "-" " "))
        add-label #(if (and (list? %) (= 'is (first %))) (concat % (list label)) %)
        with-labels (postwalk add-label body)]
    `(deftest ~testname
       (let [acc# (bank-account/open-account)
             ~'get-balance (partial bank-account/get-balance acc#)
             ~'update-balance (partial bank-account/update-balance acc#)]
         (do ~@with-labels)
         (bank-account/close-account acc#)))))

(bank-test initial-account-state
  (is (= 0 (get-balance))))

(bank-test increment-and-get-balance
  (is (= 0  (get-balance)))
  (is (= 10 (update-balance 10)))
  (is (= 10 (get-balance))))

(bank-test can-increment-and-decrement
  (is (= 0  (get-balance)))
  (is (= 10 (update-balance 10)))
  (is (= 0  (update-balance -10))))

(bank-test check-concurrent-access
  (let [add-10 #(update-balance 10)]
    (doall ;; We have to force evaluation on this lazy-list.
      (pcalls add-10 add-10 add-10)))
  (is (= 30 (get-balance))))

(run-tests)
(shutdown-agents) ;; for the pcalls above so the test exits
