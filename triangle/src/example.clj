(ns triangle
  (:refer-clojure :exclude [type]))

(defn- invalid-sides [a b c]
  (let [[a b c] (sort [a b c])]
    (or (<= a 0)
        (>= c (+ a b)))))

(defn type [a b c]
  (if (invalid-sides a b c)
    :illogical
    (case (count (hash-set a b c))
      1 :equilateral
      2 :isosceles
      :scalene)))
