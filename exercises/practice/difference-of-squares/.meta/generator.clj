(ns difference-of-squares-generator)

(defn- update-path [path]
  (take-last 1 path))

(defn transform [test-cases]
  (map #(update % :path update-path) test-cases))
