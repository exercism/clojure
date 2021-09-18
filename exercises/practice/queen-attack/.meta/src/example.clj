(ns queen-attack
  (:require [clojure.string :as str]))

(defn abs [n]
  (if (neg? n) (- n) n))

(def empty-board
  (->> ["_" "_" "_" "_" "_" "_" "_" "_"]
       (repeat 8)
       vec))

(defn board->str [board]
  (->> board
       (map #(str/join " " %))
       (map #(str % "\n"))
       (apply str)))

(defn board-string [{:keys [w b]}]
  (-> empty-board
      (cond-> w (assoc-in w \W)
              b (assoc-in b \B))
      board->str))

(defn can-attack [{[wx wy] :w [bx by] :b :as state}]
  (or (= wx bx)
      (= wy by)
      (= (abs (- wx bx))
         (abs (- wy by)))))