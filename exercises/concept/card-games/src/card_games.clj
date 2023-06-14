(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (inc n) (+ n 2)))

(comment
  (rounds 27)
;;=> (27 28 29)
  )