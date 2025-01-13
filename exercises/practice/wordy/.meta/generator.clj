(ns wordy-generator)

(defn transform-test-case [test-case]
  (if (= "Non math question" (:description test-case))
    (assoc-in test-case [:expected :error] "syntax error")
    test-case))
