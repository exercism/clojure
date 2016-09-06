(ns sublist)

(defn classify [coll1 coll2]
  (if (= coll1 coll2)
    :equal
    (let [len1 (count coll1)
          len2 (count coll2)
          [longer shorter len val] (if (> len1 len2)
                                     [coll1 coll2 len2 :superlist]
                                     [coll2 coll1 len1 :sublist])]
      (or (some #(when (= % shorter) val)
                (partition len 1 longer))
          :unequal))))
