(ns space-age-test
  (:require [clojure.test :refer [deftest testing is]]
            space-age))

(defn- rounds-to
  [expected actual]
  (is (= (Math/round (* 100.0 expected))
         (Math/round (* 100.0 actual)))))

(deftest ^:on-earth on-earth_test_1
  (testing "age on Earth"
    (rounds-to 31.69 (space-age/on-earth 1000000000))))

(deftest ^:on-mercury on-mercury_test_1
  (testing "age on Mercury"
    (rounds-to 280.88 (space-age/on-mercury 2134835688))))

(deftest ^:on-venus on-venus_test_1
  (testing "age on Venus"
    (rounds-to 9.78 (space-age/on-venus 189839836))))

(deftest ^:on-mars on-mars_test_1
  (testing "age on Mars"
    (rounds-to 35.88 (space-age/on-mars 2129871239))))

(deftest ^:on-jupiter on-jupiter_test_1
  (testing "age on Jupiter"
    (rounds-to 2.41 (space-age/on-jupiter 901876382))))

(deftest ^:on-saturn on-saturn_test_1
  (testing "age on Saturn"
    (rounds-to 2.15 (space-age/on-saturn 2000000000))))

(deftest ^:on-uranus on-uranus_test_1
  (testing "age on Uranus"
    (rounds-to 0.46 (space-age/on-uranus 1210123456))))

(deftest ^:on-neptune on-neptune_test_1
  (testing "age on Neptune"
    (rounds-to 0.35 (space-age/on-neptune 1821023456))))
