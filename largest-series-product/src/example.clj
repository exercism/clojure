(ns largest-series-product)

(defn digits [ds] (map #(Character/digit % 10) ds))

(defn slices [n ds] (partition n 1 (digits ds)))

(defn largest-product [size ds]
  (cond
    (empty? ds)         (throw (Exception. "Series must not be empty."))
    (> size (count ds)) 1
    :else               (apply max (map (partial apply *) (slices size ds)))))
