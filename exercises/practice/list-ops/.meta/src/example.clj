(ns list-ops)

(defn foldl [f list init]
  (loop [acc init l list]
    (cond
      (empty? l) acc
      :else (recur (f acc (first l)) (rest l)))))

(defn append [list1 list2]
  (list-ops/foldl (fn [acc elem] (conj acc elem)) list2 list1))

(defn concat [list]
  (cond
    (empty? list) []
    :else (list-ops/foldl (fn [acc elem] (list-ops/append acc elem)) (rest list) (first list))))

(defn filter [f list]
  (loop [acc [] l list]
    (cond
      (empty? l) acc
      (f (first l)) (recur (conj acc (first l)) (rest l))
      :else (recur acc (rest l)))))

(defn length [list]
  (list-ops/foldl (fn [acc elem] (+ acc 1)) list 0))

(defn map [f list]
  (list-ops/foldl (fn [acc elem] (conj acc (f elem))) list []))

(defn reverse [list]
  (list-ops/foldl (fn [acc elem] (cons elem acc)) list []))

(defn foldr [f list init]
  (list-ops/foldl f (list-ops/reverse list) init))
