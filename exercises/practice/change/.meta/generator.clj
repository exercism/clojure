(ns change-generator)

(defn- update-expected [expected]
  (if-let [error (:error expected)]
    {:error (str "^" error "$")}
    (apply list expected)))

(defn- update-input [input]
  (update input :coins #(into (sorted-set) %)))

(defn- update-test-case [test-case]
  (-> test-case
      (update :expected update-expected)
      (update :input update-input)))
