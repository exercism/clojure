(ns atbash-cipher-generator)

(defn update-test-case [test-case]
  (-> test-case
      (update :path #(take-last 1 %))))
