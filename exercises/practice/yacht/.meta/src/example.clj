(ns yacht)

(defn yacht [dices]
  (if (= (count (set dices)) 1) 50 0))

(defn dice-frequencies [dices]
  (mapv #(if (nil? %) 0 %)
        (map (fn [v] (get (frequencies dices) v))
             (range 1 7))))

(defn appearances [dices diceValue]
  (get (dice-frequencies dices) (dec diceValue)))

(defn getSumOfDices [dices]
  (reduce + 0 dices))

(defn four-of-kind [dices]
  (let [counterArray (dice-frequencies dices)
        scores (remove nil? (for [i (range 6)]
                              (when (>= (get counterArray i) 4)
                                (* 4 (inc i)))))]
    (if (empty? scores) 0 (first scores))))

(defn little-straight [dices]
  (if (= (sort dices) [1 2 3 4 5]) 30 0))

(defn big-straight [dices]
  (if (= (sort dices) [2 3 4 5 6]) 30 0))

(defn full-house [dices]
  (let [counterArray (dice-frequencies dices)]
    (if (and (contains? (set counterArray) 2)
             (contains? (set counterArray) 3))
      (reduce + dices)
      0)))

(defn score [dices category]
  (case category
    "yacht" (yacht dices)
    "ones" (appearances dices 1)
    "twos" (* 2 (appearances dices 2))
    "threes" (* 3 (appearances dices 3))
    "fours" (* 4 (appearances dices 4))
    "fives" (* 5 (appearances dices 5))
    "sixes" (* 6 (appearances dices 6))
    "full house" (full-house dices)
    "four of a kind" (four-of-kind dices)
    "little straight" (little-straight dices)
    "big straight" (big-straight dices)
    "choice" (getSumOfDices dices)
    0))
