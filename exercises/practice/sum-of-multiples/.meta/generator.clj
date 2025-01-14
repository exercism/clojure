(ns sum-of-multiples-generator)

(defn- transform-test-case [test-case]
  (update-in test-case [:input :factors] #(into '() %)))

(defn transform [test-cases]
  (map transform-test-case test-cases))
