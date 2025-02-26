(ns difference-of-squares-generator)

(defn update-test-case [test-case]
  (assoc test-case :context (:description test-case)))
