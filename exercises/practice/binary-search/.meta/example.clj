(ns binary-search)

(defn search-for
  [n coll]
  (loop [low-idx 0
         high-idx (dec (count coll))]
    (if (> low-idx high-idx)
      -1
      (let [mid-index (quot (+ high-idx low-idx) 2)
            mid-item (get coll mid-index)]
        (cond
          (= n mid-item) mid-index
          (> mid-item n) (recur low-idx (dec mid-index))
          :else (recur (inc mid-index) high-idx))))))
