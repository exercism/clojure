(ns wordy-test
  (:require [clojure.test :refer [deftest testing is]]
            wordy))

(deftest evaluate_test_1
  (testing "just a number"
    (is (= 5 (wordy/evaluate "What is 5?")))))

(deftest evaluate_test_2
  (testing "addition"
    (is (= 2 (wordy/evaluate "What is 1 plus 1?")))))

(deftest evaluate_test_3
  (testing "more addition"
    (is (= 55 (wordy/evaluate "What is 53 plus 2?")))))

(deftest evaluate_test_4
  (testing "addition with negative numbers"
    (is (= -11 (wordy/evaluate "What is -1 plus -10?")))))

(deftest evaluate_test_5
  (testing "large addition"
    (is (= 45801 (wordy/evaluate "What is 123 plus 45678?")))))

(deftest evaluate_test_6
  (testing "subtraction"
    (is (= 16 (wordy/evaluate "What is 4 minus -12?")))))

(deftest evaluate_test_7
  (testing "multiplication"
    (is (= -75 (wordy/evaluate "What is -3 multiplied by 25?")))))

(deftest evaluate_test_8
  (testing "division"
    (is (= -11 (wordy/evaluate "What is 33 divided by -3?")))))

(deftest evaluate_test_9
  (testing "multiple additions"
    (is (= 3 (wordy/evaluate "What is 1 plus 1 plus 1?")))))

(deftest evaluate_test_10
  (testing "addition and subtraction"
    (is (= 8 (wordy/evaluate "What is 1 plus 5 minus -2?")))))

(deftest evaluate_test_11
  (testing "multiple subtraction"
    (is (= 3 (wordy/evaluate "What is 20 minus 4 minus 13?")))))

(deftest evaluate_test_12
  (testing "subtraction then addition"
    (is (= 14 (wordy/evaluate "What is 17 minus 6 plus 3?")))))

(deftest evaluate_test_13
  (testing "multiple multiplication"
    (is (= -12 (wordy/evaluate "What is 2 multiplied by -2 multiplied by 3?")))))

(deftest evaluate_test_14
  (testing "addition and multiplication"
    (is (= -8 (wordy/evaluate "What is -3 plus 7 multiplied by -2?")))))

(deftest evaluate_test_15
  (testing "multiple division"
    (is (= 2 (wordy/evaluate "What is -12 divided by 2 divided by -3?")))))

(deftest evaluate_test_16
  (testing "unknown operation"
    (is (thrown-with-msg? IllegalArgumentException #"^unknown operation$" (wordy/evaluate "What is 52 cubed?")))))

(deftest evaluate_test_17
  (testing "Non math question"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "Who is the President of the United States?")))))

(deftest evaluate_test_18
  (testing "reject problem missing an operand"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is 1 plus?")))))

(deftest evaluate_test_19
  (testing "reject problem with no operands or operators"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is?")))))

(deftest evaluate_test_20
  (testing "reject two operations in a row"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is 1 plus plus 2?")))))

(deftest evaluate_test_21
  (testing "reject two numbers in a row"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is 1 plus 2 1?")))))

(deftest evaluate_test_22
  (testing "reject postfix notation"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is 1 2 plus?")))))

(deftest evaluate_test_23
  (testing "reject prefix notation"
    (is (thrown-with-msg? IllegalArgumentException #"^syntax error$" (wordy/evaluate "What is plus 1 2?")))))
