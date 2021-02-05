(ns atbash-cipher-test
  (:require [clojure.test :refer [deftest is]]
            atbash-cipher))

(deftest encode-no
  (is (= "ml" (atbash-cipher/encode "no"))))

(deftest encode-yes
  (is (= "bvh" (atbash-cipher/encode "yes"))))

(deftest encode-OMG
  (is (= "lnt" (atbash-cipher/encode "OMG"))))

(deftest encode-O-M-G
  (is (= "lnt" (atbash-cipher/encode "O M G"))))

(deftest encode-long-word
  (is (= "nrmwy oldrm tob" (atbash-cipher/encode "mindblowingly"))))

(deftest encode-numbers
  (is (= "gvhgr mt123 gvhgr mt"
         (atbash-cipher/encode "Testing, 1 2 3, testing."))))

(deftest encode-sentence
  (is (= "gifgs rhurx grlm" (atbash-cipher/encode "Truth is fiction."))))

(deftest encode-all-the-things
  (let [plaintext "The quick brown fox jumps over the lazy dog."
        cipher    "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"]
    (is (= cipher (atbash-cipher/encode plaintext)))))
