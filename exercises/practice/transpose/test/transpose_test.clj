(ns transpose-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            transpose))

(deftest transpose_test_1
  (testing "empty string"
    (is (= (str/join "\n" [""])
           (transpose/transpose
            (str/join "\n" [""]))))))

(deftest transpose_test_2
  (testing "two characters in a row"
    (is (= (str/join "\n" ["A"
                           "1"])
           (transpose/transpose
            (str/join "\n" ["A1"]))))))

(deftest transpose_test_3
  (testing "two characters in a column"
    (is (= (str/join "\n" ["A1"])
           (transpose/transpose
            (str/join "\n" ["A"
                            "1"]))))))

(deftest transpose_test_4
  (testing "simple"
    (is (= (str/join "\n" ["A1"
                           "B2"
                           "C3"])
           (transpose/transpose
            (str/join "\n" ["ABC"
                            "123"]))))))

(deftest transpose_test_5
  (testing "single line"
    (is (= (str/join "\n" ["S"
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
            (str/join "\n" ["Single line."]))))))

(deftest transpose_test_6
  (testing "first line longer than second line"
    (is (= (str/join "\n" ["TT"
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
            (str/join "\n" ["The fourth line."
                            "The fifth line."]))))))

(deftest transpose_test_7
  (testing "second line longer than first line"
    (is (= (str/join "\n" ["TT"
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
            (str/join "\n" ["The first line."
                            "The second line."]))))))

(deftest transpose_test_8
  (testing "mixed line length"
    (is (= (str/join "\n" ["TAAA"
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
            (str/join "\n" ["The longest line."
                            "A long line."
                            "A longer line."
                            "A line."]))))))

(deftest transpose_test_9
  (testing "square"
    (is (= (str/join "\n" ["HEART"
                           "EMBER"
                           "ABUSE"
                           "RESIN"
                           "TREND"])
           (transpose/transpose
            (str/join "\n" ["HEART"
                            "EMBER"
                            "ABUSE"
                            "RESIN"
                            "TREND"]))))))

(deftest transpose_test_10
  (testing "rectangle"
    (is (= (str/join "\n" ["FOBS"
                           "RULE"
                           "ATOP"
                           "CLOT"
                           "TIME"
                           "UNIT"
                           "RENT"
                           "EDGE"])
           (transpose/transpose
            (str/join "\n" ["FRACTURE"
                            "OUTLINED"
                            "BLOOMING"
                            "SEPTETTE"]))))))

(deftest transpose_test_11
  (testing "triangle"
    (is (= (str/join "\n" ["TEASER"
                           " EASER"
                           "  ASER"
                           "   SER"
                           "    ER"
                           "     R"])
           (transpose/transpose
            (str/join "\n" ["T"
                            "EE"
                            "AAA"
                            "SSSS"
                            "EEEEE"
                            "RRRRRR"]))))))

(deftest transpose_test_12
  (testing "jagged triangle"
    (is (= (str/join "\n" ["123456"
                           "1 3456"
                           "  3456"
                           "  3 56"
                           "    56"
                           "    5"])
           (transpose/transpose
            (str/join "\n" ["11"
                            "2"
                            "3333"
                            "444"
                            "555555"
                            "66666"]))))))
