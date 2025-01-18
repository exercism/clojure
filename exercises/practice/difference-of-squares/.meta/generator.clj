(ns difference-of-squares-generator)

(defn update-test-case [test-case]
  (update test-case :path #(take-last 1 %)))
