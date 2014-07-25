(ns nucleotide-count.test (:require [clojure.test :refer :all]))
(load-file "nucleotide_count.clj")

(deftest empty-dna-strand-has-no-adenosine
  (is (= 0 (nucleotide_count/count \A, ""))))

(deftest empty-dna-strand-has-no-nucleotides
  (is (= {\A 0, \T 0, \C 0, \G 0}
         (nucleotide_count/nucleotide-counts ""))))

(deftest repetitive-cytidine-gets-counted
  (is (= 5 (nucleotide_count/count \C "CCCCC"))))

(deftest repetitive-sequence-has-only-guanosine
  (is (= {\A 0, \T 0, \C 0, \G 8}
         (nucleotide_count/nucleotide-counts "GGGGGGGG"))))

(deftest counts-only-thymidine
  (is (= 1 (nucleotide_count/count \T "GGGGGTAACCCGG"))))

(deftest dna-has-no-uracil
  (is (= 0 (nucleotide_count/count \U "GATTACA"))))

(deftest validates-nucleotides
  (is (thrown-with-msg? Exception #"invalid nucleotide" (nucleotide_count/count \X "GACT"))))

(deftest counts-all-nucleotides
  (let [s "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"]
    (is (= {\A 20, \T 21, \G 17, \C 12}
           (nucleotide_count/nucleotide-counts s)))))

(run-tests)
