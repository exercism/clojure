(ns list-ops)

(declare foldl)
(declare reverse-order)

(defn append
  [coll1 coll2]
  (foldl conj coll2 coll1))

(defn concatenate
  [colls]
  (foldl append colls []))

(defn select-if
  [pred coll]
  (let [reducer (fn [acc el]
                  (if (pred el)
                    (conj acc el)
                    acc))]
    (foldl reducer coll [])))

(defn length
  [coll]
  (let [reducer (fn [acc _]
                  (inc acc))]
    (foldl reducer coll 0)))

(defn apply-to-each
  [f coll]
  (let [reducer (fn [acc el]
                  (conj acc (f el)))]
    (foldl reducer coll [])))

(defn foldl
  [f coll acc]
  (if (seq coll)
    (recur f (rest coll) (f acc (first coll)))
    acc))

(defn foldr
  [f coll acc]
  (foldl f (reverse-order coll) acc))

(defn reverse-order
  [coll]
  (loop [index (dec (length coll))
         result []]
    (if (neg? index)
      result
      (recur (dec index) (conj result (coll index))))))


;;Solves the appendix challenge
;;
;;(ns list-ops)
;;
;;(declare foldl)
;;(declare reverse-order)
;;
;;(defn append
;;  [coll1 coll2]
;;  (reverse-order (foldl conj coll2 (reverse-order coll1))))
;;
;;(defn concatenate
;;  [colls]
;;  (foldl append colls ()))
;;
;;(defn select-if
;;  [pred coll]
;;  (let [reducer (fn [acc el]
;;                  (if (pred el)
;;                    (conj acc el)
;;                    acc))]
;;    (reverse-order (foldl reducer coll ()))))
;;
;;(defn length
;;  [coll]
;;  (let [reducer (fn [acc _]
;;                  (inc acc))]
;;    (foldl reducer coll 0)))
;;
;;(defn apply-to-each
;;  [f coll]
;;  (let [reducer (fn [acc el]
;;                  (conj acc (f el)))]
;;    (reverse-order (foldl reducer coll ()))))
;;
;;(defn foldl
;;  [f coll acc]
;;  (if (seq coll)
;;    (recur f (rest coll) (f acc (first coll)))
;;    acc))
;;
;;(defn foldr
;;  [f coll acc]
;;  (foldl f (reverse-order coll) acc))
;;
;;(defn reverse-order
;;  [coll]
;;  (foldl conj coll ()))
