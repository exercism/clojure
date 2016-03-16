(ns largest-series-product)

(defn- char->digit [c]
  {:pre [(Character/isDigit c)]}
  (Character/digit c 10))

(defn- digits [ds] (map char->digit ds))

(defn- slices [n ds] (partition n 1 (digits ds)))

(defn largest-product [size ds]
  (cond
    (zero? size)        1
    (> size (count ds)) (throw (Exception. "Span must not exceed length."))
    :else               (apply max (map (partial apply *) (slices size ds)))))
