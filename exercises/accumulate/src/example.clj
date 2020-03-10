(ns accumulate)

(defn accumulate
  "Given a coll and a function to perform
   on each element of the coll, returns a new
   coll containing the result of applying f
   to each element of the input coll."
  [f xs]
  (loop [xs xs
         accum []]
    (if
     (empty? xs) accum
     (recur (rest xs) (conj accum (f (first xs)))))))

