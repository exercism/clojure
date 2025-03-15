(ns collatz-conjecture-test
  (:require [clojure.test :refer [deftest testing is]]
            collatz-conjecture))

(deftest collatz_test_1
  (testing "zero steps for one"
    (is (= 0 (collatz-conjecture/collatz 1)))))

(deftest collatz_test_2
  (testing "divide if even"
    (is (= 4 (collatz-conjecture/collatz 16)))))

(deftest collatz_test_3
  (testing "even and odd steps"
    (is (= 9 (collatz-conjecture/collatz 12)))))

(deftest collatz_test_4
  (testing "large number of even and odd steps"
    (is (= 152 (collatz-conjecture/collatz 1000000)))))
