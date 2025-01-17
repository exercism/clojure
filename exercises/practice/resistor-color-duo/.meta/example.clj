(ns resistor-color-duo)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn- color-code [color] (.indexOf colors color))

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [[color-1 color-2]]
  (+ (* 10 (color-code color-1)) (color-code color-2)))
