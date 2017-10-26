(ns run-length-encoding-test
  (:require [clojure.test :refer :all]
            [run-length-encoding :as rle]))

;;Tests for run-length-encoding exercise

(deftest encode-empty-string
         (testing "encode an empty string"
                  (is (= (rle/run-length-encode "") ""))))

(deftest encode-single-characters-without-count
         (testing "encode single characters without count"
                  (is (= (rle/run-length-encode "XYZ") "XYZ"))))

(deftest encode-string-with-no-single-characters
         (testing "encode string with no single characters"
                  (is (= (rle/run-length-encode "AABBBCCCC") "2A3B4C"))))

(deftest encode-string-with-single-and-mixed-characters
         (testing "encode string with single and mixed characters"
                  (is (= (rle/run-length-encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB") "12WB12W3B24WB"))))

(deftest encode-multiple-whitespace
         (testing "encode string with whitespace characters mixed in it"
                  (is (= (rle/run-length-encode "  hsqq qww  ") "2 hs2q q2w2 "))))

(deftest encode-lowercase
         (testing "encode string with lowercase characters"
                  (is (= (rle/run-length-encode "aabbbcccc") "2a3b4c"))))

(deftest decode-empty-string
         (testing "decode empty string"
                  (is (= (rle/run-length-decode "") ""))))

(deftest decode-single-characters
         (testing "decode string with single characters only"
                  (is (= (rle/run-length-decode "XYZ") "XYZ"))))

(deftest decode-no-single-characters
         (testing "decode string with no single characters"
                  (is (= (rle/run-length-decode "2A3B4C") "AABBBCCCC"))))

(deftest decode-single-and-repeated-characters
         (testing "decode string with single and repeated characters"
                  (is (= (rle/run-length-decode "12WB12W3B24WB") "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))))

(deftest decode-lowercase
         (testing "decode string with lowercase characters"
                  (is (= (rle/run-length-decode "2a3b4c") "aabbbcccc"))))

(deftest decode-mixed-whitespace
         (testing "decode string with mixed whitespace characters in it"
                  (is (= (rle/run-length-decode "2 hs2q q2w2 ") "  hsqq qww  "))))

(deftest consistency
         (testing "Encode a string and then decode it. Should return the same one."
                  (is (= (rle/run-length-decode (rle/run-length-encode "zzz ZZ  zZ")) "zzz ZZ  zZ"))))
