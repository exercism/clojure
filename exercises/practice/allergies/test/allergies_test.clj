(ns allergies-test
  (:require [clojure.test :refer [deftest testing is]]
            allergies))

(deftest testing-for-eggs-allergy
  (testing "Testing for eggs allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :eggs))))
  (testing "Testing for eggs allergy -> allergic only to eggs"
    (is (true? (allergies/allergic-to? 1 :eggs))))
  (testing "Testing for eggs allergy -> allergic to eggs and something else"
    (is (true? (allergies/allergic-to? 3 :eggs))))
  (testing "Testing for eggs allergy -> allergic to something, but not eggs"
    (is (false? (allergies/allergic-to? 2 :eggs))))
  (testing "Testing for eggs allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :eggs)))))

(deftest testing-for-peanuts-allergy
  (testing "Testing for peanuts allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :peanuts))))
  (testing "Testing for peanuts allergy -> allergic only to peanuts"
    (is (true? (allergies/allergic-to? 2 :peanuts))))
  (testing "Testing for peanuts allergy -> allergic to peanuts and something else"
    (is (true? (allergies/allergic-to? 7 :peanuts))))
  (testing "Testing for peanuts allergy -> allergic to something, but not peanuts"
    (is (false? (allergies/allergic-to? 5 :peanuts))))
  (testing "Testing for peanuts allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :peanuts)))))

(deftest testing-for-shellfish-allergy
  (testing "Testing for shellfish allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :shellfish))))
  (testing "Testing for shellfish allergy -> allergic only to shellfish"
    (is (true? (allergies/allergic-to? 4 :shellfish))))
  (testing "Testing for shellfish allergy -> allergic to shellfish and something else"
    (is (true? (allergies/allergic-to? 14 :shellfish))))
  (testing "Testing for shellfish allergy -> allergic to something, but not shellfish"
    (is (false? (allergies/allergic-to? 10 :shellfish))))
  (testing "Testing for shellfish allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :shellfish)))))

(deftest testing-for-strawberries-allergy
  (testing "Testing for strawberries allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :strawberries))))
  (testing "Testing for strawberries allergy -> allergic only to strawberries"
    (is (true? (allergies/allergic-to? 8 :strawberries))))
  (testing "Testing for strawberries allergy -> allergic to strawberries and something else"
    (is (true? (allergies/allergic-to? 28 :strawberries))))
  (testing "Testing for strawberries allergy -> allergic to something, but not strawberries"
    (is (false? (allergies/allergic-to? 20 :strawberries))))
  (testing "Testing for strawberries allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :strawberries)))))

(deftest testing-for-tomatoes-allergy
  (testing "Testing for tomatoes allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :tomatoes))))
  (testing "Testing for tomatoes allergy -> allergic only to tomatoes"
    (is (true? (allergies/allergic-to? 16 :tomatoes))))
  (testing "Testing for tomatoes allergy -> allergic to tomatoes and something else"
    (is (true? (allergies/allergic-to? 56 :tomatoes))))
  (testing "Testing for tomatoes allergy -> allergic to something, but not tomatoes"
    (is (false? (allergies/allergic-to? 40 :tomatoes))))
  (testing "Testing for tomatoes allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :tomatoes)))))

(deftest testing-for-chocolate-allergy
  (testing "Testing for chocolate allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :chocolate))))
  (testing "Testing for chocolate allergy -> allergic only to chocolate"
    (is (true? (allergies/allergic-to? 32 :chocolate))))
  (testing "Testing for chocolate allergy -> allergic to chocolate and something else"
    (is (true? (allergies/allergic-to? 112 :chocolate))))
  (testing "Testing for chocolate allergy -> allergic to something, but not chocolate"
    (is (false? (allergies/allergic-to? 80 :chocolate))))
  (testing "Testing for chocolate allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :chocolate)))))

(deftest testing-for-pollen-allergy
  (testing "Testing for pollen allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :pollen))))
  (testing "Testing for pollen allergy -> allergic only to pollen"
    (is (true? (allergies/allergic-to? 64 :pollen))))
  (testing "Testing for pollen allergy -> allergic to pollen and something else"
    (is (true? (allergies/allergic-to? 224 :pollen))))
  (testing "Testing for pollen allergy -> allergic to something, but not pollen"
    (is (false? (allergies/allergic-to? 160 :pollen))))
  (testing "Testing for pollen allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :pollen)))))

(deftest testing-for-cats-allergy
  (testing "Testing for cats allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :cats))))
  (testing "Testing for cats allergy -> allergic only to cats"
    (is (true? (allergies/allergic-to? 128 :cats))))
  (testing "Testing for cats allergy -> allergic to cats and something else"
    (is (true? (allergies/allergic-to? 192 :cats))))
  (testing "Testing for cats allergy -> allergic to something, but not cats"
    (is (false? (allergies/allergic-to? 64 :cats))))
  (testing "Testing for cats allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :cats)))))

(deftest list-when
  (testing "List when: no allergies"
    (is (= [] (allergies/allergies 0))))
  (testing "List when: allergic to just eggs"
    (is (= [:eggs] (allergies/allergies 1))))
  (testing "List when: allergic to just peanuts"
    (is (= [:peanuts] (allergies/allergies 2))))
  (testing "List when: allergic to just strawberries"
    (is (= [:strawberries] (allergies/allergies 8))))
  (testing "List when: allergic to eggs and peanuts"
    (is (= [:eggs :peanuts] (allergies/allergies 3))))
  (testing "List when: allergic to more than eggs but not peanuts"
    (is (= [:eggs :shellfish] (allergies/allergies 5))))
  (testing "List when: allergic to lots of stuff"
    (is (= [:strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 248))))
  (testing "List when: allergic to everything"
    (is (= [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 255))))
  (testing "List when: no allergen score parts"
    (is (= [:eggs :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 509))))
  (testing "List when: no allergen score parts without highest valid score"
    (is (= [:eggs] (allergies/allergies 257)))))
