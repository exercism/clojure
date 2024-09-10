(ns hamming-test
  (:require [clojure.test :refer [deftest is testing]]
            hamming))

(deftest empty-strands
  (testing "Empty strands"
    (is (= 0 (hamming/distance "" "")))))

(deftest single-letter-identical-strands
  (testing "Single letter identical strands"
    (is (= 0 (hamming/distance "A" "A")))))

(deftest single-letter-different-strands
  (testing "Single letter different strands"
    (is (= 1 (hamming/distance "G" "T")))))

(deftest long-identical-strands
  (testing "Long identical strands"
    (is (= 0 (hamming/distance "GGACTGAAATCTG" "GGACTGAAATCTG")))))

(deftest long-different-strands
  (testing "Long different strands"
    (is (= 9 (hamming/distance "GGACGGATTCTG" "AGGACGGATTCT")))))

(deftest disallow-first-strand-longer
  (testing "Disallow first strand longer"
    (is (= nil (hamming/distance "AATG" "AAA")))))

(deftest disallow-second-strand-longer
  (testing "Disallow second strand longer"
    (is (= nil (hamming/distance "ATA" "AGTG")))))

(deftest disallow-empty-first-strand
  (testing "Disallow empty first strand"
    (is (= nil (hamming/distance "" "G")))))

(deftest disallow-empty-second-strand
  (testing "Disallow empty second strand"
    (is (= nil (hamming/distance "G" "")))))
