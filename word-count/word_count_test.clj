(ns word-count.test (:require [clojure.test :refer :all]))
(load-file "word_count.clj")

(deftest count-one-word
  (is (= {"word" 1}
         (word_count/word-count "word"))))

(deftest count-one-of-each
  (is (= {"one" 1 "of" 1 "each" 1}
         (word_count/word-count "one of each"))))

(deftest count-multiple-occurrences
  (is (= {"one" 1 "fish" 4 "two" 1 "red" 1 "blue" 1}
         (word_count/word-count "one fish two fish red fish blue fish"))))

(deftest ignore-punctuation
  (is (= {"car" 1, "carpet" 1 "as" 1 "java" 1 "javascript" 1}
         (word_count/word-count "car : carpet as java : javascript!!&@$%^&"))))

(deftest include-numbers
  (is (= {"testing" 2 "1" 1 "2" 1}
         (word_count/word-count "testing, 1, 2 testing"))))

(deftest normalize-case
  (is (= {"go" 3}
         (word_count/word-count "go Go GO"))))

(run-tests)
