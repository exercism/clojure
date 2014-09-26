(ns rna-transcription.test (:require [clojure.test :refer :all]))
(load-file "rna_transcription.clj")

(deftest transcribes-guanine-to-cytosine
  (is (= "G" (rna-transcription/to-rna "C"))))

(deftest transcribes-cytosine-to-guanine
  (is (= "C" (rna-transcription/to-rna "G"))))

(deftest transcribes-uracil-to-adenine
  (is (= "U" (rna-transcription/to-rna "A"))))

(deftest it-transcribes-thymine-to-uracil
  (is (= "A" (rna-transcription/to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (rna-transcription/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (rna-transcription/to-rna "XCGFGGTDTTAA"))))

(run-tests)
