(ns state-of-tic-tac-toe)

(defn- winner [cells]
  (let [freqs (frequencies cells)]
    (cond
      (= 3 (get freqs \O)) \O
      (= 3 (get freqs \X)) \X
      :else nil)))

(defn- winning-rows [board] (map seq board))
(defn- winning-cols [board] (apply mapv vector board))
(defn- winning-diagonals [board]
  [(for [i (range 3)] (get-in board [i i]))
   (for [i (range 3)] (get-in board [i (- 2 i)]))])

(defn- winners [board]
  (->> [winning-rows winning-cols winning-diagonals]
       (mapcat #(% board))
       (map winner)
       (remove nil?)
       (distinct)
       (set)))

(defn- moves-made [board]
  (->> board
       (mapcat identity)
       (remove Character/isSpace)
       (frequencies)
       (merge {\X 0 \O 0})))

(defn- error [board]
  (let [moves (moves-made board)]
    (when (= {\X 2 \O 0} moves)
      (throw (IllegalArgumentException. "Wrong turn order: X went twice")))
    (when (> (get moves \O) (get moves \X))
      (throw (IllegalArgumentException. "Wrong turn order: O started")))))

(defn- win [board]
  (let [board-winners (winners board)
        moves    (moves-made board)
        x-count  (get moves \X 0)
        o-count  (get moves \O 0)
        invalid-board! #(throw (IllegalArgumentException. "Impossible board: game should have ended after the game was won"))]
    (cond
      (= 2 (count board-winners)) (invalid-board!)
      (and (contains? board-winners \X) (>= o-count x-count)) (invalid-board!)
      (and (contains? board-winners \O) (> x-count o-count)) (invalid-board!)
      (or (contains? board-winners \X) (contains? board-winners \O)) :win
      :else nil)))

(defn- draw [board]
  (when (= {\X 5 \O 4} (moves-made board))
    :draw))

(defn gamestate [board]
  (or
   (error board)
   (win board)
   (draw board)
   :ongoing))
