(ns leap-test
  (:require [clojure.test :refer [deftest testing is]]
            leap))

(deftest leap-year?_test_1
  (testing "year not divisible by 4 in common year"
    (is (false? (leap/leap-year? 2015)))))

(deftest leap-year?_test_2
  (testing "year divisible by 2, not divisible by 4 in common year"
    (is (false? (leap/leap-year? 1970)))))

(deftest leap-year?_test_3
  (testing "year divisible by 4, not divisible by 100 in leap year"
    (is (true? (leap/leap-year? 1996)))))

(deftest leap-year?_test_4
  (testing "year divisible by 4 and 5 is still a leap year"
    (is (true? (leap/leap-year? 1960)))))

(deftest leap-year?_test_5
  (testing "year divisible by 100, not divisible by 400 in common year"
    (is (false? (leap/leap-year? 2100)))))

(deftest leap-year?_test_6
  (testing "year divisible by 100 but not by 3 is still not a leap year"
    (is (false? (leap/leap-year? 1900)))))

(deftest leap-year?_test_7
  (testing "year divisible by 400 is leap year"
    (is (true? (leap/leap-year? 2000)))))

(deftest leap-year?_test_8
  (testing "year divisible by 400 but not by 125 is still a leap year"
    (is (true? (leap/leap-year? 2400)))))

(deftest leap-year?_test_9
  (testing "year divisible by 200, not divisible by 400 in common year"
    (is (false? (leap/leap-year? 1800)))))
