(ns protein-translation)

(defn translate-codon [codon]
  (condp contains? codon
    #{"AUG"} "Methionine"
    #{"UUU" "UUC"} "Phenylalanine"
    #{"UUA" "UUG"} "Leucine"
    #{"UCU" "UCC" "UCA" "UCG"} "Serine"
    #{"UAU" "UAC"} "Tyrosine"
    #{"UGU" "UGC"} "Cysteine"
    #{"UGG"} "Tryptophan"
    #{"UAA" "UAG" "UGA"} "STOP"
    :invalid-codon))

(defn translate-lazy [rna]
  (->> rna
       (partition 3 3 nil)
       (remove nil?)
       (map (partial apply str))
       (map translate-codon)))

(defn translate-rna [rna]
  (let [lazy-translated (translate-lazy rna)]
    (reduce
      (fn [result codon]
        (cond
          (= :invalid-codon codon) (throw (IllegalArgumentException. "Invalid codon"))
          (= "STOP" codon) (reduced result)
          :else (conj result codon)))
      []
      lazy-translated)))
