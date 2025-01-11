(ns word-count-test
  (:require [clojure.test :refer [deftest testing is]]
            word-count))

(deftest word-count_test_1
  (testing "count one word"
    (is (= {"word" 1}
           (word-count/word-count "word")))))

(deftest word-count_test_2
  (testing "count one of each word"
    (is (= {"one" 1
            "of" 1
            "each" 1}
           (word-count/word-count "one of each")))))

(deftest word-count_test_3
  (testing "multiple occurrences of a word"
    (is (= {"one" 1
            "fish" 4
            "two" 1
            "red" 1
            "blue" 1}
           (word-count/word-count "one fish two fish red fish blue fish")))))

(deftest word-count_test_4
  (testing "handles cramped lists"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count "one,two,three")))))

(deftest word-count_test_5
  (testing "handles expanded lists"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count "one,\ntwo,\nthree")))))

(deftest word-count_test_6
  (testing "ignore punctuation"
    (is (= {"car" 1
            "carpet" 1
            "as" 1
            "java" 1
            "javascript" 1}
           (word-count/word-count "car: carpet as java: javascript!!&@$%^&")))))

(deftest word-count_test_7
  (testing "include numbers"
    (is (= {"testing" 2
            "1" 1
            "2" 1}
           (word-count/word-count "testing, 1, 2 testing")))))

(deftest word-count_test_8
  (testing "normalize case"
    (is (= {"go" 3
            "stop" 2}
           (word-count/word-count "go Go GO Stop stop")))))

(deftest word-count_test_9
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

(deftest word-count_test_10
  (testing "with quotations"
    (is (= {"joe" 1
            "can't" 1
            "tell" 1
            "between" 1
            "large" 2
            "and" 1}
           (word-count/word-count "Joe can't tell between 'large' and large.")))))

(deftest word-count_test_11
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

(deftest word-count_test_12
  (testing "multiple spaces not detected as a word"
    (is (= {"multiple" 1
            "whitespaces" 1}
           (word-count/word-count " multiple   whitespaces")))))

(deftest word-count_test_13
  (testing "alternating word separators not detected as a word"
    (is (= {"one" 1
            "two" 1
            "three" 1}
           (word-count/word-count ",\n,one,\n ,two \n 'three'")))))

(deftest word-count_test_14
  (testing "quotation for word with apostrophe"
    (is (= {"can" 1
            "can't" 2}
           (word-count/word-count "can, can't, 'can't'")))))
