(ns change)

(def algo
  (memoize (fn [amount coins]
             (let [smaller (filter #(<= % amount) coins)]
               (if (empty? smaller) [amount]
                 (apply min-key
                        count
                        ; check if valid solution, i.e. the final amount was zero
                        (filter (comp zero? first)
                                (map
                                  (fn [coin]
                                    (concat
                                      (algo (rem amount coin) smaller)
                                      (repeat (quot amount coin) coin)))
                                  smaller))))))))

(defn issue [amount coins] 
  (try
    (let [[x & xs] (algo amount coins)]
      (if (zero? x) xs
        (throw (IllegalArgumentException. "cannot change"))))
    ; thrown by apply min-key if we don't have the right coins to issue change
    (catch clojure.lang.ArityException e (throw (IllegalArgumentException. "cannot change")))))
