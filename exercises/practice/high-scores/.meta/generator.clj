(ns high-scores-generator)

(defn update-test-case [test-case]
  (-> test-case
      (update-in [:input :scores] #(apply list %))
      (update-in [:expected] #(if (vector? %) (apply list %) %))))
