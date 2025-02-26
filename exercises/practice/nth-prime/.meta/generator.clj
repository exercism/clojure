(ns nth-prime-generator)

(defn- error [expected]
  (when-let [error (:error expected)]
    (str "^" error "$")))

(defn update-test-case [test-case]
  (-> test-case
      (assoc :error (error (:expected test-case)))))
