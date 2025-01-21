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
    (is (<= 3 (dnd-character/rand-ability) 18))))

(deftest rand-ability_test_2
  (testing "ability is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-ability)))) 5))))

{{#test_cases.character}}
(deftest rand-character_test_{{idx}}
  (testing {{description}}
    {{#if once ~}}
    (let [character (dnd-character/rand-character)]
      (is (= ({{ability}} character) ({{ability}} character))))))
    {{else~}}
    (is (<= 3 ({{ability}} (dnd-character/rand-character)) 18))))
    {{/if~}}
{{/test_cases.character}}

(deftest rand-character_test_13
  (testing "random character is valid ▶ hitpoints"
    (let [character (dnd-character/rand-character)
          expected (+ 10 (dnd-character/score-modifier (:constitution character)))]
      (is (= expected (:hitpoints character))))))

(deftest character_test_14
  (testing "random character is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/rand-character)))) 5))))
