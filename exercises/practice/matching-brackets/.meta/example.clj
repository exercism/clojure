(ns matching-brackets)

(defn valid? [s]
  (let [pairs {\) \( \] \[ \} \{}
        opening (set (vals pairs))
        closing (set (keys pairs))]
    (loop [stack [] [x & xs :as s] s]
      (cond (empty? s) (empty? stack)
            (opening x) (recur (conj stack x) xs)
            (closing x) (if (= (peek stack) (pairs x))
                          (recur (pop stack) xs)
                          false)
            :else (recur stack xs)))))
