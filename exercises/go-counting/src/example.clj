(ns go-counting)

(defn grid->graph [xs]
  (->> (for [x (-> xs count range), y (-> xs first count range)]
         (case (get-in xs [x y])
           \W     [[y x] :white]
           \B     [[y x] :black]
           \space [[y x] :free]))
       (into {})))

(defn neighbors [f stones [x y]]
  (->> [[0 1] [0 -1] [1 0] [-1 0]]
       (map (fn [[j k]] [(+ x j) (+ y k)]))
       (filter (comp f stones))))

(defn territory-of [stones [x y]]
  (if (= :free (stones [x y]))
    (letfn [(f [[seen fronteir]]
              (as-> (reduce conj seen fronteir) nseen
                [nseen (->> fronteir
                            (mapcat #(neighbors #{:free} stones %))
                            (filter (complement nseen)))]))]
      (->> [#{} [[x y]]]
           (iterate f)
           (drop-while (comp seq second))
           (ffirst)))
    #{}))  

(defn territory-owner [stones territory]
  (->> territory
       (mapcat (partial neighbors  #{:black :white} stones))
       (map stones)
       (#(cond (empty? %)                    nil
               (every? (partial = :black) %) :black
               (every? (partial = :white) %) :white
               :else                         nil))))

(defn territory [grid [x y]]
  (let [stones    (grid->graph grid)
        territory (territory-of stones [x y])]
    (if (nil? (stones [x y]))
      (throw (Throwable. "Invalid coordinate!"))
      {:stones territory :owner (territory-owner stones territory)})))

(defn territories [grid]
  (let [territories (->> grid grid->graph keys (map (partial territory grid)))
        f #(->> territories (filter (comp % :owner)) (map :stones) (reduce concat) set)]
    {:black-territory (f (partial = :black)) 
     :white-territory (f (partial = :white))
     :null-territory  (f nil?)}))
