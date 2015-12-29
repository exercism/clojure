(ns point-mutations-test
  (:require [clojure.test :refer [deftest is]]
            point-mutations))

(deftest no-difference-between-empty-strands
  (is (= 0 (point-mutations/hamming-distance "" ""))))

(deftest no-difference-between-identical-strands
  (is (= 0 (point-mutations/hamming-distance "GGACTGA" "GGACTGA"))))

(deftest complete-hamming-distance-in-small-strand
  (is (= 3 (point-mutations/hamming-distance "ACT" "GGA"))))

(deftest small-hamming-distance-in-middle-somewhere
  (is (= 1 (point-mutations/hamming-distance "GGACG" "GGTCG"))))

(deftest larger-distance
  (is (= 2 (point-mutations/hamming-distance "ACCAGGG" "ACTATGG"))))

(deftest undefined-when-lengths-are-different
  (is (= nil (point-mutations/hamming-distance "AAAC" "TAGGGGAGGCTAGCGGTAGGAC")))
  (is (= nil (point-mutations/hamming-distance "GACTACGGACAGGGTAACATAG" "GACA"))))
