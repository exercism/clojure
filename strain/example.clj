(ns strain)

(defn retain
  "a simple (nonlazy) reimplementation of filter"
  [pred s]
  (let [[first & rest] s]
    (cond
      (empty? s) '()
      (pred first) (cons first (retain pred rest))
      :else (retain pred rest))))

(defn discard
  "a simple (nonlazy) reimplementation of remove"
  [pred s]
  (retain (complement pred) s))
