(ns difference-of-squares)

(defn- sum [xs] (reduce + xs))

(defn sum-of-squares [n]
  (sum (map #(int (Math/pow % 2)) (range 0 (inc n)))))

(defn square-of-sum [n]
  (int (Math/pow (sum (range 0 (inc n))) 2)))

(defn difference [x]
  (- (square-of-sum x) (sum-of-squares x)))
