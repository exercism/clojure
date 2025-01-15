(ns sum-of-multiples-generator)

(defn- transform-test-case [test-case]
  (update-in test-case [:input :factors] #(apply list %)))
