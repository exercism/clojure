(ns strain-test
  (:require [clojure.test :refer [deftest is]]
            [strain :refer [retain discard]]))

(defn- fn-throw-exception [msg] (fn [& _] (throw (Exception. msg))))

(deftest empty-sequence
  (is (empty? (retain even? '()))))

(deftest empty-retain
  (is (empty? (retain odd? [2 4 6 8 10]))))

(deftest retain-single-element
  (is (= [0] (retain even? [0]))))

(deftest retain-several
  (is (= [1 3 5] (retain odd? (range 6)))))

(deftest retain-everything
  (is (= [2 4 6 8 10] (retain even? [2 4 6 8 10]))))

(deftest retain-strings
  (is (= ["string" "three"] (retain string? ["string" 1 :two "three" ["4"]]))))

(deftest empty-discard
  (is (empty? (discard even? [2 4 6 8 10]))))

(deftest discard-first
  (is (= [1 2] (discard zero? [0 1 2]))))

(deftest discard-last
  (is (= [2 1] (discard zero? [2 1 0]))))

(deftest discard-several
  (is (= [0 2 4] (discard odd? (range 6)))))

(deftest does-not-use-existing-implementations
  (with-redefs [filter  (fn-throw-exception "Implement without filter!")
                remove  (fn-throw-exception "Implement without remove!")
                filterv (fn-throw-exception "Implement without filterv!")]
    (dorun (retain even? (range 10)))
    (dorun (discard even? (range 10)))))
