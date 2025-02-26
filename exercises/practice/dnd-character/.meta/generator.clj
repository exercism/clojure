(ns dnd-character-generator
  (:require [hbs.helper :refer [safe-str]]
            [clojure.string :as str]))

(def random-abilities [:strength :dexterity :charisma :wisdom :intelligence :constitution])

(defn- expand-character-test-case [test-case]
  (map
   (fn [ability]
     (-> test-case
         (assoc :context (str/join " ▶ " (conj (:path test-case) (name ability))))
         (assoc :ability (safe-str (str ability))))) random-abilities))

(defn- expand-test-case [test-case]
  (case (:property test-case)
    "character" (expand-character-test-case test-case)
    "modifier" [(assoc test-case :context (:description test-case))]
    [test-case]))

(defn add-remove-test-cases [test-cases]
  (mapcat #(expand-test-case %) test-cases))
