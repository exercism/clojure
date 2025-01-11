(ns transpose-test
  (:require [clojure.test :refer [deftest testing is]]
            transpose))

(defn join-with-line-separator
  [coll]
  (clojure.string/join "\n" coll))

(deftest transpose_test_1
  (testing "empty string"
    (is (= (join-with-line-separator [""])
           (transpose/transpose
             (join-with-line-separator [""]))))))

(deftest transpose_test_2
  (testing "two characters in a row"
    (is (= (join-with-line-separator ["A"
                                      "1"])
           (transpose/transpose
             (join-with-line-separator ["A1"]))))))

(deftest transpose_test_3
  (testing "two characters in a column"
    (is (= (join-with-line-separator ["A1"])
           (transpose/transpose
             (join-with-line-separator ["A"
                                        "1"]))))))

(deftest transpose_test_4
  (testing "simple"
    (is (= (join-with-line-separator ["A1"
                                      "B2"
                                      "C3"])
           (transpose/transpose
             (join-with-line-separator ["ABC"
                                        "123"]))))))

(deftest transpose_test_5
  (testing "single line"
    (is (= (join-with-line-separator ["S"
                                      "i"
                                      "n"
                                      "g"
                                      "l"
                                      "e"
                                      " "
                                      "l"
                                      "i"
                                      "n"
                                      "e"
                                      "."])
           (transpose/transpose
             (join-with-line-separator ["Single line."]))))))

(deftest transpose_test_6
  (testing "first line longer than second line"
    (is (= (join-with-line-separator ["TT"
                                      "hh"
                                      "ee"
                                      "  "
                                      "ff"
                                      "oi"
                                      "uf"
                                      "rt"
                                      "th"
                                      "h "
                                      " l"
                                      "li"
                                      "in"
                                      "ne"
                                      "e."
                                      "."])
           (transpose/transpose
             (join-with-line-separator ["The fourth line."
                                        "The fifth line."]))))))

(deftest transpose_test_7
  (testing "second line longer than first line"
    (is (= (join-with-line-separator ["TT"
                                      "hh"
                                      "ee"
                                      "  "
                                      "fs"
                                      "ie"
                                      "rc"
                                      "so"
                                      "tn"
                                      " d"
                                      "l "
                                      "il"
                                      "ni"
                                      "en"
                                      ".e"
                                      " ."])
           (transpose/transpose
             (join-with-line-separator ["The first line.",
                                        "The second line."]))))))

(deftest transpose_test_8
  (testing "mixed line length"
    (is (= (join-with-line-separator ["TAAA"
                                      "h   "
                                      "elll"
                                      " ooi"
                                      "lnnn"
                                      "ogge"
                                      "n e."
                                      "glr"
                                      "ei "
                                      "snl"
                                      "tei"
                                      " .n"
                                      "l e"
                                      "i ."
                                      "n"
                                      "e"
                                      "."])
           (transpose/transpose
             (join-with-line-separator ["The longest line."
                                        "A long line."
                                        "A longer line."
                                        "A line."]))))))

(deftest transpose_test_9
  (testing "square"
    (is (= (join-with-line-separator ["HEART"
                                      "EMBER"
                                      "ABUSE"
                                      "RESIN"
                                      "TREND"])
           (transpose/transpose
             (join-with-line-separator ["HEART"
                                        "EMBER"
                                        "ABUSE"
                                        "RESIN"
                                        "TREND"]))))))

(deftest transpose_test_10
  (testing "rectangle"
    (is (= (join-with-line-separator ["FOBS"
                                      "RULE"
                                      "ATOP"
                                      "CLOT"
                                      "TIME"
                                      "UNIT"
                                      "RENT"
                                      "EDGE"])
           (transpose/transpose
             (join-with-line-separator ["FRACTURE"
                                        "OUTLINED"
                                        "BLOOMING"
                                        "SEPTETTE"]))))))

(deftest transpose_test_11
  (testing "triangle"
    (is (= (join-with-line-separator ["TEASER"
                                      " EASER"
                                      "  ASER"
                                      "   SER"
                                      "    ER"
                                      "     R"])
           (transpose/transpose
             (join-with-line-separator ["T"
                                        "EE"
                                        "AAA"
                                        "SSSS"
                                        "EEEEE"
                                        "RRRRRR"]))))))

(deftest transpose_test_12
  (testing "jagged triangle"
    (is (= (join-with-line-separator ["123456"
                                      "1 3456"
                                      "  3456"
                                      "  3 56"
                                      "    56"
                                      "    5"])
           (transpose/transpose
             (join-with-line-separator ["11"
                                        "2"
                                        "3333"
                                        "444"
                                        "555555"
                                        "66666"]))))))
