(ns poker
  (:require [clojure.string :as cs]))

(defn rank-hand [hand]
  (let [h (cs/split (cs/replace hand #"10" "T") #" ")
        initial-ranks (map #(.indexOf (seq "..23456789TJQKA") (first %)) h)
        score-frec (reverse (sort-by vec (map (comp vec reverse)
                                              (frequencies initial-ranks))))
        rank-counts (mapv first score-frec)
        normalized-ranks (if (= (mapv second score-frec) [14,5,4,3,2]) [5,4,3,2,1]
                             (mapv second score-frec))
        straight? (and (= 5 (count rank-counts))
                       (= 4 (- (apply max rank-counts) (apply min rank-counts))))
        flush? (= 1 (count (distinct (map last h))))]
    (cond (= 5 rank-counts)         [9 normalized-ranks]
          (and straight? flush?)    [8 normalized-ranks]
          (= rank-counts [4 1])     [7 normalized-ranks]
          (= rank-counts [3 2])     [6 normalized-ranks]
          flush?                    [5 normalized-ranks]
          straight?                 [4 normalized-ranks]
          (= rank-counts [3 1 1])   [3 normalized-ranks]
          (= rank-counts [2 2 1])   [2 normalized-ranks]
          (= rank-counts [2 1 1 1]) [1 normalized-ranks]
          :else                     [0 normalized-ranks])))

(defn greater-than [xs ys]
  (or (> (first xs) (first ys))
      (->> (map compare (second xs) (second ys))
           (take-while (partial not= -1))
           (some (partial = 1)))))

(defn best-hands [hands]
  (-> (fn [[max-rank record hands]]
        (let [[x & xs] hands
              rank     (rank-hand x)]
          (cond
            (or (empty? record) (greater-than rank max-rank)) [rank [x] xs]
            (= rank max-rank) [max-rank (conj record x) xs]
            :else [max-rank record xs])))
      (iterate  [[0 []] [] hands])
      (nth (count hands))
      (second)))
