(ns minesweeper-test
  (:require [clojure.test :refer [deftest testing is]]
            minesweeper))

(def separator (System/getProperty "line.separator"))

(defn join-with-line-separator
  [coll]
  (clojure.string/join separator coll))

(deftest draw_test_1
  (testing "no columns"
    (is (= (join-with-line-separator [""])
           (minesweeper/draw
             (join-with-line-separator [""]))))))

(deftest draw_test_2
  (testing "no mines"
    (is (= (join-with-line-separator ["   "
                                      "   "
                                      "   "])
           (minesweeper/draw
             (join-with-line-separator ["   "
                                        "   "
                                        "   "]))))))

(deftest draw_test_3
  (testing "minefield with only mines"
    (is (= (join-with-line-separator ["***"
                                      "***"
                                      "***"])
           (minesweeper/draw
             (join-with-line-separator ["***"
                                        "***"
                                        "***"]))))))

(deftest draw_test_4
  (testing "mine surrounded by spaces"
    (is (= (join-with-line-separator ["111"
                                      "1*1"
                                      "111"])
           (minesweeper/draw
             (join-with-line-separator ["   "
                                        " * "
                                        "   "]))))))


(deftest draw_test_5
  (testing "space surrounded by mines"
    (is (= (join-with-line-separator ["***"
                                      "*8*"
                                      "***"])
           (minesweeper/draw
             (join-with-line-separator ["***"
                                        "* *"
                                        "***"]))))))

(deftest draw_test_6
  (testing "horizontal line"
    (is (= (join-with-line-separator ["1*2*1"])
           (minesweeper/draw
             (join-with-line-separator [" * * "]))))))

(deftest draw_test_7
  (testing "horizontal line, mines at edges"
    (is (= (join-with-line-separator ["*1 1*"])
           (minesweeper/draw
             (join-with-line-separator ["*   *"]))))))

(deftest draw_test_8
  (testing "vertical line"
    (is (= (join-with-line-separator ["1"
                                      "*"
                                      "2"
                                      "*"
                                      "1"])
           (minesweeper/draw
             (join-with-line-separator [" "
                                        "*"
                                        " "
                                        "*"
                                        " "]))))))

(deftest draw_test_9
  (testing "vertical line, mines at edges"
    (is (= (join-with-line-separator ["*"
                                      "1"
                                      " "
                                      "1"
                                      "*"])
           (minesweeper/draw
             (join-with-line-separator ["*"
                                        " "
                                        " "
                                        " "
                                        "*"]))))))

(deftest draw_test_10
  (testing "cross"
    (is (= (join-with-line-separator [" 2*2 "
                                      "25*52"
                                      "*****"
                                      "25*52"
                                      " 2*2 "])
           (minesweeper/draw
             (join-with-line-separator ["  *  "
                                        "  *  "
                                        "*****"
                                        "  *  "
                                        "  *  "]))))))

(deftest draw_test_11
  (testing "large minefield"
    (is (= (join-with-line-separator ["1*22*1"
                                      "12*322"
                                      " 123*2"
                                      "112*4*"
                                      "1*22*2"
                                      "111111"])
           (minesweeper/draw
             (join-with-line-separator [" *  * "
                                        "  *   "
                                        "    * "
                                        "   * *"
                                        " *  * "
                                        "      "]))))))
