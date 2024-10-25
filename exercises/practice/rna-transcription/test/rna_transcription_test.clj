(ns rna-transcription-test
  (:require [clojure.test :refer [deftest testing is]]
            rna-transcription))

(deftest empty-sequence
  (testing "Empty RNA sequence"
    (is (= "" (rna-transcription/to-rna "")))))

(deftest rna-complement-of-cytosine
  (testing "RNA complement of cytosine is guanine"
    (is (= "G" (rna-transcription/to-rna "C")))))

(deftest rna-complement-of-guanine
  (testing "RNA complement of guanine is cytosine"
    (is (= "C" (rna-transcription/to-rna "G")))))

(deftest rna-complement-of-thymine
  (testing "RNA complement of thymine is adenine"
    (is (= "A" (rna-transcription/to-rna "T")))))

(deftest rna-complement-of-adenine
  (testing "RNA complement of adenine is uracil"
    (is (= "U" (rna-transcription/to-rna "A")))))

(deftest rna-complement
  (testing "RNA complement"
    (is (= "UGCACCAGAAUU" (rna-transcription/to-rna "ACGTGGTCTTAA")))))
