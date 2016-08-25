(ns minesweeper-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.string :refer [join]]
            [minesweeper :refer [draw]]))

(deftest zero-size-board
  (is (= (draw "") "")))

(deftest empty-board
  (is (= (draw (join \newline ["   "
                               "   "
                               "   "]))
         (join \newline ["   "
                         "   "
                         "   "]))))

(deftest surrounded
  (is (= (draw (join \newline ["***"
                               "* *"
                               "***"]))
         (join \newline ["***"
                         "*8*"
                         "***"]))))

(deftest board-full-of-mines
  (is (= (draw (join \newline ["***"
                               "***"
                               "***"]))
         (join \newline ["***"
                         "***"
                         "***"]))))

(deftest horizontal-line
  (is (= (draw " * * ")
         "1*2*1")))

(deftest vertical-line
  (is (= (draw (join \newline [" "
                               "*"
                               " "
                               "*"
                               " "]))
         (join \newline ["1"
                         "*"
                         "2"
                         "*"
                         "1"]))))

(deftest cross
  (is (= (draw (join \newline ["  *  "
                               "  *  "
                               "*****"
                               "  *  "
                               "  *  "]))
         (join \newline [" 2*2 "
                         "25*52"
                         "*****"
                         "25*52"
                         " 2*2 "]))))

