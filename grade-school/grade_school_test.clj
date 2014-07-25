(ns grade-school.test (:require [clojure.test :refer :all]))
(load-file "grade_school.clj")

(def db {})

(deftest add-student
  (is (= {2 ["Aimee"]} (grade_school/add db "Aimee" 2))))

(deftest add-more-students-in-same-class
  (is (= {2 ["James", "Blair", "Paul"]}
         (-> db
             (grade_school/add "James" 2)
             (grade_school/add "Blair" 2)
             (grade_school/add "Paul" 2)))))

(deftest add-students-to-different-grades
  (is (= {3 ["Chelsea"] 7 ["Logan"]}
         (-> db
             (grade_school/add "Chelsea" 3)
             (grade_school/add "Logan" 7)))))

(deftest get-students-in-a-grade
  (is (= ["Franklin", "Bradley"]
         (-> db
             (grade_school/add "Franklin" 5)
             (grade_school/add "Bradley" 5)
             (grade_school/add "Jeff" 1)
             (grade_school/grade 5)))))

(deftest get-students-in-a-non-existant-grade
  (is (= [] (grade_school/grade db 1))))

(deftest sorted-grade_school
  (is (= { 3 ["Kyle"]
           4 ["Christopher" "Jennifer"]
           6 ["Kareem"] }
         (-> db
             (grade_school/add "Jennifer" 4)
             (grade_school/add "Kareem" 6)
             (grade_school/add "Christopher" 4)
             (grade_school/add "Kyle" 3)
             (grade_school/sorted)))))

(deftest sorted-grade_school-keys-sorted
  (is (= [3 4 6]
         (-> db
             (grade_school/add "Jennifer" 4)
             (grade_school/add "Kareem" 6)
             (grade_school/add "Christopher" 4)
             (grade_school/add "Kyle" 3)
             (grade_school/sorted)
             (keys)))))

(run-tests)

