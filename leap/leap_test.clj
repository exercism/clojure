(ns leap-test
  (:require [clojure.test :refer :all]))

(load-file "leap.clj")

(deftest vanilla-leap-year
  (is (leap/leap-year? 1996)))

(deftest any-old-year
  (is (not (leap/leap-year? 1997))))

(deftest century
  (is (not (leap/leap-year? 1900))))

(deftest exceptional-century
  (is (leap/leap-year? 2400)))

(run-tests)
