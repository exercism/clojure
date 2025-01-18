(ns sum-of-multiples-generator)

(defn update-test-case [test-case]
  (update-in test-case [:input :factors] #(apply list %)))
