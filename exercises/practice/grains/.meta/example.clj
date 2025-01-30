(ns grains)

(defn- pow [x n]
  (loop [x x
         n n
         r 1]
    (cond
      (= n 0) r
      (even? n) (recur (*' x x) (/ n 2) r)
      :else (recur x (dec n) (*' r x)))))

(defn valid-square? [n]
  (<= 1 n 64))

(defn square [n]
  (cond
    (valid-square? n) (pow 2 (dec n))
    :else (throw (IllegalArgumentException. "square must be between 1 and 64"))))

(defn total []
  (->> (range 1 65)
       (map square)
       (reduce +)))
