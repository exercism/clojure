(ns binary-search-test
  (:require [clojure.test :refer [deftest is]]
            binary-search))

(def short-vector [1, 3, 4, 6, 8, 9, 11])

(def large-vector [1, 3, 5, 8, 13, 21, 34, 55, 89])

(def even-length-vector [1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377])

(deftest it-finds-position-of-middle-item
  (is (= 3 (binary-search/middle short-vector))))

(deftest searches-a-singleton
  (is (= 0 (binary-search/search-for 4 [4]))))

(deftest it-finds-position-of-search-data
  (is (= 5 (binary-search/search-for 9 short-vector))))

(deftest it-finds-position-in-a-larger-list
  (is (= 1 (binary-search/search-for 3 large-vector))))

(deftest it-finds-position-in-a-larger-list-again
  (is (= 7 (binary-search/search-for 55 large-vector))))

(deftest it-finds-correct-position-in-a-list-with-an-even-number-of-elements
  (is (= 5 (binary-search/search-for 21 even-length-vector))))

(deftest it-finds-correct-position-in-a-list-with-an-even-number-of-elements-again
  (is (= 6 (binary-search/search-for 34 even-length-vector))))

(deftest it-works-on-lists
  (is (= 7 (binary-search/search-for 7 (range 10)))))

(deftest it-works-on-lists-again
  (is (= 4 (binary-search/search-for 3 '(-3 -2 0 1 3 4)))))

(deftest throws-exception-when-element-not-found
  (is (thrown-with-msg? Throwable #"not found"
        (binary-search/search-for 20 short-vector))))
