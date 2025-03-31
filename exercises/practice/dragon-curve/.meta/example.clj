(ns dragon-curve)

(def start-turn :right)
(def segment-length 2)                                      ; should be even
(def start-points [[0 0] [segment-length 0]])
(def start-direction :east)


(defn swap-turn
  [turn]
  (case turn
    :left :right
    :right :left))

(defn unfold-paper-once
  [paper-turns]
  (-> paper-turns
      (into [start-turn])
      (into (reverse (map swap-turn paper-turns)))))

(defn unfold-paper-times
  [n]
  (reduce (fn [result _]
            (unfold-paper-once result))
          [] (range n)))

(def paper-turn->direction
  {:left {:north :west
          :west :south
          :south :east
          :east :north}
   :right {:north :east
           :east :south
           :south :west
           :west :north}})

(defn generate-next-point
  [point direction]
  (let [[x y] point]
    (case direction
      :north [x (+ y segment-length)]
      :east [(+ x segment-length) y]
      :south [x (- y segment-length)]
      :west [(- x segment-length) y])))

(defn generate-points
  [paper-turns]
  (loop [result start-points
         point (second start-points)
         direction start-direction
         turns paper-turns]
    (if (seq turns)
      (let [new-direction (get (paper-turn->direction (first turns)) direction)
            new-point (generate-next-point point new-direction)]
        (recur (conj result new-point) new-point new-direction (rest turns)))
      result)))

(defn find-midpoint
  [segment]
  (let [[[x1 y1] [x2 y2]] segment]
    [(/ (+ x1 x2) 2) (/ (+ y1 y2) 2)]))

(defn generate-midpoints
  [points]
  (reduce (fn [result segment]
            (conj result (find-midpoint segment)))
          [] (partition 2 1 points)))

(defn find-bounding-box-corners
  [points]
  (let [xs (map first points)
        ys (map second points)]
    [[(- (apply min xs) segment-length) (- (apply min ys) segment-length)]
     [(+ (apply max xs) segment-length) (+ (apply max ys) segment-length)]]))

(defn range-with-offset
  [start end]
  (let [offset (/ segment-length 2)]
    (range (+ start offset) (inc (- end offset)) segment-length)))

(defn generate-grid
  [bounding-box-corners]
  (let [[[x-left y-bottom] [x-right y-top]] bounding-box-corners]
    (for [x (range-with-offset x-left x-right)
          y (range-with-offset y-bottom y-top)]
      [x y])))

(defn find-neighbors
  [point]
  (map #(generate-next-point point %) [:north :east :south :west]))

(defn can-fill?
  [point obstacles]
  (let [neighbors (find-neighbors point)
        midpoints (map #(find-midpoint [% point]) neighbors)]
    (not (every? obstacles midpoints))))

(defn fill-grid
  [grid obstacles]
  (filter #(can-fill? % obstacles) grid))

(defn count-squares
  [n]
  (let [curve-points (generate-points (unfold-paper-times n))
        curve-midpoints (generate-midpoints curve-points)
        bounding-box-corners (find-bounding-box-corners curve-points)
        grid (generate-grid bounding-box-corners)
        obstacles (set curve-midpoints)]
    (- (count grid) (count (fill-grid grid obstacles)))))
