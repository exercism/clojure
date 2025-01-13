(ns dnd-character-generator
  (:require [hbs.helper :refer [safe-str]]))

(def random-abilities [:strength :dexterity :charisma :wisdom :intelligence :constitution])

(defn- expand-character-test-case [test-case]
  (map
   (fn [ability]
     (-> test-case
         (update :path #(conj % (name ability)))
         (assoc :once (= (:description test-case) "each ability is only calculated once"))
         (assoc :ability (safe-str (str ability))))) random-abilities))

(defn- expand-test-case [test-case]
  (case (:property test-case)
    "character" (expand-character-test-case test-case)
    "modifier" [(update test-case :path #(take-last 1 %))]
    [test-case]))

(defn add-remove-test-cases [test-cases]
  (mapcat #(expand-test-case %) test-cases))
