(ns bracket-push)

(defn valid? [s]
  (let [pairs { \) \( \] \[ \} \{ }]
    (loop [stack [] [x & xs :as s] s]
      (cond (empty? s) (empty? stack)
            (#{ \( \[ \{ } x) (recur (conj stack x) xs)
            (#{ \) \] \} } x) (if (= (peek stack) (pairs x))
                                (recur (pop stack) xs)
                                false)
            :else (recur stack xs)))))
