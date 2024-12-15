(ns etl-test
  (:require [clojure.test :refer [deftest testing is]]
            etl))

(deftest test-78a7a9f9-4490-4a47-8ee9-5a38bb47d28f
  (testing "Single letter"
    (is (= {"a" 1}
           (etl/transform {1 ["A"]})))))

(deftest test-60dbd000-451d-44c7-bdbb-97c73ac1f497
  (testing "Single score with multiple letters"
    (is (= {"a" 1 "e" 1 "i" 1 "o" 1 "u" 1}
           (etl/transform {1 ["A" "E" "I" "O" "U"]})))))

(deftest test-f5c5de0c-301f-4fdd-a0e5-df97d4214f54
  (testing "Multiple scores with multiple letters"
    (is (= {"a" 1 "d" 2 "e" 1  "g" 2}
           (etl/transform {1 ["A" "E"], 2 ["D" "G"]})))))

(deftest test-5db8ea89-ecb4-4dcd-902f-2b418cc87b9d
  (testing "Multiple scores with differing numbers of letters"
    (is (= {"a"  1 "b"  3 "c" 3 "d" 2 "e" 1
            "f"  4 "g"  2 "h" 4 "i" 1 "j" 8
            "k"  5 "l"  1 "m" 3 "n" 1 "o" 1
            "p"  3 "q" 10 "r" 1 "s" 1 "t" 1
            "u"  1 "v"  4 "w" 4 "x" 8 "y" 4
            "z" 10}
           (etl/transform {1  ["A" "E" "I" "O" "U" "L" "N" "R" "S" "T"]
                           2  ["D" "G"]
                           3  ["B" "C" "M" "P"]
                           4  ["F" "H" "V" "W" "Y"]
                           5  ["K"]
                           8  ["J" "X"]
                           10 ["Q" "Z"]})))))
