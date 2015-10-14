(ns strain)

(defn keep
  "a simple (nonlazy) reimplementation of filter (not keep)"
  [pred s]
  (let [[first & rest] s]
    (cond
      (empty? s) '()
      (pred first) (cons first (keep pred rest))
      :else (keep pred rest))))

(defn discard
  "a simple (nonlazy) reimplementation of remove"
  [pred s]
  (keep (complement pred) s))
