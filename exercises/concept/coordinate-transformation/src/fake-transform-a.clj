(def fake-first (atom true))

(defn fake-transform [x y]
  (if @fake-first
    (do (reset! fake-first false)
        [1 1])
    false))

((memoize fake-transform) 5 5)