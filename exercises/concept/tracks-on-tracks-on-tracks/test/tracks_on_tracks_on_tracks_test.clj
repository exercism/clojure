(ns tracks-on-tracks-on-tracks-test
  (:require [clojure.test :refer [deftest is]]
            tracks-on-tracks-on-tracks))

(deftest list-empty-test
  (is (= '() (tracks-on-tracks-on-tracks/new-list))))

(deftest list-add-test
  (is (= '("JavaScript" "Java" "Lisp" "Clojure")
         (-> (tracks-on-tracks-on-tracks/new-list)
              (tracks-on-tracks-on-tracks/add-language "Clojure")
              (tracks-on-tracks-on-tracks/add-language "Lisp")
              (tracks-on-tracks-on-tracks/add-language "Java")
              (tracks-on-tracks-on-tracks/add-language "JavaScript")))))

(deftest first-test
  (is (= "Lisp" (tracks-on-tracks-on-tracks/first-language '("Lisp" "Clojure")))))

(deftest list-remove-test
  (is (= '("Clojure") (tracks-on-tracks-on-tracks/remove-language '("Lisp" "Clojure")))))

(deftest list-count-test
  (is (= 3 (tracks-on-tracks-on-tracks/count-languages '("JavaScript" "Java" "Clojure")))))

(deftest learning-list-test
  (is (= 3 (tracks-on-tracks-on-tracks/learning-list))))
