(ns list-ops)

(defn append [list1 list2]
  (into list1 list2))

(defn concat [list]
  (apply clojure.core/concat list))

(defn filter [f list]
  (loop [acc [] l list]
    (cond 
      (empty? l) acc
      (f (first l)) (recur (conj acc (first l)) (rest l))
      :else (recur acc (rest l)))))

(defn length [list]
  (count list))

(defn map [f list]
  (lazy-seq 
   (when (seq list) 
     (cons (f (first list)) (map f (rest list))))))

(defn foldl [f list init]
  (reduce f init list))

(defn foldr [f list init]
  (reduce f init (reverse list)))

(defn reverse [list]
  (clojure.core/reverse list))
