(ns strain-test
  (:refer-clojure :exclude [keep])
  (:require [strain :refer [keep discard]]
            [clojure.test :refer :all]))

(deftest empty-sequence
  (is (empty? (keep even? '()))))

(deftest empty-keep
  (is (empty? (keep odd? [2 4 6 8 10]))))

(deftest keep-single-element
  (is (= [0] (keep even? [0]))))

(deftest keep-several
  (is (= [1 3 5] (keep odd? (range 6)))))

(deftest keep-everything
  (is (= [2 4 6 8 10] (keep even? [2 4 6 8 10]))))

(deftest keep-strings
  (is (= ["string" "three"] (keep string? ["string" 1 :two "three" ["4"]]))))

(deftest empty-discard
  (is (empty? (discard even? [2 4 6 8 10]))))

(deftest discard-first
  (is (= [1 2] (discard zero? [0 1 2]))))

(deftest discard-last
  (is (= [2 1] (discard zero? [2 1 0]))))

(deftest discard-several
  (is (= [0 2 4] (discard odd? (range 6)))))

(deftest doesn't-use-existing-implementations
  (with-redefs [filter (fn [& _] (throw (Exception. "Implement without filter!")))
                remove (fn [& _] (throw (Exception. "Implement without remove!")))
                filterv (fn [& _] (throw (Exception. "Implement without filterv!")))]
    (dorun (keep even? (range 10)))
    (dorun (discard even? (range 10)))))
