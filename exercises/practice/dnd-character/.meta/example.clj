(ns dnd-character
  (:require [clojure.math :refer [floor]]))

(defn score-modifier [score]
  (int (floor (/ (- score 10) 2))))

(defn- die [] (inc (rand-int 6)))

(defn rand-ability []
  (reduce + (rest (sort (repeatedly 4 die)))))

(defrecord DndCharacter [strength dexterity charisma wisdom intelligence constitution hitpoints])

(defn rand-character []
  (let [abilities (repeatedly 6 rand-ability)
        [strength dexterity charisma wisdom intelligence constitution] abilities
        hitpoints (+ 10 (score-modifier constitution))]
    (DndCharacter. strength dexterity charisma wisdom intelligence constitution hitpoints)))
  