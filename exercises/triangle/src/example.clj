(ns triangle
  (:refer-clojure :exclude [type]))

(defn type [a b c]
  (let [sorted (sort > [a b c])]
    (if (>= (first sorted) (apply + (rest sorted))) :illogical
        (case (count (set sorted))
          1 :equilateral
          2 :isosceles
          3 :scalene))))
