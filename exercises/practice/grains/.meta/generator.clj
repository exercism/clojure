(ns grains-generator)

(defn update-test-case [test-case]
  (assoc test-case :context (:description test-case)))
