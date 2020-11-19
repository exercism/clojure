(ns exercism.dialing-codes-test
  (:require [clojure.test :refer [deftest testing is]]
            exercism.dialing-codes))

(deftest map-count-is-3
  (is (= 3 (count exercism.dialing-codes/countries))))

(deftest United-States-of-America-is-1
  (is (= "United States of America" (get exercism.dialing-codes/countries 1))))

(deftest Brazil-is-55
  (is (= "Brazil" (get exercism.dialing-codes/countries 55))))

(deftest India-is-55
  (is (= "India" (get exercism.dialing-codes/countries 91))))

(deftest add-country-to-empty-map-single
  (is (= 1 (count (exercism.dialing-codes/add-country {} 44 "United Kingdom")))))

(deftest add-country-to-empty-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (exercism.dialing-codes/add-country {} 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-count-is-4
  (is (= 4 (count (exercism.dialing-codes/add-country exercism.dialing-codes/countries 44 "United Kingdom")))))

(deftest add-country-to-country-map-1-is-United-States-of-America
  (is (= "United States of America" (get (exercism.dialing-codes/add-country exercism.dialing-codes/countries 44 "United Kingdom") 1))))

(deftest add-country-to-country-map-44-is-United-Kingdom
  (is (= "United Kingdom" (get (exercism.dialing-codes/add-country exercism.dialing-codes/countries 44 "United Kingdom") 44))))

(deftest add-country-to-country-map-55-is-Brazil
  (is (= "Brazil" (get (exercism.dialing-codes/add-country exercism.dialing-codes/countries 44 "United Kingdom") 55))))

(deftest add-country-to-country-map-91-is-India
  (is (= "India" (get (exercism.dialing-codes/add-country exercism.dialing-codes/countries 44 "United Kingdom") 91))))

(deftest get-country-name-from-map
  (is (= "Brazil" (exercism.dialing-codes/country-name exercism.dialing-codes/countries 55))))

(deftest get-country-name-for-non-existent-country
  (is (nil? (exercism.dialing-codes/country-name exercism.dialing-codes/countries 999))))

(deftest check-country-exists
  (is (true? (exercism.dialing-codes/code-exists? exercism.dialing-codes/countries 55))))

(deftest check-non-existent-country-exists
  (is (false? (exercism.dialing-codes/code-exists? exercism.dialing-codes/countries 999))))

(deftest update-name-in-map-count-is-3
  (is (= 3 (count (exercism.dialing-codes/update-country exercism.dialing-codes/countries 1 "les États-Unis")))))

(deftest update-name-in-map-1-is-les-Etats-Unis
  (is (= "les États-Unis" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 1 "les États-Unis") 1))))

(deftest update-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 1 "les États-Unis") 55))))

(deftest update-name-in-map-91-is-India
  (is (= "India" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 1 "les États-Unis") 91))))

(deftest update-non-existent-name-in-map-count-is-3
  (is (= 3 (count (exercism.dialing-codes/update-country exercism.dialing-codes/countries 999 "Newlands")))))

(deftest update-non-existent-name-in-map-1-is-United-States-of-America
  (is (= "United States of America" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 999 "Newlands") 1))))

(deftest update-non-existent-name-in-map-55-is-Brazil
  (is (= "Brazil" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 999 "Newlands") 55))))

(deftest update-non-existent-name-in-map-91-is-India
  (is (= "India" (get (exercism.dialing-codes/update-country exercism.dialing-codes/countries 999 "Newlands") 91))))

(deftest remove-country-from-map-count-is-2
  (is (= 2 (count (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 91)))))

(deftest remove-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 44) 1))))

(deftest remove-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 44) 55))))

(deftest remove-non-existent-country-from-map-count-is-3
  (is (= 3 (count (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 999)))))

(deftest remove-non-existent-country-from-map-1-is-United-States-of-America
  (is (= "United States of America" (get (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 999) 1))))

(deftest remove-non-existent-country-from-map-55-is-Brazil
  (is (= "Brazil" (get (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 999) 55))))

(deftest remove-non-existent-country-from-map-91-is-India
  (is (= "India" (get (exercism.dialing-codes/remove-country exercism.dialing-codes/countries 999) 91))))

(deftest longest-name
  (is (= "United States of America" (exercism.dialing-codes/longest-name exercism.dialing-codes/countries))))

(deftest longest-name-empty-map
  (is (nil? (exercism.dialing-codes/longest-name {}))))