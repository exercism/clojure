(ns accumulate-test
  (:require [clojure.test :refer [deftest is]]
            accumulate))

(defn- square [n] (* n n))

(defn- to-s [xs] (apply str xs))

(deftest empty-accumulation
  (is (= [] (accumulate/accumulate square []))))

(deftest accumulate-squares
  (is (= [1 4 9] (accumulate/accumulate square [1 2 3]))))

(deftest accumulate-upcases
  (is (= ["HELLO", "WORLD"]
         (->> ["hello" "world"]
              (accumulate/accumulate clojure.string/upper-case)
              (map to-s)))))

(deftest accumulate-reversed-strings
  (is (= ["eht" "kciuq" "nworb" "xof" "cte"]
         (->> ["the" "quick" "brown" "fox" "etc"]
              (accumulate/accumulate reverse)
              (map to-s)))))

(deftest accumulate-recursively
  (is (= [["a1" "a2" "a3"] ["b1" "b2" "b3"] ["c1" "c2" "c3"]]
         (-> #(accumulate/accumulate (fn [n] (str % n)) [1 2 3])
             (accumulate/accumulate "abc")))))
