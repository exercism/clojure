(ns minesweeper
  (:require [clojure.pprint :refer [cl-format]]
            [clojure.string :refer [split-lines]]))

(defn- windows [field]
  (->> field
       (map #(partition 3 1 `(nil ~@% nil)))
       (apply map #(partition 3 1 `(nil ~@%& nil)))
       (apply map vector)))

(defn- count-mines-around [[[a b c]
                            [d e f]
                            [g h i]]]
  (if-let [mines-count (and (= \space e)
                            (count (filter #{\*} [a b c d f g h i])))]
    (if (zero? mines-count)
      \space
      mines-count)
    e))

(defn draw [field]
  (if (empty? field) ""
      (->> field
           split-lines
           windows
           (map (fn [line] (map count-mines-around line)))
           (cl-format nil "~{~{~a~}~^~%~}"))))
