(ns allergies-test
  (:require [clojure.test :refer [deftest testing is]]
            allergies))

(deftest allergic-to?_test_1
  (testing "testing for eggs allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :eggs)))))

(deftest allergic-to?_test_2
  (testing "testing for eggs allergy -> allergic only to eggs"
    (is (true? (allergies/allergic-to? 1 :eggs)))))

(deftest allergic-to?_test_3
  (testing "testing for eggs allergy -> allergic to eggs and something else"
    (is (true? (allergies/allergic-to? 3 :eggs)))))

(deftest allergic-to?_test_4
  (testing "testing for eggs allergy -> allergic to something, but not eggs"
    (is (false? (allergies/allergic-to? 2 :eggs)))))

(deftest allergic-to?_test_5
  (testing "testing for eggs allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :eggs)))))

(deftest allergic-to?_test_6
  (testing "testing for peanuts allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :peanuts)))))

(deftest allergic-to?_test_7
  (testing "testing for peanuts allergy -> allergic only to peanuts"
    (is (true? (allergies/allergic-to? 2 :peanuts)))))

(deftest allergic-to?_test_8
  (testing "testing for peanuts allergy -> allergic to peanuts and something else"
    (is (true? (allergies/allergic-to? 7 :peanuts)))))

(deftest allergic-to?_test_9
  (testing "testing for peanuts allergy -> allergic to something, but not peanuts"
    (is (false? (allergies/allergic-to? 5 :peanuts)))))

(deftest allergic-to?_test_10
  (testing "testing for peanuts allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :peanuts)))))

(deftest allergic-to?_test_11
  (testing "testing for shellfish allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :shellfish)))))

(deftest allergic-to?_test_12
  (testing "testing for shellfish allergy -> allergic only to shellfish"
    (is (true? (allergies/allergic-to? 4 :shellfish)))))

(deftest allergic-to?_test_13
  (testing "testing for shellfish allergy -> allergic to shellfish and something else"
    (is (true? (allergies/allergic-to? 14 :shellfish)))))

(deftest allergic-to?_test_14
  (testing "testing for shellfish allergy -> allergic to something, but not shellfish"
    (is (false? (allergies/allergic-to? 10 :shellfish)))))

(deftest allergic-to?_test_15
  (testing "testing for shellfish allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :shellfish)))))

(deftest allergic-to?_test_16
  (testing "testing for strawberries allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :strawberries)))))

(deftest allergic-to?_test_17
  (testing "testing for strawberries allergy -> allergic only to strawberries"
    (is (true? (allergies/allergic-to? 8 :strawberries)))))

(deftest allergic-to?_test_18
  (testing "testing for strawberries allergy -> allergic to strawberries and something else"
    (is (true? (allergies/allergic-to? 28 :strawberries)))))

(deftest allergic-to?_test_19
  (testing "testing for strawberries allergy -> allergic to something, but not strawberries"
    (is (false? (allergies/allergic-to? 20 :strawberries)))))

(deftest allergic-to?_test_20
  (testing "testing for strawberries allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :strawberries)))))

(deftest allergic-to?_test_21
  (testing "testing for tomatoes allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :tomatoes)))))

(deftest allergic-to?_test_22
  (testing "testing for tomatoes allergy -> allergic only to tomatoes"
    (is (true? (allergies/allergic-to? 16 :tomatoes)))))

(deftest allergic-to?_test_23
  (testing "testing for tomatoes allergy -> allergic to tomatoes and something else"
    (is (true? (allergies/allergic-to? 56 :tomatoes)))))

(deftest allergic-to?_test_24
  (testing "testing for tomatoes allergy -> allergic to something, but not tomatoes"
    (is (false? (allergies/allergic-to? 40 :tomatoes)))))

(deftest allergic-to?_test_25
  (testing "testing for tomatoes allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :tomatoes)))))

(deftest allergic-to?_test_26
  (testing "testing for chocolate allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :chocolate)))))

(deftest allergic-to?_test_27
  (testing "testing for chocolate allergy -> allergic only to chocolate"
    (is (true? (allergies/allergic-to? 32 :chocolate)))))

(deftest allergic-to?_test_28
  (testing "testing for chocolate allergy -> allergic to chocolate and something else"
    (is (true? (allergies/allergic-to? 112 :chocolate)))))

(deftest allergic-to?_test_29
  (testing "testing for chocolate allergy -> allergic to something, but not chocolate"
    (is (false? (allergies/allergic-to? 80 :chocolate)))))

(deftest allergic-to?_test_30
  (testing "testing for chocolate allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :chocolate)))))

(deftest allergic-to?_test_31
  (testing "testing for pollen allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :pollen)))))

(deftest allergic-to?_test_32
  (testing "testing for pollen allergy -> allergic only to pollen"
    (is (true? (allergies/allergic-to? 64 :pollen)))))

(deftest allergic-to?_test_33
  (testing "testing for pollen allergy -> allergic to pollen and something else"
    (is (true? (allergies/allergic-to? 224 :pollen)))))

(deftest allergic-to?_test_34
  (testing "testing for pollen allergy -> allergic to something, but not pollen"
    (is (false? (allergies/allergic-to? 160 :pollen)))))

(deftest allergic-to?_test_35
  (testing "testing for pollen allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :pollen)))))

(deftest allergic-to?_test_36
  (testing "testing for cats allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :cats)))))

(deftest allergic-to?_test_37
  (testing "testing for cats allergy -> allergic only to cats"
    (is (true? (allergies/allergic-to? 128 :cats)))))

(deftest allergic-to?_test_38
  (testing "testing for cats allergy -> allergic to cats and something else"
    (is (true? (allergies/allergic-to? 192 :cats)))))

(deftest allergic-to?_test_39
  (testing "testing for cats allergy -> allergic to something, but not cats"
    (is (false? (allergies/allergic-to? 64 :cats)))))

(deftest allergic-to?_test_40
  (testing "testing for cats allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :cats)))))

(deftest allergies_test_1
  (testing "list when: -> no allergies"
    (is (= []
           (allergies/allergies 0)))))

(deftest allergies_test_2
  (testing "list when: -> just eggs"
    (is (= [:eggs]
           (allergies/allergies 1)))))

(deftest allergies_test_3
  (testing "list when: -> just peanuts"
    (is (= [:peanuts]
           (allergies/allergies 2)))))

(deftest allergies_test_4
  (testing "list when: -> just strawberries"
    (is (= [:strawberries]
           (allergies/allergies 8)))))

(deftest allergies_test_5
  (testing "list when: -> eggs and peanuts"
    (is (= [:eggs :peanuts]
           (allergies/allergies 3)))))

(deftest allergies_test_6
  (testing "list when: -> more than eggs but not peanuts"
    (is (= [:eggs :shellfish]
           (allergies/allergies 5)))))

(deftest allergies_test_7
  (testing "list when: -> lots of stuff"
    (is (= [:strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 248)))))

(deftest allergies_test_8
  (testing "list when: -> everything"
    (is (= [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 255)))))

(deftest allergies_test_9
  (testing "list when: -> no allergen score parts"
    (is (= [:eggs :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 509)))))

(deftest allergies_test_10
  (testing "list when: -> no allergen score parts without highest valid score"
    (is (= [:eggs]
           (allergies/allergies 257)))))
