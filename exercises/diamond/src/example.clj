(ns diamond)

(defn- pad [x]
  (apply str (repeat x " ")))

(defn- one-row [letter [inner-pedding outer-pedding]]
  (if (= inner-pedding 0)
    (str (pad outer-pedding) letter (pad outer-pedding))
    (str (pad outer-pedding) letter (pad inner-pedding) letter (pad outer-pedding))))

(defn- row-peddings [num-letters]
  (let [inner-pedding (conj (iterate (partial + 2) 1) 0)
        outer-pedding (iterate dec (dec num-letters))]
    (take num-letters (map vector inner-pedding outer-pedding))))

(defn diamond [c]
  (let [alphabet (map char (range (int \A) (inc (int \Z))))
        num-letters (- (int c) (dec (int \A)))
        top-row (map one-row alphabet (row-peddings num-letters))]
    (concat top-row (rest (reverse top-row)))))

