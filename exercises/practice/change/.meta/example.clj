;; Taken from https://exercism.org/tracks/clojure/exercises/change/solutions/Testare
;; and adjusted to pass the new tests

(ns change)

(defn- find-decrements [coins]
  "Returns an iterable function that takes a vector pair of [edges graph] and returns
  a pair of [new-edges new-graph], where the new edges are obtained by subtracting all
  coins from all edges, removing any that are already in the graph or negative values."
  (fn [[edges graph]]
    (if (empty? edges)
      (throw (IllegalArgumentException. "can't make target with given coins"))
      (let [new-graph (for [coin coins
                            edge edges
                            :when (<= coin edge)]
                        [(- edge coin) coin])]
        [(set (remove graph (map first new-graph))) (merge (into {} new-graph) graph)]))))

(defn- trail-map [target coins]
  "Returns a map of amount to the coin that leads to the next amount."
  ; e.g., (trail-map 27 #{1 7 20 25}) returns
  ; {0 20, 7 20, 20 7, 27 nil, 1 25, 13 7, 6 1, 25 1, 2 25, 19 1, 26 1}
  ;  You can follow this map from 0 all the way to 27
  ;  The value of 0 in the map is 20
  ;  the value of 20 in the map is 7
  ;  the value of 27 in the map is nil, because it is the target
  ;  Thus you can get change for 27 using a 20 coin and a 7 coin.
  (some
    #(and ((first %) 0) (second %)) ; repeat until we find a map with 0 in it
    (iterate (find-decrements coins) [#{target} {target nil}])))

(defn- trail [target coins]
  "Returns the coins needed to get to target using denominations supplied (by using the trail-map)"
  (let [tmap (trail-map target coins)]
    (loop [sum 0 coins ()]
      (if-let [next-coin (tmap sum)]
        (recur (+ sum next-coin) (conj coins next-coin))
        coins))))

(defn issue [target coins]
  "Returns the coins needed to get to target using denominations supplied"
  (cond
    (zero? target) ()
    (neg? target) (throw (IllegalArgumentException. "target can't be negative"))
    (< target (apply min coins)) (throw (IllegalArgumentException. "can't make target with given coins"))
    :else (sort (trail target coins))))
