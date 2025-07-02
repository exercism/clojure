(ns flower-field
  (:require [clojure.pprint :refer [cl-format]]
            [clojure.string :refer [split-lines]]))

(defn- windows [field]
  (->> field
       (map #(partition 3 1 `(nil ~@% nil)))
       (apply map #(partition 3 1 `(nil ~@%& nil)))
       (apply map vector)))

(defn- count-flowers-around [[[a b c]
                            [d e f]
                            [g h i]]]
  (if-let [flowers-count (and (= \space e)
                            (count (filter #{\*} [a b c d f g h i])))]
    (if (zero? flowers-count)
      \space
      flowers-count)
    e))

(defn draw [field]
  (if (empty? field) ""
      (->> field
           split-lines
           windows
           (map (fn [line] (map count-flowers-around line)))
           (cl-format nil "~{~{~a~}~^~%~}"))))
