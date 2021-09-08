(ns international-calling-connoisseur-test
  (:require [clojure.test :refer [deftest testing is]]
            international-calling-connoisseur))

(deftest map-count-is-3
  (is (= 3 (count international-calling-connoisseur/countries))))

(deftest United-States-of-America-is-1
  (is (= "United States of America" (get international-calling-connoisseur/countries 1))))

(deftest Brazil-is-55
  (is (= "Brazil" (get international-calling-connoisseur/countries 55))))

(deftest India-is-55
  (is (= "India" (get international-calling-connoisseur/countries 91))))

(deftest add-country-to-empty-map-single
  (is (= 1 (count (international-calling-connoisseur/add-country {} 44 "United Kingdom")))))

(deftest add-country-to-empty-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (international-calling-connoisseur/add-country {} 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-count-is-4
  (is (= 4 (count (international-calling-connoisseur/add-country international-calling-connoisseur/countries 44 "United Kingdom")))))

(deftest add-country-to-country-map-1-is-United-States-of-America
  (is (= "United States of America" (get (international-calling-connoisseur/add-country international-calling-connoisseur/countries 44 "United Kingdom") 1))))

(deftest add-country-to-country-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (international-calling-connoisseur/add-country international-calling-connoisseur/countries 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-55-is-Brazil
  (is (= "Brazil" (get (international-calling-connoisseur/add-country international-calling-connoisseur/countries 44 "United Kingdom") 55))))

(deftest add-country-to-country-map-91-is-India
  (is (= "India" (get (international-calling-connoisseur/add-country international-calling-connoisseur/countries 44 "United Kingdom") 91))))

(deftest get-country-name-from-map
  (is (= "Brazil" (international-calling-connoisseur/country-name international-calling-connoisseur/countries 55))))

(deftest get-country-name-for-non-existent-country
  (is (nil? (international-calling-connoisseur/country-name international-calling-connoisseur/countries 999))))

(deftest check-country-exists
  (is (true? (international-calling-connoisseur/code-exists? international-calling-connoisseur/countries 55))))

(deftest check-non-existent-country-exists
  (is (false? (international-calling-connoisseur/code-exists? international-calling-connoisseur/countries 999))))

(deftest update-name-in-map-count-is-3
  (is (= 3 (count (international-calling-connoisseur/update-country international-calling-connoisseur/countries 1 "les États-Unis")))))

(deftest update-name-in-map-1-is-les-Etats-Unis
  (is (= "les États-Unis" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 1 "les États-Unis") 1))))

(deftest update-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 1 "les États-Unis") 55))))

(deftest update-name-in-map-91-is-India
  (is (= "India" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 1 "les États-Unis") 91))))

(deftest update-non-existent-name-in-map-count-is-3
  (is (= 3 (count (international-calling-connoisseur/update-country international-calling-connoisseur/countries 999 "Newlands")))))

(deftest update-non-existent-name-in-map-1-is-United-States-of-America
  (is (= "United States of America" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 999 "Newlands") 1))))

(deftest update-non-existent-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 999 "Newlands") 55))))

(deftest update-non-existent-name-in-map-91-is-India
  (is (= "India" (get (international-calling-connoisseur/update-country international-calling-connoisseur/countries 999 "Newlands") 91))))

(deftest remove-country-from-map-count-is-2
  (is (= 2 (count (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 91)))))

(deftest remove-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 44) 1))))

(deftest remove-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 44) 55))))

(deftest remove-non-existent-country-from-map-count-is-3
  (is (= 3 (count (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 999)))))

(deftest remove-non-existent-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 999) 1))))

(deftest remove-non-existent-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 999) 55))))

(deftest remove-non-existent-country-from-map-91-is-India
  (is (= "India" (get (international-calling-connoisseur/remove-country international-calling-connoisseur/countries 999) 91))))

(deftest longest-name
  (is (= "United States of America" (international-calling-connoisseur/longest-name international-calling-connoisseur/countries))))

(deftest longest-name-empty-map
  (is (nil? (international-calling-connoisseur/longest-name {}))))