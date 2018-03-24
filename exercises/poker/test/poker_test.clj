(ns poker-test
  (:require [clojure.test :refer [deftest is]]
            [poker :refer [best-hands]]))

(defn f [xs ys] (= (sort (best-hands xs)) (sort ys)))

(deftest single-hand-always-wins
  (is (f ["4S 5S 7H 8D JC"] ["4S 5S 7H 8D JC"])))

(deftest highest-card-out-of-all-hands-wins
  (is (f ["4D 5S 6S 8D 3C"
          "2S 4C 7S 9H 10H"
          "3S 4S 5D 6H JH"]
         ["3S 4S 5D 6H JH"])))

(deftest a-tie-has-multiple-winners
  (is (f ["4D 5S 6S 8D 3C"
          "2S 4C 7S 9H 10H"
          "3S 4S 5D 6H JH"
          "3H 4H 5C 6C JD"]
         ["3S 4S 5D 6H JH"
          "3H 4H 5C 6C JD"])))

(deftest multiple-hands-with-the-same-high-cards-tie-compares-next-highest-ranked-down-to-last-card
  (is (f ["3S 5H 6S 8D 7H"
          "2S 5D 6D 8C 7S"]
         ["3S 5H 6S 8D 7H"])))

(deftest one-pair-beats-high-card
  (is (f ["4S 5H 6C 8D KH"
          "2S 4H 6S 4D JH"]
         ["2S 4H 6S 4D JH"])))

(deftest highest-pair-wins
  (is (f ["4S 2H 6S 2D JH"
          "2S 4H 6C 4D JD"]
         ["2S 4H 6C 4D JD"])))

(deftest two-pairs-beats-one-pair
  (is (f ["2S 8H 6S 8D JH"
          "4S 5H 4C 8C 5C"]
         ["4S 5H 4C 8C 5C"])))

(deftest both-hands-have-two-pairs-highest-ranked-pair-wins
  (is (f ["2S 8H 2D 8D 3H"
          "4S 5H 4C 8S 5D"]
         ["2S 8H 2D 8D 3H"])))

(deftest both-hands-have-two-pairs-with-the-same-highest-ranked-pair-tie-goes-to-low-pair
  (is (f ["2S QS 2C QD JH"
          "JD QH JS 8D QC"]
         ["JD QH JS 8D QC"])))

(deftest both-hands-have-two-identically-ranked-pairs-tie-goes-to-remaining-card-kicker
  (is (f ["JD QH JS 8D QC"
          "JS QS JC 2D QD"]
         ["JD QH JS 8D QC"])))

(deftest three-of-a-kind-beats-two-pair
  (is (f ["2S 8H 2H 8D JH"
          "4S 5H 4C 8S 4H"]
         ["4S 5H 4C 8S 4H"])))

(deftest both-hands-have-three-of-a-kind-tie-goes-to-highest-ranked-triplet
  (is (f ["2S 2H 2C 8D JH"
          "4S AH AS 8C AD"]
         ["4S AH AS 8C AD"])))

(deftest with-multiple-decks-two-players-can-have-same-three-of-a-kind-ties-go-to-highest-remaining-cards
  (is (f ["4S AH AS 7C AD"
          "4S AH AS 8C AD"]
         ["4S AH AS 8C AD"])))

(deftest a-straight-beats-three-of-a-kind
  (is (f ["4S 5H 4C 8D 4H"
          "3S 4D 2S 6D 5C"]
         ["3S 4D 2S 6D 5C"])))

(deftest aces-can-end-a-straight-10-J-Q-K-A
  (is (f ["4S 5H 4C 8D 4H"
          "10D JH QS KD AC"]
         ["10D JH QS KD AC"])))

(deftest aces-can-start-a-straight-A-2-3-4-5
  (is (f ["4S 5H 4C 8D 4H"
          "4D AH 3S 2D 5C"]
         ["4D AH 3S 2D 5C"])))

(deftest both-hands-with-a-straight-tie-goes-to-highest-ranked-card
  (is (f ["4S 6C 7S 8D 5H"
          "5S 7H 8S 9D 6H"]
         ["5S 7H 8S 9D 6H"])))

(deftest even-though-an-ace-is-usually-high-a-5-high-straight-is-the-lowest-scoring-straight
  (is (f ["2H 3C 4D 5D 6H"
          "4S AH 3S 2D 5H"]
         ["2H 3C 4D 5D 6H"])))

(deftest flush-beats-a-straight
  (is (f ["4C 6H 7D 8D 5H"
          "2S 4S 5S 6S 7S"]
         ["2S 4S 5S 6S 7S"])))

(deftest both-hands-have-a-flush-tie-goes-to-high-card-down-to-the-last-one-if-necessary
  (is (f ["4H 7H 8H 9H 6H"
          "2S 4S 5S 6S 7S"]
         ["4H 7H 8H 9H 6H"])))

(deftest full-house-beats-a-flush
  (is (f ["3H 6H 7H 8H 5H"
          "4S 5H 4C 5D 4H"]
         ["4S 5H 4C 5D 4H"])))

(deftest both-hands-have-a-full-house-tie-goes-to-highest-ranked-triplet
  (is (f ["4H 4S 4D 9S 9D"
          "5H 5S 5D 8S 8D"]
         ["5H 5S 5D 8S 8D"])))

(deftest with-multiple-decks-both-hands-have-a-full-house-with-the-same-triplet-tie-goes-to-the-pair
  (is (f ["5H 5S 5D 9S 9D"
          "5H 5S 5D 8S 8D"]
         ["5H 5S 5D 9S 9D"])))

(deftest four-of-a-kind-beats-a-full-house
  (is (f ["4S 5H 4D 5D 4H"
          "3S 3H 2S 3D 3C"]
         ["3S 3H 2S 3D 3C"])))

(deftest both-hands-have-four-of-a-kind-tie-goes-to-high-quad
  (is (f ["2S 2H 2C 8D 2D"
          "4S 5H 5S 5D 5C"]
         ["4S 5H 5S 5D 5C"])))

(deftest with-multiple-decks-both-hands-with-identical-four-of-a-kind-tie-determined-by-kicker
  (is (f ["3S 3H 2S 3D 3C"
          "3S 3H 4S 3D 3C"]
         ["3S 3H 4S 3D 3C"])))

(deftest straight-flush-beats-four-of-a-kind
  (is (f ["4S 5H 5S 5D 5C"
          "7S 8S 9S 6S 10S"]
         ["7S 8S 9S 6S 10S"])))

(deftest both-hands-have-straight-flush-tie-goes-to-highest-ranked-card
  (is (f ["4H 6H 7H 8H 5H"
          "5S 7S 8S 9S 6S"]
         ["5S 7S 8S 9S 6S"])))
