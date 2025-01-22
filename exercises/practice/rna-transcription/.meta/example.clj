(ns rna-transcription)

(def dna->rna {\G \C
               \C \G
               \A \U
               \T \A})

(defn to-rna [dna]
  (apply str (map dna->rna dna)))
