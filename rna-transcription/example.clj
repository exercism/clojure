(ns rna-transcription)

(def dna->rna {\G \C
               \C \G
               \A \U
               \T \A})

(defn- translate [c]
  {:post [%]}
  (dna->rna c))

(defn to-rna [dna]
  (apply str (map translate dna)))
