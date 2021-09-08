(ns dialing-codes-test
  (:require [clojure.test :refer [deftest testing is]]
            dialing-codes))

(deftest map-count-is-3
  (is (= 3 (count dialing-codes/countries))))

(deftest United-States-of-America-is-1
  (is (= "United States of America" (get dialing-codes/countries 1))))

(deftest Brazil-is-55
  (is (= "Brazil" (get dialing-codes/countries 55))))

(deftest India-is-55
  (is (= "India" (get dialing-codes/countries 91))))

(deftest add-country-to-empty-map-single
  (is (= 1 (count (dialing-codes/add-country {} 44 "United Kingdom")))))

(deftest add-country-to-empty-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (dialing-codes/add-country {} 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-count-is-4
  (is (= 4 (count (dialing-codes/add-country dialing-codes/countries 44 "United Kingdom")))))

(deftest add-country-to-country-map-1-is-United-States-of-America
  (is (= "United States of America" (get (dialing-codes/add-country dialing-codes/countries 44 "United Kingdom") 1))))

(deftest add-country-to-country-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (dialing-codes/add-country dialing-codes/countries 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-55-is-Brazil
  (is (= "Brazil" (get (dialing-codes/add-country dialing-codes/countries 44 "United Kingdom") 55))))

(deftest add-country-to-country-map-91-is-India
  (is (= "India" (get (dialing-codes/add-country dialing-codes/countries 44 "United Kingdom") 91))))

(deftest get-country-name-from-map
  (is (= "Brazil" (dialing-codes/country-name dialing-codes/countries 55))))

(deftest get-country-name-for-non-existent-country
  (is (nil? (dialing-codes/country-name dialing-codes/countries 999))))

(deftest check-country-exists
  (is (true? (dialing-codes/code-exists? dialing-codes/countries 55))))

(deftest check-non-existent-country-exists
  (is (false? (dialing-codes/code-exists? dialing-codes/countries 999))))

(deftest update-name-in-map-count-is-3
  (is (= 3 (count (dialing-codes/update-country dialing-codes/countries 1 "les États-Unis")))))

(deftest update-name-in-map-1-is-les-Etats-Unis
  (is (= "les États-Unis" (get (dialing-codes/update-country dialing-codes/countries 1 "les États-Unis") 1))))

(deftest update-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (dialing-codes/update-country dialing-codes/countries 1 "les États-Unis") 55))))

(deftest update-name-in-map-91-is-India
  (is (= "India" (get (dialing-codes/update-country dialing-codes/countries 1 "les États-Unis") 91))))

(deftest update-non-existent-name-in-map-count-is-3
  (is (= 3 (count (dialing-codes/update-country dialing-codes/countries 999 "Newlands")))))

(deftest update-non-existent-name-in-map-1-is-United-States-of-America
  (is (= "United States of America" (get (dialing-codes/update-country dialing-codes/countries 999 "Newlands") 1))))

(deftest update-non-existent-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (dialing-codes/update-country dialing-codes/countries 999 "Newlands") 55))))

(deftest update-non-existent-name-in-map-91-is-India
  (is (= "India" (get (dialing-codes/update-country dialing-codes/countries 999 "Newlands") 91))))

(deftest remove-country-from-map-count-is-2
  (is (= 2 (count (dialing-codes/remove-country dialing-codes/countries 91)))))

(deftest remove-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (dialing-codes/remove-country dialing-codes/countries 44) 1))))

(deftest remove-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (dialing-codes/remove-country dialing-codes/countries 44) 55))))

(deftest remove-non-existent-country-from-map-count-is-3
  (is (= 3 (count (dialing-codes/remove-country dialing-codes/countries 999)))))

(deftest remove-non-existent-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (dialing-codes/remove-country dialing-codes/countries 999) 1))))

(deftest remove-non-existent-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (dialing-codes/remove-country dialing-codes/countries 999) 55))))

(deftest remove-non-existent-country-from-map-91-is-India
  (is (= "India" (get (dialing-codes/remove-country dialing-codes/countries 999) 91))))

(deftest longest-name
  (is (= "United States of America" (dialing-codes/longest-name dialing-codes/countries))))

(deftest longest-name-empty-map
  (is (nil? (dialing-codes/longest-name {}))))