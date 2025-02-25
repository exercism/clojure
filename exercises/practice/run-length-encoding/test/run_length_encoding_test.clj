(ns run-length-encoding-test
  (:require [clojure.test :refer [deftest testing is]]
            run-length-encoding))

(deftest run-length-encode_test_1
  (testing "run-length encode a string ▶ empty string"
    (is (= ""
           (run-length-encoding/run-length-encode "")))))

(deftest run-length-encode_test_2
  (testing "run-length encode a string ▶ single characters only are encoded without count"
    (is (= "XYZ"
           (run-length-encoding/run-length-encode "XYZ")))))

(deftest run-length-encode_test_3
  (testing "run-length encode a string ▶ string with no single characters"
    (is (= "2A3B4C"
           (run-length-encoding/run-length-encode "AABBBCCCC")))))

(deftest run-length-encode_test_4
  (testing "run-length encode a string ▶ single characters mixed with repeated characters"
    (is (= "12WB12W3B24WB"
           (run-length-encoding/run-length-encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB")))))

(deftest run-length-encode_test_5
  (testing "run-length encode a string ▶ multiple whitespace mixed in string"
    (is (= "2 hs2q q2w2 "
           (run-length-encoding/run-length-encode "  hsqq qww  ")))))

(deftest run-length-encode_test_6
  (testing "run-length encode a string ▶ lowercase characters"
    (is (= "2a3b4c"
           (run-length-encoding/run-length-encode "aabbbcccc")))))

(deftest run-length-decode_test_1
  (testing "run-length decode a string ▶ empty string"
    (is (= ""
           (run-length-encoding/run-length-decode "")))))

(deftest run-length-decode_test_2
  (testing "run-length decode a string ▶ single characters only"
    (is (= "XYZ"
           (run-length-encoding/run-length-decode "XYZ")))))

(deftest run-length-decode_test_3
  (testing "run-length decode a string ▶ string with no single characters"
    (is (= "AABBBCCCC"
           (run-length-encoding/run-length-decode "2A3B4C")))))

(deftest run-length-decode_test_4
  (testing "run-length decode a string ▶ single characters with repeated characters"
    (is (= "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"
           (run-length-encoding/run-length-decode "12WB12W3B24WB")))))

(deftest run-length-decode_test_5
  (testing "run-length decode a string ▶ multiple whitespace mixed in string"
    (is (= "  hsqq qww  "
           (run-length-encoding/run-length-decode "2 hs2q q2w2 ")))))

(deftest run-length-decode_test_6
  (testing "run-length decode a string ▶ lowercase string"
    (is (= "aabbbcccc"
           (run-length-encoding/run-length-decode "2a3b4c")))))
