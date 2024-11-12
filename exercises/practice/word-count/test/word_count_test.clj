(ns word-count-test
  (:require [clojure.test :refer [deftest testing is]]
            word-count))

(deftest test-61559d5f-2cad-48fb-af53-d3973a9ee9ef
  (testing "count one word"
    (is (= {"word" 1}
           (word-count/word-count "word")))))

(deftest test-5abd53a3-1aed-43a4-a15a-29f88c09cbbd
  (testing "count one of each word"
    (is (= {"one" 1
            "of" 1
            "each" 1}
           (word-count/word-count "one of each")))))

(deftest test-2a3091e5-952e-4099-9fac-8f85d9655c0e
  (testing "multiple occurrences of a word"
    (is (= {"one" 1
            "fish" 4
            "two" 1
            "red" 1
            "blue" 1}
           (word-count/word-count "one fish two fish red fish blue fish")))))

(deftest test-e81877ae-d4da-4af4-931c-d923cd621ca6
  (testing "handles cramped lists"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count "one,two,three")))))

(deftest test-7349f682-9707-47c0-a9af-be56e1e7ff30
  (testing "handles expanded lists"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count "one,\ntwo,\nthree")))))

(deftest test-a514a0f2-8589-4279-8892-887f76a14c82
  (testing "ignore punctuation"
    (is (= {"car" 1
            "carpet" 1
            "as" 1
            "java" 1
            "javascript" 1}
           (word-count/word-count "car: carpet as java: javascript!!&@$%^&")))))

(deftest test-d2e5cee6-d2ec-497b-bdc9-3ebe092ce55e
  (testing "include numbers"
    (is (= {"testing" 2
            "1" 1
            "2" 1}
           (word-count/word-count "testing, 1, 2 testing")))))

(deftest test-dac6bc6a-21ae-4954-945d-d7f716392dbf
  (testing "normalize case"
    (is (= {"go" 3
            "stop" 2}
           (word-count/word-count "go Go GO Stop stop")))))

(deftest test-4ff6c7d7-fcfc-43ef-b8e7-34ff1837a2d3
  (testing "with apostrophes"
    (is (= {"first" 1
            "don't" 2
            "laugh" 1
            "then" 1
            "cry" 1
            "you're" 1
            "getting" 1
            "it" 1}
           (word-count/word-count "'First: don't laugh. Then: don't cry. You're getting it.'")))))

(deftest test-be72af2b-8afe-4337-b151-b297202e4a7b
  (testing "with quotations"
    (is (= {"joe" 1
            "can't" 1
            "tell" 1
            "between" 1
            "large" 2
            "and" 1}
           (word-count/word-count "Joe can't tell between 'large' and large.")))))

(deftest test-8d6815fe-8a51-4a65-96f9-2fb3f6dc6ed6
  (testing "substrings from the beginning"
    (is (= {"joe" 1
            "can't" 1
            "tell" 1
            "between" 1
            "app" 1
            "apple" 1
            "and" 1
            "a" 1}
           (word-count/word-count "Joe can't tell between app, apple and a.")))))

(deftest test-c5f4ef26-f3f7-4725-b314-855c04fb4c13
  (testing "multiple spaces not detected as a word"
    (is (= {"multiple" 1
            "whitespaces" 1}
           (word-count/word-count " multiple   whitespaces")))))

(deftest test-50176e8a-fe8e-4f4c-b6b6-aa9cf8f20360
  (testing "alternating word separators not detected as a word"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count ",\n,one,\n ,two \n 'three'")))))

(deftest test-6d00f1db-901c-4bec-9829-d20eb3044557
  (testing "quotation for word with apostrophe"
    (is (= {"can" 1
            "can't" 2}
           (word-count/word-count "can, can't, 'can't'")))))
