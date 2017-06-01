(ns sublist)

(defn- list-contains?
  "Returns truthy when list2 is contained within list1, nil otherwise"
  [list1 list2]
  (some #(when (= % list2) val)
        (partition (count list2) 1 list1)))

(defn classify
  "Classifies two lists based on whether coll1 is the same list, a superlist,
  a sublist, or disjoint (unequal) from coll2."
  [coll1 coll2]
  (let [len1 (count coll1)
        len2 (count coll2)]
    (cond
      (= coll1 coll2) :equal
      (and (> len1 len2) (list-contains? coll1 coll2)) :superlist
      (and (> len2 len1) (list-contains? coll2 coll1)) :sublist
      :else :unequal)))
