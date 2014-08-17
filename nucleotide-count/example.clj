(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(def ^{:private :const} dna-nucleotide? #{\A \C \G \T})

(def ^{:private :const} base-count
  (apply hash-map (interleave dna-nucleotide? (repeat 0))))

(defn nucleotide-counts
  "generate a map of counts per nucleotide in strand"
  [strand]
  (into base-count (frequencies strand)))

(defn count
  "count occurrences of nucleotide in strand"
  [nucleotide strand]
  (if
    (dna-nucleotide? nucleotide)
    ((nucleotide-counts strand) nucleotide)
    (throw (Exception. (str "invalid nucleotide '" nucleotide "'")))))
