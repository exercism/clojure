(ns rna-transcription-test
  (:require [clojure.test :refer [deftest testing is]]
            rna-transcription))

(deftest to-rna_test_1
  (testing "Empty RNA sequence"
    (is (= "" (rna-transcription/to-rna "")))))

(deftest to-rna_test_2
  (testing "RNA complement of cytosine is guanine"
    (is (= "G" (rna-transcription/to-rna "C")))))

(deftest to-rna_test_3
  (testing "RNA complement of guanine is cytosine"
    (is (= "C" (rna-transcription/to-rna "G")))))

(deftest to-rna_test_4
  (testing "RNA complement of thymine is adenine"
    (is (= "A" (rna-transcription/to-rna "T")))))

(deftest to-rna_test_5
  (testing "RNA complement of adenine is uracil"
    (is (= "U" (rna-transcription/to-rna "A")))))

(deftest to-rna_test_6
  (testing "RNA complement"
    (is (= "UGCACCAGAAUU" (rna-transcription/to-rna "ACGTGGTCTTAA")))))
