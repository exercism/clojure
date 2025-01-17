(ns wordy-generator)

(defn normalize-error [test-case error]
  (if (= "Non math question" (:description test-case))
    "^syntax error$"
    (str "^" error "$")))

(defn update-test-case [test-case]
  (if-let [error (get-in test-case [:expected :error])]
    (assoc-in test-case [:expected :error] (normalize-error test-case error))
    test-case))
