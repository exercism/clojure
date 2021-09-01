(ns exercism.languages-test
  (:require [clojure.test :refer [deftest is]]
            exercism.languages))

(deftest list-empty-test
  (is (= '() (exercism.languages/new-list))))

(deftest list-add-test
  (is (= '("JavaScript" "Java" "Lisp" "Clojure")
         (->> (exercism.languages/new-list)
              (exercism.languages/add-language "Clojure")
              (exercism.languages/add-language "Lisp")
              (exercism.languages/add-language "Java")
              (exercism.languages/add-language "JavaScript")))))

(deftest first-test
  (is (= "Lisp" (exercism.languages/first-language '("Lisp" "Clojure")))))

(deftest list-remove-test
  (is (= '("Clojure") (exercism.languages/remove-language '("Lisp" "Clojure")))))

(deftest list-count-test
  (is (= 3 (exercism.languages/count-languages '("JavaScript" "Java" "Clojure")))))
