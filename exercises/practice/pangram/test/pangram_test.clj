(ns pangram-test
  (:require [clojure.test :refer [deftest testing is]]
            pangram))

(deftest test-64f61791-508e-4f5c-83ab-05de042b0149
  (testing "Empty sentence"
    (is (false? (pangram/pangram? "")))))

(deftest test-74858f80-4a4d-478b-8a5e-c6477e4e4e84
  (testing "Perfect lower case"
    (is (true? (pangram/pangram? "abcdefghijklmnopqrstuvwxyz")))))

(deftest test-61288860-35ca-4abe-ba08-f5df76ecbdcd
  (testing "Only lower case"
    (is (true? (pangram/pangram? "the quick brown fox jumps over the lazy dog")))))

(deftest test-6564267d-8ac5-4d29-baf2-e7d2e304a743
  (testing "Missing the letter 'x'"
    (is (false? (pangram/pangram? "a quick movement of the enemy will jeopardize five gunboats")))))

(deftest test-c79af1be-d715-4cdb-a5f2-b2fa3e7e0de0
  (testing "Missing the letter 'h'"
    (is (false? (pangram/pangram? "five boxing wizards jump quickly at it")))))

(deftest test-d835ec38-bc8f-48e4-9e36-eb232427b1df
  (testing "With underscores"
    (is (true? (pangram/pangram? "the_quick_brown_fox_jumps_over_the_lazy_dog")))))

(deftest test-8cc1e080-a178-4494-b4b3-06982c9be2a8
  (testing "With numbers"
    (is (true? (pangram/pangram? "the 1 quick brown fox jumps over the 2 lazy dogs")))))

(deftest test-bed96b1c-ff95-45b8-9731-fdbdcb6ede9a
  (testing "Missing letters replaced by numbers"
    (is (false? (pangram/pangram? "7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog")))))

(deftest test-938bd5d8-ade5-40e2-a2d9-55a338a01030
  (testing "Mixed case and punctuation"
    (is (true? (pangram/pangram? "\"Five quacking Zephyrs jolt my wax bed.\"")))))

(deftest test-7138e389-83e4-4c6e-8413-1e40a0076951
  (testing "a-m and A-M are 26 different characters but not a pangram"
    (is (false? (pangram/pangram? "abcdefghijklm ABCDEFGHIJKLM")))))
