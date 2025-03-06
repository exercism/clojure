(ns grains-generator)

(defn- update-expected [expected]
  (if-let [error (:error expected)]
    {:error (str "^" error "$")}
    expected))

(defn update-test-case [test-case]
  (-> test-case
      (update :expected update-expected)
      (assoc :context (:description test-case))))
