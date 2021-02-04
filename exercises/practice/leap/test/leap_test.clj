(ns leap-test
  (:require [clojure.test :refer [deftest is]]
            leap))

(deftest year-not-divisible-by-4
  (is (not (leap/leap-year? 2015))))

(deftest year-divisible-by-2-but-not-4
  (is (not (leap/leap-year? 1970))))

(deftest year-divisible-by-4-but-not-100
  (is (leap/leap-year? 1996)))

(deftest year-divisible-by-4-and-5
  (is (leap/leap-year? 1960)))

(deftest year-divisible-by-100-but-not-400
  (is (not (leap/leap-year? 2100))))

(deftest year-divisible-by-100-but-not-by-3
  (is (not (leap/leap-year? 1900))))

(deftest year-divisible-by-400
  (is (leap/leap-year? 2000)))

(deftest year-divisible-by-400-but-not-125
  (is (leap/leap-year? 2400)))

(deftest year-divisible-by-200-but-not-by-400
  (is (not (leap/leap-year? 1800))))
