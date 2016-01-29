(ns largest-series-product)

(defn digits [ds] (map #(Character/digit % 10) ds))

(defn slices [n ds] (partition n 1 (digits ds)))

(defn largest-product [size ds]
  (cond
    (zero? size)        1
    (> size (count ds)) (throw (Exception. "Span must not exceed length."))
    :else               (apply max (map (partial apply *) (slices size ds)))))
