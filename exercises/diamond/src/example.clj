(ns diamond)

(def alphabet (map char (range (int \A) (inc (int \Z)))))

(defn- pad [x]
  (apply str (repeat x " ")))

(defn- one-row [letter [inner-padding outer-padding]]
  (if (= inner-padding 0)
    (str (pad outer-padding) letter (pad outer-padding))
    (str (pad outer-padding) letter (pad inner-padding) letter (pad outer-padding))))

(defn- row-paddings [num-letters]
  (let [inner-padding (conj (iterate (partial + 2) 1) 0)
        outer-padding (iterate dec (dec num-letters))]
    (take num-letters (map vector inner-padding outer-padding))))

(defn diamond [c]
  (let [num-letters (- (int c) (dec (int \A)))
        top-half (map one-row alphabet (row-paddings num-letters))]
    (concat top-half (rest (reverse top-half)))))

