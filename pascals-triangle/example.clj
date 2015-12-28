(ns pascals-triangle)

(defn row [n]
  (->> (range 1 (inc (quot (dec n) 2)))
       (reductions #(quot (*' %1 (-' n %2)) %2) 1)
       ((fn [s]
          (let [v (vec s)]
            (into v (cond-> (rseq v) (odd? n) rest)))))))

(def triangle (map row (iterate inc 1)))