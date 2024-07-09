(ns protein-translation-test
  (:require [clojure.test :refer [deftest testing is]]
            protein-translation))

(deftest empty-rna-sequence-results-in-no-protein
  (testing "Empty RNA sequence results in no protein"
    (is (= [] (protein-translation/translate-rna "")))))

(deftest methionine-RNA-sequence
  (testing "Methionine RNA sequence"
    (is (= ["Methionine"]
           (protein-translation/translate-rna "AUG")))))

(deftest phenylalanine-RNA-sequence-1
  (testing "Phenylalanine RNA sequence 1"
    (is (= ["Phenylalanine"]
           (protein-translation/translate-rna "UUU")))))

(deftest phenylalanine-RNA-sequence-2
  (testing "Phenylalanine RNA sequence 2"
    (is (= ["Phenylalanine"]
           (protein-translation/translate-rna "UUC")))))

(deftest leucine-RNA-sequence-1
  (testing "Leucine RNA sequence 1"
    (is (= ["Leucine"]
           (protein-translation/translate-rna "UUA")))))

(deftest leucine-RNA-sequence-2
  (testing "Leucine RNA sequence 2"
    (is (= ["Leucine"]
           (protein-translation/translate-rna "UUG")))))

(deftest serine-RNA-sequence-1
  (testing "Serine RNA sequence 1"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCU")))))

(deftest serine-RNA-sequence-2
  (testing "Serine RNA sequence 2"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCC")))))

(deftest serine-RNA-sequence-3
  (testing "Serine RNA sequence 3"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCA")))))

(deftest serine-RNA-sequence-4
  (testing "Serine RNA sequence 4"
    (is (= ["Serine"]
           (protein-translation/translate-rna "UCG")))))

(deftest tyrosine-RNA-sequence-1
  (testing "Tyrosine RNA sequence 1"
    (is (= ["Tyrosine"]
           (protein-translation/translate-rna "UAU")))))

(deftest tyrosine-RNA-sequence-2
  (testing "Tyrosine RNA sequence 2"
    (is (= ["Tyrosine"]
           (protein-translation/translate-rna "UAC")))))

(deftest cysteine-RNA-sequence-1
  (testing "Cysteine RNA sequence 1"
    (is (= ["Cysteine"]
           (protein-translation/translate-rna "UGU")))))

(deftest cysteine-RNA-sequence-2
  (testing "Cysteine RNA sequence 2"
    (is (= ["Cysteine"]
           (protein-translation/translate-rna "UGC")))))

(deftest tryptophan-RNA-sequence
  (testing "Tryptophan RNA sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGG")))))

(deftest STOP-codon-RNA-sequence-1
  (testing "STOP codon RNA sequence 1"
    (is (= [] (protein-translation/translate-rna "UAA")))))

(deftest STOP-codon-RNA-sequence-2
  (testing "STOP codon RNA sequence 2"
    (is (= [] (protein-translation/translate-rna "UAG")))))

(deftest STOP-codon-RNA-sequence-3
  (testing "STOP codon RNA sequence 3"
    (is (= [] (protein-translation/translate-rna "UGA")))))

(deftest sequence-of-two-protein-codons-translates-into-proteins
  (testing "Sequence of two protein codons translates into proteins"
    (is (= ["Phenylalanine", "Phenylalanine"]
           (protein-translation/translate-rna "UUUUUU")))))

(deftest sequence-of-two-different-protein-codons-translates-into-proteins
  (testing "Sequence of two different protein codons translates into proteins"
    (is (= ["Leucine", "Leucine"]
           (protein-translation/translate-rna "UUAUUG")))))

(deftest translate-RNA-strand-into-correct-protein-list
  (testing "Translate RNA strand into correct protein list"
    (is (= ["Methionine", "Phenylalanine", "Tryptophan"]
           (protein-translation/translate-rna "AUGUUUUGG")))))

(deftest translation-stops-if-STOP-codon-at-beginning-of-sequence
  (testing "Translation stops if STOP codon at beginning of sequence"
    (is (= [] (protein-translation/translate-rna "UAGUGG")))))

(deftest translation-stops-if-STOP-codon-at-end-of-two-codon-sequence
  (testing "Translation stops if STOP codon at end of two-codon sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGGUAG")))))

(deftest translation-stops-if-STOP-codon-at-end-of-three-codon-sequence
  (testing "Translation stops if STOP codon at end of three-codon sequence"
    (is (= ["Methionine", "Phenylalanine"]
           (protein-translation/translate-rna "AUGUUUUAA")))))

(deftest translation-stops-if-STOP-codon-in-middle-of-three-codon-sequence
  (testing "Translation stops if STOP codon in middle of three-codon sequence"
    (is (= ["Tryptophan"]
           (protein-translation/translate-rna "UGGUAGUGG")))))

(deftest translation-stops-if-STOP-codon-in-middle-of-six-codon-sequence
  (testing "Translation stops if STOP codon in middle of six-codon sequence"
    (is (= ["Tryptophan", "Cysteine", "Tyrosine"]
           (protein-translation/translate-rna "UGGUGUUAUUAAUGGUUU")))))

(deftest sequence-of-two-non-STOP-codons-does-not-translate-to-a-STOP-codon
  (testing "Sequence of two non-STOP codons does not translate to a STOP codon"
    (is (= ["Methionine", "Methionine"]
           (protein-translation/translate-rna "AUGAUG")))))

(deftest incomplete-RNA-sequence-can-translate-if-valid-until-a-STOP-codon
  (testing "Incomplete RNA sequence can translate if valid until a STOP codon"
    (is (= ["Phenylalanine", "Phenylalanine"]
           (protein-translation/translate-rna "UUCUUCUAAUGGU")))))
