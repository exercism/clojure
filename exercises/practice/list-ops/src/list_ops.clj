(ns list-ops)

(defn append [list1 list2]
  (into list1 list2))

(defn concat [list]
  (apply clojure.core/concat list))

(defn filter [f list]
  (clojure.core/filter f list))

(defn length [list]
  (count list))

(defn map [f list]
  (clojure.core/map f list))

(defn foldl [f list init]
  (reduce f init list))

(defn foldr [f list init]
  (reduce f init (reverse list)))

(defn reverse [list]
  (clojure.core/reverse list))