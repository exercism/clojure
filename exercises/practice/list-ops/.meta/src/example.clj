(ns list-ops)

(defn append [list1 list2]
  (into list1 list2))

(defn concat [list]
  (flatten list))

(defn filter [f list])

(defn length [list])

(defn map [f list])

(defn foldl [f list init])

(defn foldr [f list init])

(defn reverse [list])