(ns trinary)

(defn- num->digits [num]
  (->> num
       (map str)
       (map read-string)))

(defn to-decimal
  [num]
  (if (re-seq #"^[0-2]+$" num)
    (->> num num->digits reverse
         (map-indexed
          (fn [place digit] (* digit (reduce * (repeat place 3)))))
         (apply +))
    0))