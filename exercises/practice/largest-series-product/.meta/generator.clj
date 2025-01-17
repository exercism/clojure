(ns largest-series-product-generator)

(defn transform-test-case [test-case]
  (if-let [error (get-in test-case [:expected :error])]
    (assoc-in test-case [:expected :error] (str "^" error "$"))
    test-case))
