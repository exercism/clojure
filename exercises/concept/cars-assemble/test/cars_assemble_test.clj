(ns cars-assemble-test
  (:require cars-assemble
            [clojure.test :refer [deftest is testing]]))

(deftest ^{:task 1} production-rate-speed-0-test
  (testing "Production rate for speed 0"
    (is (= 0.0 (cars-assemble/production-rate 0)))))

(deftest ^{:task 1} production-rate-speed-1-test
  (testing "Production rate for speed 1"
    (is (= 221.0 (cars-assemble/production-rate 1)))))

(deftest ^{:task 1} production-rate-speed-4-test
  (testing "Production rate for speed 4"
    (is (= 884.0 (cars-assemble/production-rate 4)))))

(deftest ^{:task 1} production-rate-speeed-7-test
  (testing "Production rate for speed 7"
    (is (= 1392.3 (cars-assemble/production-rate 7)))))

(deftest ^{:task 1} production-rate-speed-9-test
  (testing "Production rate for speed 9"
    (is (= 1591.2 (cars-assemble/production-rate 9)))))

(deftest ^{:task 1} production-rate-speed-10-test
  (testing "Production rate for speed 10"
    (is (= 1701.7 (cars-assemble/production-rate 10)))))

(deftest ^{:task 2} working-items-speed-0-test
  (testing "Working items for speed 0"
    (is (= 0 (cars-assemble/working-items 0)))))

(deftest ^{:task 2} working-items-speed-1-test
  (testing "Working items for speed 1"
    (is (= 3 (cars-assemble/working-items 1)))))

(deftest ^{:task 2} working-items-speed-5-test
  (testing "Working items for speed 5"
    (is (= 16 (cars-assemble/working-items 5)))))

(deftest ^{:task 2} working-items-speed-8-test
  (testing "Working items for speed 8"
    (is (= 26 (cars-assemble/working-items 8)))))

(deftest ^{:task 2} working-items-speed-9-test
  (testing "Working items for speed 9"
    (is (= 26 (cars-assemble/working-items 9)))))

(deftest ^{:task 2} working-items-speed-10-test
  (testing "Working items for speed 10"
    (is (= 28 (cars-assemble/working-items 10)))))
