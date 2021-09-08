(ns languages-test
  (:require [clojure.test :refer [deftest is]]
            languages))

(deftest list-empty-test
  (is (= '() (languages/new-list))))

(deftest list-add-test
  (is (= '("JavaScript" "Java" "Lisp" "Clojure")
         (->> (languages/new-list)
              (languages/add-language "Clojure")
              (languages/add-language "Lisp")
              (languages/add-language "Java")
              (languages/add-language "JavaScript")))))

(deftest first-test
  (is (= "Lisp" (languages/first-language '("Lisp" "Clojure")))))

(deftest list-remove-test
  (is (= '("Clojure") (languages/remove-language '("Lisp" "Clojure")))))

(deftest list-count-test
  (is (= 3 (languages/count-languages '("JavaScript" "Java" "Clojure")))))
