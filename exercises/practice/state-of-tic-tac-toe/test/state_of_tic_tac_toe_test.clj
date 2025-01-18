(ns state-of-tic-tac-toe-test
  (:require [clojure.test :refer [deftest testing is]]
            state-of-tic-tac-toe))

(deftest gamestate_test_1
  (testing "Won games ▶ Finished game where X won via left column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XOO"
             "X  "
             "X  "])))))

(deftest gamestate_test_2
  (testing "Won games ▶ Finished game where X won via middle column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["OXO"
             " X "
             " X "])))))

(deftest gamestate_test_3
  (testing "Won games ▶ Finished game where X won via right column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["OOX"
             "  X"
             "  X"])))))

(deftest gamestate_test_4
  (testing "Won games ▶ Finished game where O won via left column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["OXX"
             "OX "
             "O  "])))))

(deftest gamestate_test_5
  (testing "Won games ▶ Finished game where O won via middle column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XOX"
             " OX"
             " O "])))))

(deftest gamestate_test_6
  (testing "Won games ▶ Finished game where O won via right column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XXO"
             " XO"
             "  O"])))))

(deftest gamestate_test_7
  (testing "Won games ▶ Finished game where X won via top row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XXX"
             "XOO"
             "O  "])))))

(deftest gamestate_test_8
  (testing "Won games ▶ Finished game where X won via middle row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["O  "
             "XXX"
             " O "])))))

(deftest gamestate_test_9
  (testing "Won games ▶ Finished game where X won via bottom row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            [" OO"
             "O X"
             "XXX"])))))

(deftest gamestate_test_10
  (testing "Won games ▶ Finished game where O won via top row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["OOO"
             "XXO"
             "XX "])))))

(deftest gamestate_test_11
  (testing "Won games ▶ Finished game where O won via middle row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XX "
             "OOO"
             "X  "])))))

(deftest gamestate_test_12
  (testing "Won games ▶ Finished game where O won via bottom row victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XOX"
             " XX"
             "OOO"])))))

(deftest gamestate_test_13
  (testing "Won games ▶ Finished game where X won via falling diagonal victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XOO"
             " X "
             "  X"])))))

(deftest gamestate_test_14
  (testing "Won games ▶ Finished game where X won via rising diagonal victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["O X"
             "OX "
             "X  "])))))

(deftest gamestate_test_15
  (testing "Won games ▶ Finished game where O won via falling diagonal victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["OXX"
             "OOX"
             "X O"])))))

(deftest gamestate_test_16
  (testing "Won games ▶ Finished game where O won via rising diagonal victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["  O"
             " OX"
             "OXX"])))))

(deftest gamestate_test_17
  (testing "Won games ▶ Finished game where X won via a row and a column victory"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XXX"
             "XOO"
             "XOO"])))))

(deftest gamestate_test_18
  (testing "Won games ▶ Finished game where X won via two diagonal victories"
    (is (= :win
           (state-of-tic-tac-toe/gamestate
            ["XOX"
             "OXO"
             "XOX"])))))

(deftest gamestate_test_19
  (testing "Drawn games ▶ Draw"
    (is (= :draw
           (state-of-tic-tac-toe/gamestate
            ["XOX"
             "XXO"
             "OXO"])))))

(deftest gamestate_test_20
  (testing "Drawn games ▶ Another draw"
    (is (= :draw
           (state-of-tic-tac-toe/gamestate
            ["XXO"
             "OXX"
             "XOO"])))))

(deftest gamestate_test_21
  (testing "Ongoing games ▶ Ongoing game: one move in"
    (is (= :ongoing
           (state-of-tic-tac-toe/gamestate
            ["   "
             "X  "
             "   "])))))

(deftest gamestate_test_22
  (testing "Ongoing games ▶ Ongoing game: two moves in"
    (is (= :ongoing
           (state-of-tic-tac-toe/gamestate
            ["O  "
             " X "
             "   "])))))

(deftest gamestate_test_23
  (testing "Ongoing games ▶ Ongoing game: five moves in"
    (is (= :ongoing
           (state-of-tic-tac-toe/gamestate
            ["X  "
             " XO"
             "OX "])))))

(deftest gamestate_test_24
  (testing "Invalid boards ▶ Invalid board: X went twice"
    (is (thrown-with-msg? IllegalArgumentException #"^Wrong turn order: X went twice$"
                          (state-of-tic-tac-toe/gamestate
                           ["XX "
                            "   "
                            "   "])))))

(deftest gamestate_test_25
  (testing "Invalid boards ▶ Invalid board: O started"
    (is (thrown-with-msg? IllegalArgumentException #"^Wrong turn order: O started$"
                          (state-of-tic-tac-toe/gamestate
                           ["OOX"
                            "   "
                            "   "])))))

(deftest gamestate_test_26
  (testing "Invalid boards ▶ Invalid board: X won and O kept playing"
    (is (thrown-with-msg? IllegalArgumentException #"^Impossible board: game should have ended after the game was won$"
                          (state-of-tic-tac-toe/gamestate
                           ["XXX"
                            "OOO"
                            "   "])))))

(deftest gamestate_test_27
  (testing "Invalid boards ▶ Invalid board: players kept playing after a win"
    (is (thrown-with-msg? IllegalArgumentException #"^Impossible board: game should have ended after the game was won$"
                          (state-of-tic-tac-toe/gamestate
                           ["XXX"
                            "OOO"
                            "XOX"])))))
