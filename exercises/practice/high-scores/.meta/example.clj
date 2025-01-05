(ns high-scores)

(def scores identity)
(def latest last)
(defn personal-best [scores] (apply max scores))
(defn personal-top-three [scores] (take 3 (sort > scores)))
