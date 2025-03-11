(ns protein-translation-test
  (:require [clojure.test :refer [deftest testing is]]
            protein-translation))

(deftest translate-rna_test_1
  (testing "Empty RNA sequence results in no proteins"
    (is (= []
           (protein-translation/translate-rna "")))))

(deftest translate-rna_test_2
  (testing "Methionine RNA sequence"
    (is (= ["Methionine"]
           (protein-translation/translate-rna "AUG")))))

(deftest translate-rna_test_3
  (testing "Phenylalanine RNA sequence 1"
    (is (= ["Phenylalanine"]
           (protein-translation/translate-rna "UUU")))))

(deftest translate-rna_test_4
  (testing "Phenylalanine RNA sequence 2"
    (is (= ["Phenylalanine"]
           (protein-translation/translate-rna "UUC")))))

(deftest translate-rna_test_5
  (testing "Leucine RNA sequence 1"
    (is (= ["Leucine"]
           (protein-translation/translate-rna "UUA")))))

(deftest translate-rna_test_6
  (testing "Leucine RNA sequence 2"
    (is (= ["Leucine"]
           (protein-translation/translate-rna "UUG")))))

(deftest translate-rna_test_7
  (testing "Serine RNA sequence 1"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCU")))))

(deftest translate-rna_test_8
  (testing "Serine RNA sequence 2"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCC")))))

(deftest translate-rna_test_9
  (testing "Serine RNA sequence 3"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCA")))))

(deftest translate-rna_test_10
  (testing "Serine RNA sequence 4"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCG")))))

(deftest translate-rna_test_11
  (testing "Tyrosine RNA sequence 1"
    (is (= ["Tyrosine"]
           (protein-translation/translate-rna "UAU")))))

(deftest translate-rna_test_12
  (testing "Tyrosine RNA sequence 2"
    (is (= ["Tyrosine"]
           (protein-translation/translate-rna "UAC")))))

(deftest translate-rna_test_13
  (testing "Cysteine RNA sequence 1"
    (is (= ["Cysteine"]
           (protein-translation/translate-rna "UGU")))))

(deftest translate-rna_test_14
  (testing "Cysteine RNA sequence 2"
    (is (= ["Cysteine"]
           (protein-translation/translate-rna "UGC")))))

(deftest translate-rna_test_15
  (testing "Tryptophan RNA sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGG")))))

(deftest translate-rna_test_16
  (testing "STOP codon RNA sequence 1"
    (is (= []
           (protein-translation/translate-rna "UAA")))))

(deftest translate-rna_test_17
  (testing "STOP codon RNA sequence 2"
    (is (= []
           (protein-translation/translate-rna "UAG")))))

(deftest translate-rna_test_18
  (testing "STOP codon RNA sequence 3"
    (is (= []
           (protein-translation/translate-rna "UGA")))))

(deftest translate-rna_test_19
  (testing "Sequence of two protein codons translates into proteins"
    (is (= ["Phenylalanine" "Phenylalanine"]
           (protein-translation/translate-rna "UUUUUU")))))

(deftest translate-rna_test_20
  (testing "Sequence of two different protein codons translates into proteins"
    (is (= ["Leucine" "Leucine"]
           (protein-translation/translate-rna "UUAUUG")))))

(deftest translate-rna_test_21
  (testing "Translate RNA strand into correct protein list"
    (is (= ["Methionine" "Phenylalanine" "Tryptophan"]
           (protein-translation/translate-rna "AUGUUUUGG")))))

(deftest translate-rna_test_22
  (testing "Translation stops if STOP codon at beginning of sequence"
    (is (= []
           (protein-translation/translate-rna "UAGUGG")))))

(deftest translate-rna_test_23
  (testing "Translation stops if STOP codon at end of two-codon sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGGUAG")))))

(deftest translate-rna_test_24
  (testing "Translation stops if STOP codon at end of three-codon sequence"
    (is (= ["Methionine" "Phenylalanine"]
           (protein-translation/translate-rna "AUGUUUUAA")))))

(deftest translate-rna_test_25
  (testing "Translation stops if STOP codon in middle of three-codon sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGGUAGUGG")))))

(deftest translate-rna_test_26
  (testing "Translation stops if STOP codon in middle of six-codon sequence"
    (is (= ["Tryptophan" "Cysteine" "Tyrosine"]
           (protein-translation/translate-rna "UGGUGUUAUUAAUGGUUU")))))

(deftest translate-rna_test_27
  (testing "Sequence of two non-STOP codons does not translate to a STOP codon"
    (is (= ["Methionine" "Methionine"]
           (protein-translation/translate-rna "AUGAUG")))))

(deftest translate-rna_test_28
  (testing "Unknown amino acids, not part of a codon, can't translate"
    (is (thrown-with-msg? IllegalArgumentException #"^Invalid codon$"
                          (protein-translation/translate-rna "XYZ")))))

(deftest translate-rna_test_29
  (testing "Incomplete RNA sequence can't translate"
    (is (thrown-with-msg? IllegalArgumentException #"^Invalid codon$"
                          (protein-translation/translate-rna "AUGU")))))

(deftest translate-rna_test_30
  (testing "Incomplete RNA sequence can translate if valid until a STOP codon"
    (is (= ["Phenylalanine" "Phenylalanine"]
           (protein-translation/translate-rna "UUCUUCUAAUGGU")))))
