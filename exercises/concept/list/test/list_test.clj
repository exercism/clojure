(ns list-test
  (:require [clojure.test :refer [deftest is]]
            list))

(deftest list-empty-test
  (is (= '() (list/empty-list)))
)

(deftest list-add-test
    (is (= '("JavaScript" "Java" "Lisp" "Clojure") 
            (list/add-item "JavaScript" 
              (list/add-item "Java"
                (list/add-item "Lisp" 
                  (list/add-item "Clojure" '())
                )
              )
            )
        )
    )
)

(deftest list-remove-test
  (is (= '("JavaScript" "Java" "Clojure") (list/remove-item "Lisp" '("JavaScript" "Java" "Lisp" "Clojure")))))

(deftest list-query-test
  (is (= nil (list/query-item "Lisp" '("JavaScript" "Java" "Clojure")))))

(deftest list-count-test
  (is (= 3 (list/count-list '("JavaScript" "Java" "Clojure")))))

(deftest list-sort-test
  (is (= '("Clojure" "Java" "JavaScript") (list/sort-list '("JavaScript" "Java" "Clojure")))))
