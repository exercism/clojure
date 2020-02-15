(ns list)

(defn empty-list []
  '()
)

(defn add-item [item coll]
  (cons item coll)
)

(defn remove-item [item coll]
  (remove #(= item %) coll)
)

(defn query-item [item coll]
  (some #(= item %) coll)
)

(defn count-list [coll]
  (count coll)
)

(defn sort-list [coll]
  (sort coll)
)

(defn learning-list []
  (let [langs (list/add-item "JavaScript" 
                  (list/add-item "Java"
                    (list/add-item "Lisp" 
                      (list/add-item "Clojure" (empty-list))
                    )
                  )
            )
        ]
      (println langs)
    (let [langs-new (remove-item "Lisp" langs)]
      (println langs-new)
      (let [langs-queried (query-item "Lisp" langs-new)]
        (println langs-queried)
      )
      (let [total (count-list langs-new)]
        (println total)
      )
      (let [langs-sorted (sort-list langs-new)]
        (println langs-sorted)
      )
    )
  )
)

(learning-list)