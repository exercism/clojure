(ns two-fer-test
  (:require [clojure.test :refer [deftest testing is]]
            two-fer))

(deftest two-fer_test_1
  (testing "no name given"
    (is (= "One for you, one for me." (two-fer/two-fer)))))

(deftest two-fer_test_2
  (testing "a name given"
    (is (= "One for Alice, one for me." (two-fer/two-fer "Alice")))))

(deftest two-fer_test_3
  (testing "another name given"
    (is (= "One for Bob, one for me." (two-fer/two-fer "Bob")))))
