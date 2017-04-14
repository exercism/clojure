(ns secret-handshake-test
  (:require [clojure.test :refer [deftest testing is]]
            secret-handshake))

(deftest wink
  (testing "a wink is returned for binary 1"
    (is (= ["wink"] (secret-handshake/commands 1)))))

(deftest double-blink
  (testing "a double blink is returned for a binary 10"
    (is (= ["double blink"] (secret-handshake/commands 2)))))

(deftest close-your-eyes
  (testing "a close your eyes is returned for a binary 100"
    (is (= ["close your eyes"] (secret-handshake/commands 4)))))

(deftest jump
  (testing "a jump is returned for a binary 1000"
    (is (= ["jump"] (secret-handshake/commands 8)))))

(deftest two-actions
  (testing "commands returns multiple actions"
    (is (= ["wink" "double blink"] (secret-handshake/commands 3)))))

(deftest reversing
  (testing "giving a binary 10000 reverses actions"
    (is (= ["double blink" "wink"] (secret-handshake/commands 19)))))

(deftest reversing-one-action
  (testing "reversing one action returns the same action"
    (is (= ["jump"] (secret-handshake/commands 24)))))

(deftest reverse-nothing
  (testing "reversing nothing still gives nothing"
    (is (= [] (secret-handshake/commands 16)))))

(deftest all-actions
  (testing "all actions together"
    (is (=
         ["wink" "double blink" "close your eyes" "jump"]
         (secret-handshake/commands 15)))))

(deftest reverse-all-actions
  (testing "reversing all actions together"
    (is (=
         ["jump" "close your eyes" "double blink" "wink"]
         (secret-handshake/commands 31)))))

(deftest nothing
  (testing "do nothing for 0"
    (is (= [] (secret-handshake/commands 0)))))

(deftest lower-5-bits-zero
  (testing "do nothing for high numbers if lower 5 bits not set"
    (is (= [] (secret-handshake/commands 32)))))
