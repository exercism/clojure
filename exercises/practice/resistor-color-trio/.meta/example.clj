(ns resistor-color-trio)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn- color->value [color] (.indexOf colors color))

(defn- pow [a b] (reduce * (repeat b a)))

(defn- colors->value [colors]
  (let [[value-1 value-2 value-3] (map color->value colors)]
    (* (+ (* 10 value-1) value-2) (pow 10 value-3))))

(def units [nil "kilo" "mega" "giga"])

(defn unit-label [[amount unit]] (str amount " " unit "ohms"))

(defn resistor-label [colors]
  (let [value (colors->value colors)]
    (->> units
         (map-indexed vector)
         (some
          (fn [[idx unit]]
            (when (<= value (pow 1000 (inc idx)))
              [(quot value (pow 1000 idx)) unit])))
         (unit-label))))
