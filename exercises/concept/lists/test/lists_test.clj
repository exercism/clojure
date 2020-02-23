(ns lists-test
  (:require [clojure.test :refer [deftest is]]
            lists))

(deftest list-empty-test
  (is (= '() (lists/new-list))))

(deftest list-add-test
  (is (= '("JavaScript" "Java" "Lisp" "Clojure")
         (->> (lists/new-list)
              (lists/add-language "Clojure")
              (lists/add-language "Lisp")
              (lists/add-language "Java")
              (lists/add-language "JavaScript")))))

(deftest first-test
  (is (= "Lisp" (lists/first-language '("Lisp" "Clojure")))))

(deftest list-remove-test
  (is (= '("Clojure") (lists/remove-language '("Lisp" "Clojure")))))

(deftest list-count-test
  (is (= 3 (lists/count-languages '("JavaScript" "Java" "Clojure")))))

(deftest list-count-test
  (is (= 3 (lists/learning-list))))

