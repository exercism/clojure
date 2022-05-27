(ns coordinate-transformation)

(defn translate2d [dx dy]
  (fn [x y] [(+ dx x) (+ dy y)]))
