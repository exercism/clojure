(ns atbash-cipher-test
  (:require [clojure.test :refer [deftest testing is]]
            atbash-cipher))

(deftest encode_test_1
  (testing "encode -> encode yes"
    (is (= "bvh"
           (atbash-cipher/encode "yes")))))

(deftest encode_test_2
  (testing "encode -> encode no"
    (is (= "ml"
           (atbash-cipher/encode "no")))))

(deftest encode_test_3
  (testing "encode -> encode OMG"
    (is (= "lnt"
           (atbash-cipher/encode "OMG")))))

(deftest encode_test_4
  (testing "encode -> encode spaces"
    (is (= "lnt"
           (atbash-cipher/encode "O M G")))))

(deftest encode_test_5
  (testing "encode -> encode mindblowingly"
    (is (= "nrmwy oldrm tob"
           (atbash-cipher/encode "mindblowingly")))))

(deftest encode_test_6
  (testing "encode -> encode numbers"
    (is (= "gvhgr mt123 gvhgr mt"
           (atbash-cipher/encode "Testing, 1 2 3, testing.")))))

(deftest encode_test_7
  (testing "encode -> encode deep thought"
    (is (= "gifgs rhurx grlm"
           (atbash-cipher/encode "Truth is fiction.")))))

(deftest encode_test_8
  (testing "encode -> encode all the letters"
    (is (= "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"
           (atbash-cipher/encode "The quick brown fox jumps over the lazy dog.")))))

(deftest decode_test_1
  (testing "decode -> decode exercism"
    (is (= "exercism"
           (atbash-cipher/decode "vcvix rhn")))))

(deftest decode_test_2
  (testing "decode -> decode a sentence"
    (is (= "anobstacleisoftenasteppingstone"
           (atbash-cipher/decode "zmlyh gzxov rhlug vmzhg vkkrm thglm v")))))

(deftest decode_test_3
  (testing "decode -> decode numbers"
    (is (= "testing123testing"
           (atbash-cipher/decode "gvhgr mt123 gvhgr mt")))))

(deftest decode_test_4
  (testing "decode -> decode all the letters"
    (is (= "thequickbrownfoxjumpsoverthelazydog"
           (atbash-cipher/decode "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt")))))

(deftest decode_test_5
  (testing "decode -> decode with too many spaces"
    (is (= "exercism"
           (atbash-cipher/decode "vc vix    r hn")))))

(deftest decode_test_6
  (testing "decode -> decode with no spaces"
    (is (= "anobstacleisoftenasteppingstone"
           (atbash-cipher/decode "zmlyhgzxovrhlugvmzhgvkkrmthglmv")))))
