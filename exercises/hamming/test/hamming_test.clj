(ns hamming-test
  (:require [clojure.test :refer [deftest is]]
            hamming))

(deftest no-difference-between-empty-strands
  (is (= 0 (hamming/distance "" ""))))

(deftest no-difference-between-identical-strands
  (is (= 0 (hamming/distance "GGACTGA" "GGACTGA"))))

(deftest complete-distance-in-small-strand
  (is (= 3 (hamming/distance "ACT" "GGA"))))

(deftest small-distance-in-middle-somewhere
  (is (= 1 (hamming/distance "GGACG" "GGTCG"))))

(deftest larger-distance
  (is (= 2 (hamming/distance "ACCAGGG" "ACTATGG"))))

(deftest undefined-when-lengths-are-different
  (is (= nil (hamming/distance "AAAC" "TAGGGGAGGCTAGCGGTAGGAC")))
  (is (= nil (hamming/distance "GACTACGGACAGGGTAACATAG" "GACA"))))
