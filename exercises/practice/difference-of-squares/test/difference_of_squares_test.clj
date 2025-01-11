(ns difference-of-squares-test
  (:require [clojure.test :refer [deftest is]]
            [difference-of-squares :as dos]))

(deftest square-of-sum-to-5
  (is (= 225 (dos/square-of-sum 5))))

(deftest sum-of-squares-to-5
  (is (= 55 (dos/sum-of-squares 5))))

(deftest difference-of-squares-to-5
  (is (= 170 (dos/difference 5))))

(deftest square-of-sum-to-10
  (is (= 3025 (dos/square-of-sum 10))))

(deftest sum-of-squares-to-10
  (is (= 385 (dos/sum-of-squares 10))))

(deftest difference-of-squares-to-10
  (is (= 2640 (dos/difference 10))))

(deftest square-of-sum-to-100
  (is (= 25502500 (dos/square-of-sum 100))))

(deftest sum-of-squares-to-100
  (is (= 338350 (dos/sum-of-squares 100))))

(deftest difference-of-squares-to-100
  (is (= 25164150 (dos/difference 100))))
