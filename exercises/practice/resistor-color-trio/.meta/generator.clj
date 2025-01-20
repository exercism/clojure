(ns resistor-color-trio-generator)

(defn update-test-case [test-case]
  (update test-case :expected #(str (:value %) " " (:unit %))))
