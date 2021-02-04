(ns isbn-verifier)

(defn is-in? [xs x] (some #(= x %) xs))

(defn isbn-chars [isbn]
  (filter #(is-in? [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \X] %) isbn))

(defn isbn? [isbn]
  (let [chars (isbn-chars isbn)
        nums  (map #(if (= \X %) 10 (Character/digit % 10)) chars)]
    (and (-> chars butlast (is-in? \X) not)
         (= 10 (count chars))
         (as-> nums x
           (map #(* %1 %2) (range 10 0 -1) x)
           (reduce + x)
           (mod x 11)
           (zero? x)))))
