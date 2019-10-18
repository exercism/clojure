(ns nucleotide-count)

(def ^{:private :const} dna-nucleotides #{\A \C \G \T})

(def ^{:private :const} base-count
  (zipmap dna-nucleotides (repeat 0)))

(defn nucleotide-counts
  "generate a map of counts per nucleotide in strand"
  [strand]
  (into base-count (frequencies strand)))

(defn count-of-nucleotide-in-strand
  "count occurrences of nucleotide in strand"
  [nucleotide strand]
  (or ((nucleotide-counts strand) nucleotide)
      (throw (Exception. (str "invalid nucleotide '" nucleotide "'")))))
