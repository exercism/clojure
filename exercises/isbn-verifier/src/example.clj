(ns isbn-verifier)

(defn is-in? [xs x] (some #(= x %) xs))

(defn isbn-chars [isbn]
  (filter #(is-in? [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \X] %) isbn))

(defn isbn? [isbn]
  (let [chars (isbn-chars isbn)
        nums  (map #(if (= \X %) 10 (Character/digit % 10)) chars)]
    (and (not (is-in? (butlast chars) \X))
         (= 10 (count chars))
         (zero? (mod (reduce + (map #(* %1 %2) (range 10 0 -1) nums)) 11)))))
