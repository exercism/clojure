(ns poker)

(def base-values
  {"2" 2
   "3" 3
   "4" 4
   "5" 5
   "6" 6
   "7" 7
   "8" 8
   "9" 9
   "10" 10
   "J" 11
   "Q" 12
   "K" 13})

(def values-low-as
  (into base-values
        {"A" 1}))

(def values-high-as
  (into base-values
        {"A" 14}))

(defn value-freq [hand]
  (->> hand
       (group-by :value)
       (vals)
       (map count)
       (sort)))

(defn one-pair? [hand]
  (= [1 1 1 2] (value-freq hand)))

(defn two-pair? [hand]
  (= [1 2 2] (value-freq hand)))

(defn three-of-a-kind? [hand]
  (= [1 1 3] (value-freq hand)))

(defn straight? [hand]
  (->> hand
       (map :value)
       (sort)
       (partition 2 1)
       (map (partial apply -))
       (every? (partial = -1))))

(defn flush? [hand]
  (->> hand
       (map :color)
       (apply =)))

(defn full-house? [hand]
  (= [2 3] (value-freq hand)))

(defn four-of-a-kind? [hand]
  (= [1 4] (value-freq hand)))

(defn straight-flush? [hand]
  (and (flush? hand) (straight? hand)))

(defn category [hand]
  (condp #(%1 %2) hand
    straight-flush? 8
    four-of-a-kind? 7
    full-house? 6
    flush? 5
    straight? 4
    three-of-a-kind? 3
    two-pair? 2
    one-pair? 1
    0))

(defn highcards [hand]
  (->> hand
       (map :value)
       (frequencies)
       (map reverse)
       (map vec)
       (sort)
       (reverse)
       (vec)))

(defn read-hand [raw-hand values]
  (vec (for [[_ rank color] (re-seq #"(\d+|[JQKA])([CDHS])" raw-hand)]
         {:value (values rank)
          :color color})))

(defn score
  ([raw-hand]
   (last (sorted-set (score raw-hand values-high-as)
                     (score raw-hand values-low-as))))
  ([raw-hand values]
   (-> raw-hand
       (read-hand values)
       ((juxt category highcards)))))

(defn max-by-score [raw-hands]
  (->> raw-hands
       (group-by score)
       (into (sorted-map))
       (vals)
       (last)))

(defn best-hands [hands]
  (max-by-score hands))