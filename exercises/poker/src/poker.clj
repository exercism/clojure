(ns poker
  (:require [clojure.string :as cs]))

(defn times [x xs]
  (count (filter #{x} xs)))

(defn rank-hand [hand]
  (let [h   (cs/split (cs/replace hand #"10" "T") #" ")
        r   (map #(.indexOf (seq "..23456789TJQKA") (first %)) h)
        nr  (distinct r)
        gs  (reverse (sort-by vec (map vector (map #(times % r) nr) nr)))
        cs  (mapv first gs)
        rs  (if (= (mapv second gs) [14,5,4,3,2]) [5,4,3,2,1] (mapv second gs))
        srt (and (= 5 (count cs)) (= 4 (- (apply max cs) (apply min cs))))
        fsh (= 1 (count (distinct (map last h))))]        
    (cond (= 5 cs)         [9 rs]
          (and srt fsh)    [8 rs]
          (= cs [4 1])     [7 rs]
          (= cs [3 2])     [6 rs]
          fsh              [5 rs]
          srt              [4 rs]
          (= cs [3 1 1])   [3 rs]
          (= cs [2 2 1])   [2 rs]
          (= cs [2 1 1 1]) [1 rs]
          :else            [0 rs])))

(defn greater-than [xs ys]
  (or (> (first xs) (first ys))
      (->> (map compare (second xs) (second ys))
           (take-while (partial not= -1))
           (some (partial = 1)))))

(defn best-hands [hands]
  (loop [m [0 []], r [], hs hands]
    (if (empty? hs)
      r
      (let [[x xs] ((juxt first rest) hs)
            rank   (rank-hand x)]
        (cond
          (or (empty? r) (greater-than rank m)) (recur rank [x] xs)
          (= rank m)                            (recur m (conj r x) xs)
          :else                                 (recur m r xs))))))
