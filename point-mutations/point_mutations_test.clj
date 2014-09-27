(ns point_mutations-test
  (:require [clojure.test :refer :all]
            [point_mutations :refer :all]))


(deftest no-difference-between-empty-strands
  (is (= 0 (point_mutations/hamming-distance "" ""))))

(deftest no-difference-between-identical-strands
  (is (= 0 (point_mutations/hamming-distance "GGACTGA" "GGACTGA"))))

(deftest complete-hamming-distance-in-small-strand
  (is (= 3 (point_mutations/hamming-distance "ACT" "GGA"))))

(deftest small-hamming-distance-in-middle-somewhere
  (is (= 1 (point_mutations/hamming-distance "GGACG" "GGTCG"))))

(deftest larger-distance
  (is (= 2 (point_mutations/hamming-distance "ACCAGGG" "ACTATGG"))))

(deftest undefined-when-lengths-are-different
  (is (= nil (point_mutations/hamming-distance "AAAC" "TAGGGGAGGCTAGCGGTAGGAC")))
  (is (= nil (point_mutations/hamming-distance "GACTACGGACAGGGTAACATAG" "GACA"))))

(run-tests)
