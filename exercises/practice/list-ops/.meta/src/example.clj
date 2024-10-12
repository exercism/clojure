(ns list-ops)

(defn foldl [f coll init]
  (loop [acc init l coll]
    (cond
      (empty? l) acc
      :else (recur (f acc (first l)) (rest l)))))

(defn append [coll1 coll2]
  (list-ops/foldl (fn [acc elem] (conj acc elem)) coll2 coll1))

(defn concatenate [coll]
  (cond
    (empty? coll) []
    :else (list-ops/foldl (fn [acc elem] (list-ops/append acc elem)) (rest coll) (first coll))))

(defn select-if [pred coll]
  (loop [acc [] l coll]
    (cond
      (empty? l) acc
      (pred (first l)) (recur (conj acc (first l)) (rest l))
      :else (recur acc (rest l)))))

(defn length [coll]
  (list-ops/foldl (fn [acc elem] (+ acc 1)) coll 0))

(defn apply-to-each [f coll]
  (list-ops/foldl (fn [acc elem] (conj acc (f elem))) coll []))

(defn reverse-order [coll]
  (list-ops/foldl (fn [acc elem] (cons elem acc)) coll []))

(defn foldr [f coll init]
  (list-ops/foldl f (list-ops/reverse-order coll) init))
