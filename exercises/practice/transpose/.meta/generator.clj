(ns transpose-generator)

(defn update-test-case [test-case]
  (if (= "empty string" (:description test-case))
    (-> test-case
        (assoc-in [:input :lines] [""])
        (assoc :expected [""]))
    test-case))
