(ns connect-test
  (:require [clojure.test :refer [deftest testing is]]
            connect))

(deftest connect-winner_test_1
  (testing "an empty board has no winner"
    (is (= :no-winner
           (connect/connect-winner
            [". . . . ."
             " . . . . ."
             "  . . . . ."
             "   . . . . ."
             "    . . . . ."])))))

(deftest connect-winner_test_2
  (testing "X can win on a 1x1 board"
    (is (= :X
           (connect/connect-winner
            ["X"])))))

(deftest connect-winner_test_3
  (testing "O can win on a 1x1 board"
    (is (= :O
           (connect/connect-winner
            ["O"])))))

(deftest connect-winner_test_4
  (testing "only edges does not make a winner"
    (is (= :no-winner
           (connect/connect-winner
            ["O O O X"
             " X . . X"
             "  X . . X"
             "   X O O O"])))))

(deftest connect-winner_test_5
  (testing "illegal diagonal does not make a winner"
    (is (= :no-winner
           (connect/connect-winner
            ["X O . ."
             " O X X X"
             "  O X O ."
             "   . O X ."
             "    X X O O"])))))

(deftest connect-winner_test_6
  (testing "nobody wins crossing adjacent angles"
    (is (= :no-winner
           (connect/connect-winner
            ["X . . ."
             " . X O ."
             "  O . X O"
             "   . O . X"
             "    . . O ."])))))

(deftest connect-winner_test_7
  (testing "X wins crossing from left to right"
    (is (= :X
           (connect/connect-winner
            [". O . ."
             " O X X X"
             "  O X O ."
             "   X X O X"
             "    . O X ."])))))

(deftest connect-winner_test_8
  (testing "O wins crossing from top to bottom"
    (is (= :O
           (connect/connect-winner
            [". O . ."
             " O X X X"
             "  O O O ."
             "   X X O X"
             "    . O X ."])))))

(deftest connect-winner_test_9
  (testing "X wins using a convoluted path"
    (is (= :X
           (connect/connect-winner
            [". X X . ."
             " X . X . X"
             "  . X . X ."
             "   . X X . ."
             "    O O O O O"])))))

(deftest connect-winner_test_10
  (testing "X wins using a spiral path"
    (is (= :X
           (connect/connect-winner
            ["O X X X X X X X X"
             " O X O O O O O O O"
             "  O X O X X X X X O"
             "   O X O X O O O X O"
             "    O X O X X X O X O"
             "     O X O O O X O X O"
             "      O X X X X X O X O"
             "       O O O O O O O X O"
             "        X X X X X X X X O"])))))
