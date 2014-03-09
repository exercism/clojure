(ns rna-transcription.test (:require [clojure.test :refer :all]))
(load-file "dna.clj")

(deftest transcribes-guanosine-to-cytidine
  (is (= "G" (dna/to-rna "C"))))

(deftest transcribes-cytidine-to-guanosine
  (is (= "C" (dna/to-rna "G"))))

(deftest transcribes-uracil-to-adenosine
  (is (= "U" (dna/to-rna "A"))))

(deftest it-transcribes-thymidine-to-uracil
  (is (= "A" (dna/to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (dna/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (dna/to-rna "XCGFGGTDTTAA"))))

(run-tests)
