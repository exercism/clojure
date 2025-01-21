(ns game-of-life)

(defn live-neighbors-count [matrix y x]
  (->> (for [dy [-1 0 1] dx [-1 0 1]
             :when (not (and (= dy 0) (= dx 0)))]
         (get-in matrix [(+ y dy) (+ x dx)] 0))
       (apply +)))

(defn next-generation [cell neighbors-count]
  (if
   (or (= 3 neighbors-count)
       (and (= 2 neighbors-count) (= 1 cell)))
    1
    0))

(defn tick [matrix]
  (mapv
   (fn [y row]
     (mapv
      (fn [x cell] (next-generation cell (live-neighbors-count matrix y x)))
      (range)
      row))
   (range)
   matrix))
  