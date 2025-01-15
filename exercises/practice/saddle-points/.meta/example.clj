(ns saddle-points)

(defn transpose [matrix]
  (apply mapv vector matrix))

(defn saddle-points [matrix]
  (set
   (if (empty? matrix)
     []
     (let [row-largest (mapv #(apply max %) matrix)
           col-smallest (mapv #(apply min %) (transpose matrix))]
       (for [y (range (count matrix))
             x (range (count (get matrix 0 [])))
             :let [cell (get-in matrix [y x])]
             :when (and (= cell (get row-largest y))
                        (= cell (get col-smallest x)))]
         [(inc y) (inc x)])))))

