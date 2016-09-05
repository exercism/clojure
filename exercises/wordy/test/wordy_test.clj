(ns wordy-test
  (:require [clojure.test :refer [deftest is]]
            wordy))

(deftest addition
  (is (= (wordy/evaluate "What is 1 plus 1?") 2)))

(deftest more-addition
  (is (= (wordy/evaluate "What is 53 plus 2?") 55)))

(deftest addition-with-negative-numbers
  (is (= (wordy/evaluate "What is -1 plus -10?") -11)))

(deftest large-addition
  (is (= (wordy/evaluate "What is 123 plus 45678?") 45801)))

(deftest subtraction
  (is (= (wordy/evaluate "What is 4 minus -12?") 16)))

(deftest multiplication
  (is (= (wordy/evaluate "What is -3 multiplied by 25?") -75)))

(deftest division
  (is (= (wordy/evaluate "What is 33 divided by -3?") -11)))

(deftest multiple-additions
  (is (= (wordy/evaluate "What is 1 plus 1 plus 1?") 3)))

(deftest addition-and-subtraction
  (is (= (wordy/evaluate "What is 1 plus 5 minus -2?") 8)))

(deftest multiple-subtraction
  (is (= (wordy/evaluate "What is 20 minus 4 minus 13?") 3)))

(deftest subtraction-then-addition
  (is (= (wordy/evaluate "What is 17 minus 6 plus 3?") 14)))

(deftest multiple-multiplication
  (is (= (wordy/evaluate "What is 2 multiplied by -2 multiplied by 3?") -12)))

(deftest addition-and-multiplication
  (is (= (wordy/evaluate "What is -3 plus 7 multiplied by -2?") -8)))

(deftest multiple-division
  (is (= (wordy/evaluate "What is -12 divided by 2 divided by -3?") 2)))

(deftest unknown-operation
  (is (thrown?
       IllegalArgumentException
       (wordy/evaluate "What is 52 cubed?"))))

(deftest Non-math-question
  (is (thrown?
       IllegalArgumentException
       (wordy/evaluate "Who is the President of the United States?"))))

