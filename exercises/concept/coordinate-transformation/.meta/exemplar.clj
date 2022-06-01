(ns coordinate-transformation)

(defn translate2d [dx dy]
  (fn [x y] [(+ dx x) (+ dy y)]))

(defn scale2d [sx sy] 
  (fn [x y] [(* sx x) (* sy y)]))