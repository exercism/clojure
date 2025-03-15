(ns robot-simulator)

(defn robot
  [coordinates direction]
  {:coordinates coordinates :bearing direction})

(def turn-right->
  {:east :south
   :south :west
   :west :north
   :north :east})

(def turn-left->
  {:east :north
   :north :west
   :west :south
   :south :east})

(def move-direction->update-vector
  {:north [:y inc]
   :east [:x inc]
   :west  [:x dec]
   :south [:y dec]})

(defn turn-robot-left
  [robot]
  (update robot :bearing turn-left->))

(defn turn-robot-right
  [robot]
  (update robot :bearing turn-right->))

(defn advance-robot
  [robot]
  (let [[k f] (-> :bearing robot move-direction->update-vector)]
    (update-in robot [:coordinates k] f)))

(defn execute-instruction
  [robot instruction]
  (case instruction
    \L (turn-robot-left robot)
    \R (turn-robot-right robot)
    \A (advance-robot robot)))

(defn simulate
  [instructions robot]
  (reduce execute-instruction robot instructions))
