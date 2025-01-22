(ns diamond-generator)

(defn update-test-case [test-case]
  (update-in test-case [:input :letter] first))
