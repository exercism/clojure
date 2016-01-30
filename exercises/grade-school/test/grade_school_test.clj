(ns grade-school-test
  (:require [clojure.test :refer [deftest is]]
            grade-school))

(def db {})

(deftest add-student
  (is (= {2 ["Aimee"]} (grade-school/add db "Aimee" 2))))

(deftest add-more-students-in-same-class
  (is (= {2 ["James", "Blair", "Paul"]}
         (-> db
             (grade-school/add "James" 2)
             (grade-school/add "Blair" 2)
             (grade-school/add "Paul" 2)))))

(deftest add-students-to-different-grades
  (is (= {3 ["Chelsea"] 7 ["Logan"]}
         (-> db
             (grade-school/add "Chelsea" 3)
             (grade-school/add "Logan" 7)))))

(deftest get-students-in-a-grade
  (is (= ["Franklin", "Bradley"]
         (-> db
             (grade-school/add "Franklin" 5)
             (grade-school/add "Bradley" 5)
             (grade-school/add "Jeff" 1)
             (grade-school/grade 5)))))

(deftest get-students-in-a-non-existant-grade
  (is (= [] (grade-school/grade db 1))))

(deftest sorted-grade-school
  (is (= (sorted-map 3 ["Kyle"]
                     4 ["Christopher" "Jennifer"]
                     6 ["Kareem"] )
         (-> db
             (grade-school/add "Jennifer" 4)
             (grade-school/add "Kareem" 6)
             (grade-school/add "Christopher" 4)
             (grade-school/add "Kyle" 3)
             (grade-school/sorted)))))

(deftest sorted-grade_school-keys-sorted
  (is (= [3 4 6]
         (-> db
             (grade-school/add "Jennifer" 4)
             (grade-school/add "Kareem" 6)
             (grade-school/add "Christopher" 4)
             (grade-school/add "Kyle" 3)
             (grade-school/sorted)
             (keys)))))
