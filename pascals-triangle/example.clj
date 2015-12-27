(ns pascals-triangle)

(defn- build-next-row
  [number row]
  (->> number
       inc
       range
       (mapv #(cond
               (zero? %1) (first row)
               (= number %1) (last row)
               :else (+' (row (dec %1)) (row %1))))))

(defn triangle [row]
  (loop [last-row [1]
         i 1
         res [[1]]]
    (let [new-row (build-next-row i last-row)]
      (if (= i row)
        res
        (recur new-row (inc i) (conj res new-row))))))