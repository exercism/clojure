(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (inc n) (+ n 2)))

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #{n} l)))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double (/ (apply + hand) (count hand))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (or (= (card-average hand) (double (/ (+ (first hand) (last hand)) 2)))
      (= (card-average hand) (double (nth hand (int (/ (count hand) 2.0)))))))

(comment
  (map rounds '(0 1 10 27 99 666))
  (rounds 27)
  (concat-rounds '(27 28 29) '(35 36))
  (contains-round? '(27 28 29 35 36) 29)
  (contains-round? '(27 28 29 35 36) 30)
  (card-average '(5 6 7))
  (approx-average? '(1 2 3))
  (approx-average? '(2 3 4 8 8))
  (approx-average? '(1 2 4 5 8))
  )