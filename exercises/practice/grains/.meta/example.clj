(ns grains)

(defn- pow [x n]
  (loop [x x
         n n
         r 1]
    (cond
      (= n 0) r
      (even? n) (recur (*' x x) (/ n 2) r)
      :else (recur x (dec n) (*' r x)))))

(defn square [n]
 (pow 2 (dec n)))

(defn total []
  (->> (range 1 65)
       (map square)
       (reduce +)))
