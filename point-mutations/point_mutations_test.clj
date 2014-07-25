(ns point-mutations.test (:require [clojure.test :refer :all]))
(load-file "point_mutations.clj")

(deftest no-difference-between-empty-strands
  (is (= 0 (point_mutations/hamming-distance "" ""))))

(deftest no-difference-between-identical-strands
  (is (= 0 (point_mutations/hamming-distance "GGACTGA" "GGACTGA"))))

(deftest complete-hamming-distance-in-small-strand
  (is (= 3 (point_mutations/hamming-distance "ACT" "GGA"))))

(deftest hamming-distance-in-off-by-one-strand
  (is (= 19 (point_mutations/hamming-distance "GGACGGATTCTGACCTGGACTAATTTTGGGG" "AGGACGGATTCTGACCTGGACTAATTTTGGGG"))))

(deftest small-hamming-distance-in-middle-somewhere
  (is (= 1 (point_mutations/hamming-distance "GGACG" "GGTCG"))))

(deftest larger-distance
  (is (= 2 (point_mutations/hamming-distance "ACCAGGG" "ACTATGG"))))

(deftest ignores-extra-length-on-other-strand-when-longer
  (is (= 3 (point_mutations/hamming-distance "AAACTAGGGG" "AGGCTAGCGGTAGGAC"))))

(deftest ignores-extra-length-on-original-strand-when-longer
  (is (= 5 (point_mutations/hamming-distance "GACTACGGACAGGGTAGGGAAT" "GACATCGCACACC"))))

(deftest does-not-actually-shorten-original-strand
  (is (= 1 (point_mutations/hamming-distance "AGACAACAGCCAGCCGCCGGATT" "AGGCAA")))
  (is (= 4 (point_mutations/hamming-distance "AGACAACAGCCAGCCGCCGGATT" "AGACATCTTTCAGCCGCCGGATTAGGCAA")))
  (is (= 1 (point_mutations/hamming-distance "AGACAACAGCCAGCCGCCGGATT" "AGG"))))

(run-tests)
