(ns scrabble.test (:require [clojure.test :refer :all]))
(load-file "scrabble.clj")

(deftest lower-case-letter
  (is (= 1 (scrabble/score-letter "a"))))
(deftest upper-case-letter
  (is (= 1 (scrabble/score-letter "A"))))
(deftest two-letter-word
  (is (= 2 (scrabble/score-word "at"))))
(deftest bigger-word-1
  (is (= 6 (scrabble/score-word "street"))))
(deftest bigger-word-2
  (is (= 22 (scrabble/score-word "quirky"))))
(deftest all-upper-case-word
  (is (= 20 (scrabble/score-word "MULTIBILLIONAIRE"))))

(run-tests)
