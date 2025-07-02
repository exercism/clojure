(ns flower-field-test
  (:require [clojure.test :refer [deftest testing is]]
            flower-field))

(def separator (System/getProperty "line.separator"))

(defn join-with-line-separator
  [coll]
  (clojure.string/join separator coll))

(deftest draw_test_1
  (testing "no columns"
    (is (= (join-with-line-separator [""])
           (flower-field/draw
             (join-with-line-separator [""]))))))

(deftest draw_test_2
  (testing "no flowers"
    (is (= (join-with-line-separator ["   "
                                      "   "
                                      "   "])
           (flower-field/draw
             (join-with-line-separator ["   "
                                        "   "
                                        "   "]))))))

(deftest draw_test_3
  (testing "garden full of flowers"
    (is (= (join-with-line-separator ["***"
                                      "***"
                                      "***"])
           (flower-field/draw
             (join-with-line-separator ["***"
                                        "***"
                                        "***"]))))))

(deftest draw_test_4
  (testing "flower surrounded by spaces"
    (is (= (join-with-line-separator ["111"
                                      "1*1"
                                      "111"])
           (flower-field/draw
             (join-with-line-separator ["   "
                                        " * "
                                        "   "]))))))


(deftest draw_test_5
  (testing "space surrounded by flowers"
    (is (= (join-with-line-separator ["***"
                                      "*8*"
                                      "***"])
           (flower-field/draw
             (join-with-line-separator ["***"
                                        "* *"
                                        "***"]))))))

(deftest draw_test_6
  (testing "horizontal line"
    (is (= (join-with-line-separator ["1*2*1"])
           (flower-field/draw
             (join-with-line-separator [" * * "]))))))

(deftest draw_test_7
  (testing "horizontal line, flowers at edges"
    (is (= (join-with-line-separator ["*1 1*"])
           (flower-field/draw
             (join-with-line-separator ["*   *"]))))))

(deftest draw_test_8
  (testing "vertical line"
    (is (= (join-with-line-separator ["1"
                                      "*"
                                      "2"
                                      "*"
                                      "1"])
           (flower-field/draw
             (join-with-line-separator [" "
                                        "*"
                                        " "
                                        "*"
                                        " "]))))))

(deftest draw_test_9
  (testing "vertical line, flowers at edges"
    (is (= (join-with-line-separator ["*"
                                      "1"
                                      " "
                                      "1"
                                      "*"])
           (flower-field/draw
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
           (flower-field/draw
             (join-with-line-separator ["  *  "
                                        "  *  "
                                        "*****"
                                        "  *  "
                                        "  *  "]))))))

(deftest draw_test_11
  (testing "large garden"
    (is (= (join-with-line-separator ["1*22*1"
                                      "12*322"
                                      " 123*2"
                                      "112*4*"
                                      "1*22*2"
                                      "111111"])
           (flower-field/draw
             (join-with-line-separator [" *  * "
                                        "  *   "
                                        "    * "
                                        "   * *"
                                        " *  * "
                                        "      "]))))))
