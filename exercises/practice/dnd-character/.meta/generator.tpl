(ns dnd-character-test
  (:require [clojure.test :refer [deftest testing is]]
            dnd-character))

{{#test_cases.modifier}}
(deftest score-modifier_test_{{idx}}
  (testing {{description}}
    (is (= {{expected}} (dnd-character/score-modifier {{input.score}})))))
{{/test_cases.modifier}}

(deftest rand-ability_test_1
  (testing "random ability is within range"
    (dotimes [_ 100]
      (is (<= 3 (dnd-character/rand-ability) 18)))))

(deftest rand-ability_test_2
  (testing "ability is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-ability)))) 5))))

{{#test_cases.character}}
(deftest rand-character_test_{{idx}}
  (testing {{description}}
    (dotimes [_ 100]
      (is (<= 3 ({{ability}} (dnd-character/rand-character)) 18)))))
{{/test_cases.character}}

(deftest rand-character_test_7
  (testing "random character is valid ▶ hitpoints"
    (let [character (dnd-character/rand-character)
          expected (+ 10 (dnd-character/score-modifier (:constitution character)))]
      (is (= expected (:hitpoints character))))))

(deftest rand-character_test_8
  (testing "random character is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-character)))) 5))))
