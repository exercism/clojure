(ns dnd-character-test
  (:require [clojure.test :refer [deftest testing is]]
            dnd-character))

(deftest score-modifier_test_1
  (testing "ability modifier for score 3 is -4"
    (is (= -4 (dnd-character/score-modifier 3)))))

(deftest score-modifier_test_2
  (testing "ability modifier for score 4 is -3"
    (is (= -3 (dnd-character/score-modifier 4)))))

(deftest score-modifier_test_3
  (testing "ability modifier for score 5 is -3"
    (is (= -3 (dnd-character/score-modifier 5)))))

(deftest score-modifier_test_4
  (testing "ability modifier for score 6 is -2"
    (is (= -2 (dnd-character/score-modifier 6)))))

(deftest score-modifier_test_5
  (testing "ability modifier for score 7 is -2"
    (is (= -2 (dnd-character/score-modifier 7)))))

(deftest score-modifier_test_6
  (testing "ability modifier for score 8 is -1"
    (is (= -1 (dnd-character/score-modifier 8)))))

(deftest score-modifier_test_7
  (testing "ability modifier for score 9 is -1"
    (is (= -1 (dnd-character/score-modifier 9)))))

(deftest score-modifier_test_8
  (testing "ability modifier for score 10 is 0"
    (is (= 0 (dnd-character/score-modifier 10)))))

(deftest score-modifier_test_9
  (testing "ability modifier for score 11 is 0"
    (is (= 0 (dnd-character/score-modifier 11)))))

(deftest score-modifier_test_10
  (testing "ability modifier for score 12 is +1"
    (is (= 1 (dnd-character/score-modifier 12)))))

(deftest score-modifier_test_11
  (testing "ability modifier for score 13 is +1"
    (is (= 1 (dnd-character/score-modifier 13)))))

(deftest score-modifier_test_12
  (testing "ability modifier for score 14 is +2"
    (is (= 2 (dnd-character/score-modifier 14)))))

(deftest score-modifier_test_13
  (testing "ability modifier for score 15 is +2"
    (is (= 2 (dnd-character/score-modifier 15)))))

(deftest score-modifier_test_14
  (testing "ability modifier for score 16 is +3"
    (is (= 3 (dnd-character/score-modifier 16)))))

(deftest score-modifier_test_15
  (testing "ability modifier for score 17 is +3"
    (is (= 3 (dnd-character/score-modifier 17)))))

(deftest score-modifier_test_16
  (testing "ability modifier for score 18 is +4"
    (is (= 4 (dnd-character/score-modifier 18)))))

(deftest rand-ability_test_1
  (testing "random ability is within range"
    (dotimes [_ 100]
      (is (<= 3 (dnd-character/rand-ability) 18)))))

(deftest rand-ability_test_2
  (testing "ability is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-ability)))) 5))))

(deftest rand-character_test_1
  (testing "random character is valid ▶ strength"
    (dotimes [_ 100]
      (is (<= 3 (:strength (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_2
  (testing "random character is valid ▶ dexterity"
    (dotimes [_ 100]
      (is (<= 3 (:dexterity (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_3
  (testing "random character is valid ▶ charisma"
    (dotimes [_ 100]
      (is (<= 3 (:charisma (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_4
  (testing "random character is valid ▶ wisdom"
    (dotimes [_ 100]
      (is (<= 3 (:wisdom (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_5
  (testing "random character is valid ▶ intelligence"
    (dotimes [_ 100]
      (is (<= 3 (:intelligence (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_6
  (testing "random character is valid ▶ constitution"
    (dotimes [_ 100]
      (is (<= 3 (:constitution (dnd-character/rand-character)) 18)))))

(deftest rand-character_test_7
  (testing "random character is valid ▶ hitpoints"
    (let [character (dnd-character/rand-character)
          expected (+ 10 (dnd-character/score-modifier (:constitution character)))]
      (is (= expected (:hitpoints character))))))

(deftest rand-character_test_8
  (testing "random character is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-character)))) 5))))