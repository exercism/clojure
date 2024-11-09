(ns minesweeper-test
  (:require [clojure.test :refer [deftest testing is]]
            minesweeper))

(def separator (System/getProperty "line.separator"))

(defn join-with-line-separator
  [coll]
  (clojure.string/join separator coll))

(deftest test-650ac4c0-ad6b-4b41-acde-e4ea5852c3b8
  (testing "no columns"
    (is (= (join-with-line-separator [""])
           (minesweeper/draw
             (join-with-line-separator [""]))))))

(deftest test-6fbf8f6d-a03b-42c9-9a58-b489e9235478
  (testing "no mines"
    (is (= (join-with-line-separator ["   "
                                      "   "
                                      "   "])
           (minesweeper/draw
             (join-with-line-separator ["   "
                                        "   "
                                        "   "]))))))

(deftest test-61aff1c4-fb31-4078-acad-cd5f1e635655
  (testing "minefield with only mines"
    (is (= (join-with-line-separator ["***"
                                      "***"
                                      "***"])
           (minesweeper/draw
             (join-with-line-separator ["***"
                                        "***"
                                        "***"]))))))

(deftest test-84167147-c504-4896-85d7-246b01dea7c5
  (testing "mine surrounded by spaces"
    (is (= (join-with-line-separator ["111"
                                      "1*1"
                                      "111"])
           (minesweeper/draw
             (join-with-line-separator ["   "
                                        " * "
                                        "   "]))))))


(deftest test-cb878f35-43e3-4c9d-93d9-139012cccc4a
  (testing "space surrounded by mines"
    (is (= (join-with-line-separator ["***"
                                      "*8*"
                                      "***"])
           (minesweeper/draw
             (join-with-line-separator ["***"
                                        "* *"
                                        "***"]))))))

(deftest test-7037f483-ddb4-4b35-b005-0d0f4ef4606f
  (testing "horizontal line"
    (is (= (join-with-line-separator ["1*2*1"])
           (minesweeper/draw
             (join-with-line-separator [" * * "]))))))

(deftest test-e359820f-bb8b-4eda-8762-47b64dba30a6
  (testing "horizontal line, mines at edges"
    (is (= (join-with-line-separator ["*1 1*"])
           (minesweeper/draw
             (join-with-line-separator ["*   *"]))))))

(deftest test-c5198b50-804f-47e9-ae02-c3b42f7ce3ab
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

(deftest test-0c79a64d-703d-4660-9e90-5adfa5408939
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

(deftest test-4b098563-b7f3-401c-97c6-79dd1b708f34
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

(deftest test-04a260f1-b40a-4e89-839e-8dd8525abe0e
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
