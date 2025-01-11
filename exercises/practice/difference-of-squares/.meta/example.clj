(ns difference-of-squares)

(defn- square [n] (* n n))
(defn- sum [xs] (reduce + xs))

(defn sum-of-squares [n]
  (sum (map square (range 1 (inc n)))))

(defn square-of-sum [n]
  (square (sum (range 1 (inc n)))))

(defn difference [x]
  (- (square-of-sum x) (sum-of-squares x)))
