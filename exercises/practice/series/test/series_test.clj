(ns series-test
  (:require [clojure.test :refer [deftest testing is]]
            series))

(deftest slices_test_1
  (testing "slices of one from one"
    (is (= ["1"]
           (series/slices "1" 1)))))

(deftest slices_test_2
  (testing "slices of one from two"
    (is (= ["1" "2"]
           (series/slices "12" 1)))))

(deftest slices_test_3
  (testing "slices of two"
    (is (= ["35"]
           (series/slices "35" 2)))))

(deftest slices_test_4
  (testing "slices of two overlap"
    (is (= ["91" "14" "42"]
           (series/slices "9142" 2)))))

(deftest slices_test_5
  (testing "slices can include duplicates"
    (is (= ["777" "777" "777" "777"]
           (series/slices "777777" 3)))))

(deftest slices_test_6
  (testing "slices of a long series"
    (is (= ["91849" "18493" "84939" "49390" "93904" "39042" "90424" "04243"]
           (series/slices "918493904243" 5)))))

(deftest slices_test_7
  (testing "slice length is too large"
    (is (thrown-with-msg? IllegalArgumentException #"^slice length cannot be greater than series length$"
                          (series/slices "12345" 6)))))

(deftest slices_test_8
  (testing "slice length is way too large"
    (is (thrown-with-msg? IllegalArgumentException #"^slice length cannot be greater than series length$"
                          (series/slices "12345" 42)))))

(deftest slices_test_9
  (testing "slice length cannot be zero"
    (is (thrown-with-msg? IllegalArgumentException #"^slice length cannot be zero$"
                          (series/slices "12345" 0)))))

(deftest slices_test_10
  (testing "slice length cannot be negative"
    (is (thrown-with-msg? IllegalArgumentException #"^slice length cannot be negative$"
                          (series/slices "123" -1)))))

(deftest slices_test_11
  (testing "empty series is invalid"
    (is (thrown-with-msg? IllegalArgumentException #"^series cannot be empty$"
                          (series/slices "" 1)))))
