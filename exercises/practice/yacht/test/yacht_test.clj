(ns yacht-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
             yacht))

(deftest score-test
  (testing "Yacht"
     (is (= 50 (yacht/score [5 5 5 5 5] "yacht"))))
  (testing "Not Yacht"
     (is (= 0 (yacht/score [1 3 3 2 5] "yacht"))))
  (testing "Ones"
     (is (= 3 (yacht/score [1 1 1 3 5] "ones"))))
  (testing "Ones, out of order"
     (is (= 3 (yacht/score [3 1 1 5 1] "ones"))))
  (testing "No ones"
     (is (= 0 (yacht/score [4 3 6 5 5] "ones"))))
  (testing "Twos"
     (is (= 2 (yacht/score [2 3 4 5 6] "twos"))))
  (testing "Fours"
     (is (= 8 (yacht/score [1 4 1 4 1] "fours"))))
  (testing "Yacht counted as threes"
     (is (= 15 (yacht/score [3 3 3 3 3] "threes"))))
  (testing "Yacht of 3s counted as fives"
     (is (= 0 (yacht/score [3 3 3 3 3] "fives"))))
  (testing "Fives"
     (is (= 10 (yacht/score [1 5 3 5 3] "fives"))))
  (testing "Sixes"
     (is (= 6 (yacht/score [2 3 4 5 6] "sixes"))))
  (testing "Full house two small, three big"
     (is (= 16 (yacht/score [2 2 4 4 4] "full house"))))
  (testing "Full house three small, two big"
     (is (= 19 (yacht/score [5 3 3 5 3] "full house"))))
  (testing "Two pair is not a full house"
     (is (= 0 (yacht/score [2 2 4 4 5] "full house"))))
  (testing "Four of a kind is not a full house"
     (is (= 0 (yacht/score [1 4 4 4 4] "full house"))))
  (testing "Yacht is not a full house"
     (is (= 0 (yacht/score [2 2 2 2 2] "full house"))))
  (testing "Four of a Kind"
     (is (= 24 (yacht/score [6 6 4 6 6] "four of a kind"))))
  (testing "Yacht can be scored as Four of a Kind"
     (is (= 12 (yacht/score [3 3 3 3 3] "four of a kind"))))
  (testing "Full house is not Four of a Kind"
     (is (= 0 (yacht/score [3 3 3 5 5] "four of a kind"))))
  (testing "Little Straight"
     (is (= 30 (yacht/score [3 5 4 1 2] "little straight"))))
  (testing "Little Straight as Big Straight"
     (is (= 0 (yacht/score [1 2 3 4 5] "big straight"))))
  (testing "Four in order but not a little straight"
     (is (= 0 (yacht/score [1 1 2 3 4] "little straight"))))
  (testing "No pairs but not a little straight"
     (is (= 0 (yacht/score [1 2 3 4 6] "little straight"))))
  (testing "Minimum is 1, maximum is 5, but not a little straight"
     (is (= 0 (yacht/score [1 1 3 4 5] "little straight"))))
  (testing "Big Straight"
     (is (= 30 (yacht/score [4 6 2 5 3] "big straight"))))
  (testing "Big Straight as little straight"
     (is (= 0 (yacht/score [6 5 4 3 2] "little straight"))))
  (testing "No pairs but not a big straight"
     (is (= 0 (yacht/score [6 5 4 3 1] "big straight"))))
  (testing "Choice"
     (is (= 23 (yacht/score [3 3 5 6 6] "choice"))))
  (testing "Yacht as choice"
     (is (= 10 (yacht/score [2 2 2 2 2] "choice")))))

(comment
  (run-tests)
  )