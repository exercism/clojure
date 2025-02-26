(ns hamming-generator)

(defn update-test-case [test-case]
  (if-let [error (get-in test-case [:expected :error])]
    (assoc test-case :error (str "^" error "$"))
    test-case))
