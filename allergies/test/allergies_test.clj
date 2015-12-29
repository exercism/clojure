(ns allergies-test
  (:require [clojure.test :refer [deftest is]]
            allergies))

(deftest no-allergies-at-all
  (is (= [] (allergies/allergies 0))))

(deftest allergic-to-just-eggs
  (is (= [:eggs] (allergies/allergies 1))))

(deftest allergic-to-just-peanuts
  (is (= [:peanuts] (allergies/allergies 2))))

(deftest allergic-to-just-strawberries
  (is (= [:strawberries] (allergies/allergies 8))))

(deftest allergic-to-eggs-and-peanuts
  (is (= [:eggs :peanuts] (allergies/allergies 3))))

(deftest allergic-to-more-than-eggs-but-not-peanuts
  (is (= [:eggs :shellfish] (allergies/allergies 5))))

(deftest allergic-to-lots-of-stuff
  (is (= [:strawberries :tomatoes :chocolate :pollen :cats]
         (allergies/allergies 248))))

(deftest allergic-to-everything
  (is (= [:eggs :peanuts :shellfish :strawberries
          :tomatoes :chocolate :pollen :cats]
         (allergies/allergies 255))))

(deftest no-allergies-means-not-allergic
  (is (not (allergies/allergic-to? 0 :peanuts)))
  (is (not (allergies/allergic-to? 0 :cats)))
  (is (not (allergies/allergic-to? 0 :strawberries))))

(deftest is-allergic-to-eggs
  (is (allergies/allergic-to? 1 :eggs)))

(deftest allergic-to-eggs-in-addition-to-other-stuff
  (is (allergies/allergic-to? 5 :eggs)))

(deftest ignore-non-allergen-score-parts
  (is (= [:eggs :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
         (allergies/allergies 509))))
