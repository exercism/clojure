(ns transpose-test
  (:require [clojure.test :refer [deftest testing is]]
            transpose))

(defn join-with-line-separator
  [coll]
  (clojure.string/join "\n" coll))

(deftest test-404b7262-c050-4df0-a2a2-0cb06cd6a821
  (testing "empty string"
    (is (= (join-with-line-separator [""])
           (transpose/transpose
             (join-with-line-separator [""]))))))

(deftest test-a89ce8a3-c940-4703-a688-3ea39412fbcb
  (testing "two characters in a row"
    (is (= (join-with-line-separator ["A"
                                      "1"])
           (transpose/transpose
             (join-with-line-separator ["A1"]))))))

(deftest test-855bb6ae-4180-457c-abd0-ce489803ce98
  (testing "two characters in a column"
    (is (= (join-with-line-separator ["A1"])
           (transpose/transpose
             (join-with-line-separator ["A"
                                        "1"]))))))

(deftest test-5ceda1c0-f940-441c-a244-0ced197769c8
  (testing "simple"
    (is (= (join-with-line-separator ["A1"
                                      "B2"
                                      "C3"])
           (transpose/transpose
             (join-with-line-separator ["ABC"
                                        "123"]))))))

(deftest test-a54675dd-ae7d-4a58-a9c4-0c20e99a7c1f
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

(deftest test-0dc2ec0b-549d-4047-aeeb-8029fec8d5c5
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

(deftest test-984e2ec3-b3d3-4b53-8bd6-96f5ef404102
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

(deftest test-eccd3784-45f0-4a3f-865a-360cb323d314
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

(deftest test-85b96b3f-d00c-4f80-8ca2-c8a5c9216c2d
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

(deftest test-b9257625-7a53-4748-8863-e08e9d27071d
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

(deftest test-b80badc9-057e-4543-bd07-ce1296a1ea2c
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

(deftest test-76acfd50-5596-4d05-89f1-5116328a7dd9
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
