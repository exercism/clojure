(ns rna-transcription.test (:require [clojure.test :refer :all]))
(load-file "rna_transcription.clj")

(deftest transcribes-guanosine-to-cytidine
  (is (= "G" (rna_transcription/to-rna "C"))))

(deftest transcribes-cytidine-to-guanosine
  (is (= "C" (rna_transcription/to-rna "G"))))

(deftest transcribes-uracil-to-adenosine
  (is (= "U" (rna_transcription/to-rna "A"))))

(deftest it-transcribes-thymidine-to-uracil
  (is (= "A" (rna_transcription/to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (rna_transcription/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (rna_transcription/to-rna "XCGFGGTDTTAA"))))

(run-tests)
