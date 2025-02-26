(ns change-generator)

(defn- update-expected [expected]
  (if (:error expected)
    expected
    (apply list expected)))

(defn- error [expected]
  (when-let [error (:error expected)]
    (str "^" error "$")))

(defn- update-input [input]
  (update input :coins #(into (sorted-set) %)))

(defn update-test-case [test-case]
  (-> test-case
      (update :expected update-expected)
      (update :input update-input)
      (assoc :error (error (:expected test-case)))))
