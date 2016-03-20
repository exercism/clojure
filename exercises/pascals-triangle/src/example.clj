(ns pascals-triangle)

(defn- next-row [row]
  (lazy-seq (->> (partition-all 2 1 row)
                 (map (partial apply +'))
                 (cons 1))))

(def triangle (iterate next-row [1]))

(defn row [n] (nth triangle (dec n)))
