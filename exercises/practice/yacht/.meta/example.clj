(ns yacht)

(defn getScoreForTheYachtCategory [dices]
  (if (= (count (set dices)) 1) 50 0))

(defn mapDicesToCounterArray [dices]
  (let [counterArray (atom [0 0 0 0 0 0])]
    (doseq [item dices]
      (swap! counterArray update (dec item) inc))
    counterArray))

(defn getNoOfAppearances [dices diceValue]
  (count (filter (fn [value] (= value diceValue)) dices)))

(defn getSumOfDices [dices]
  (reduce + 0 dices))

(defn getScoreForTheFourOfAKindCategory [dices]
  (let [counterArray @(mapDicesToCounterArray dices)
        scores (remove nil? (for [i (range 6)]
                              (when (>= (get counterArray i) 4)
                                (* 4 (inc i)))))]
    (if (empty? scores) 0 (first scores))))

(defn getScoreForTheLittleStraightCategory [dices]
  (if (= (sort dices) [1 2 3 4 5]) 30 0))

(defn getScoreForTheBigStraightCategory [dices]
  (if (= (sort dices) [2 3 4 5 6]) 30 0))

(defn getScoreForTheFullHouseCategory [dices]
  (let [counterArray @(mapDicesToCounterArray dices)]
    (if (and (contains? (set counterArray) 2)
             (contains? (set counterArray) 3))
      (if (apply >
                 (map first
                      (sort-by last (seq (frequencies dices)))))
        19 16)
      0)))

(defn score [dices category]
  (case category
    "yacht" (getScoreForTheYachtCategory dices)
    "ones" (getNoOfAppearances dices 1)
    "twos" (* 2 (getNoOfAppearances dices 2))
    "threes" (* 3 (getNoOfAppearances dices 3))
    "fours" (* 4 (getNoOfAppearances dices 4))
    "fives" (* 5 (getNoOfAppearances dices 5))
    "sixes" (* 6 (getNoOfAppearances dices 6))
    "full house" (getScoreForTheFullHouseCategory dices)
    "four of a kind" (getScoreForTheFourOfAKindCategory
                      dices)
    "little straight" (getScoreForTheLittleStraightCategory
                       dices)
    "big straight" (getScoreForTheBigStraightCategory dices)
    "choice" (getSumOfDices dices)
    0))
