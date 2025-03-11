(ns strain)

(defn retain
  [pred coll]
  (reduce (fn [result el]
            (if (pred el)
              (conj result el)
              result))
          []
          coll))

(defn discard
  [pred coll]
  (retain (complement pred) coll))
