(ns saddle-points-generator)

(defn- transform-expected [expected]
  (->> expected
       (map #((juxt :row :column) %))
       (set)))

(defn- transform-input [input]
  (update input :matrix #(if (empty? (flatten %)) [] %)))

(defn- transform-test-case [test-case]
  (-> test-case
      (update :input transform-input)
      (update :expected transform-expected)))
