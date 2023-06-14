(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (inc n) (+ n 2)))

(comment
  (map rounds '(0 1 10 27 99 666))
  (rounds 27)
;;=> (27 28 29)
  )