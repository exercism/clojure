(ns protein-translation-test
  (:require [clojure.test :refer [deftest is are]]
            protein-translation))

(deftest AUG-translates-to-Methionine
  (is (= "Methionine" (protein-translation/translate-codon "AUG"))))

(deftest UGG-translates-to-Tryptophan
  (is (= "Tryptophan" (protein-translation/translate-codon "UGG"))))

(deftest identifies-Phenylalanine-codons
  (are [codon] (= "Phenylalanine" (protein-translation/translate-codon codon)) "UUU" "UUC"))

(deftest identifies-Leucine-codons
  (are [codon] (= "Leucine" (protein-translation/translate-codon codon)) "UUA" "UUG"))

(deftest identiefies-Serine-codons
  (are [codon] (= "Serine" (protein-translation/translate-codon codon)) "UCU" "UCC" "UCA" "UCG"))

(deftest identiefies-Tyrosine-codons
  (are [codon] (= "Tyrosine" (protein-translation/translate-codon codon)) "UAU" "UAC"))

(deftest identifies-Cysteine-codons
  (are [codon] (= "Cysteine" (protein-translation/translate-codon codon)) "UGU" "UGC"))

(deftest identifies-stop-codons
  (are [codon] (= "STOP" (protein-translation/translate-codon codon)) "UAA" "UAG" "UGA"))

(deftest translates-rna-strand-into-correct-protein
  (is (= ["Methionine" "Phenylalanine" "Tryptophan"] (protein-translation/translate-rna "AUGUUUUGG"))))

(deftest stops-translation-if-stop-codon-present
  (is (= ["Methionine" "Phenylalanine"] (protein-translation/translate-rna "AUGUUUUAA"))))

(deftest stops-translation-of-longer-strand
  (is (= ["Tryptophan" "Cysteine" "Tyrosine"] (protein-translation/translate-rna "UGGUGUUAUUAAUGGUUU"))))
