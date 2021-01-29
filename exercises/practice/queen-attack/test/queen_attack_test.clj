(ns queen-attack-test
  (:require [clojure.test :refer [deftest is]]
            queen-attack))

(def empty-board
  (str "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"))

(def board
  (str "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ W _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ _ _\n"
       "_ _ _ _ _ _ B _\n"
       "_ _ _ _ _ _ _ _\n"))

(deftest handles-empty-board
  (is (= empty-board (queen-attack/board-string {}))))
(deftest build-board
  (is (= board (queen-attack/board-string {:w [2 4] :b [6 6]}))))

(deftest finds-attack-positions
  (is (= false (queen-attack/can-attack {:w [2 3] :b [4 7]})))
  (is (= true  (queen-attack/can-attack {:w [2 4] :b [2 7]})))
  (is (= true  (queen-attack/can-attack {:w [5 4] :b [2 4]})))
  (is (= true  (queen-attack/can-attack {:w [1 1] :b [6 6]})))
  (is (= true  (queen-attack/can-attack {:w [0 6] :b [1 7]})))
  (is (= true  (queen-attack/can-attack {:w [4 1] :b [6 3]}))))
