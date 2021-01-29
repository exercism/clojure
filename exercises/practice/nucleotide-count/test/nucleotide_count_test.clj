(ns nucleotide-count-test
  (:require [clojure.test :refer [deftest is]]
            nucleotide-count))

(deftest empty-dna-strand-has-no-adenosine
  (is (= 0 (nucleotide-count/count-of-nucleotide-in-strand \A, ""))))

(deftest empty-dna-strand-has-no-nucleotides
  (is (= {\A 0, \T 0, \C 0, \G 0}
         (nucleotide-count/nucleotide-counts ""))))

(deftest repetitive-cytidine-gets-counted
  (is (= 5 (nucleotide-count/count-of-nucleotide-in-strand \C "CCCCC"))))

(deftest repetitive-sequence-has-only-guanosine
  (is (= {\A 0, \T 0, \C 0, \G 8}
         (nucleotide-count/nucleotide-counts "GGGGGGGG"))))

(deftest counts-only-thymidine
  (is (= 1 (nucleotide-count/count-of-nucleotide-in-strand \T "GGGGGTAACCCGG"))))

(deftest validates-nucleotides
  (is (thrown? Throwable (nucleotide-count/count-of-nucleotide-in-strand \X "GACT"))))

(deftest counts-all-nucleotides
  (let [s "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"]
    (is (= {\A 20, \T 21, \G 17, \C 12}
           (nucleotide-count/nucleotide-counts s)))))
