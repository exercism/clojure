(ns rna-transcription-test
  (:require [clojure.test :refer [deftest is]]
            rna-transcription))

(deftest transcribes-cytosine-to-guanine
  (is (= "G" (rna-transcription/to-rna "C"))))

(deftest transcribes-guanine-to-cytosine
  (is (= "C" (rna-transcription/to-rna "G"))))

(deftest transcribes-adenine-to-uracil
  (is (= "U" (rna-transcription/to-rna "A"))))

(deftest it-transcribes-thymine-to-adenine
  (is (= "A" (rna-transcription/to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (rna-transcription/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (rna-transcription/to-rna "XCGFGGTDTTAA"))))
