(ns interest-is-interesting)

(defn interest-rate [balance]
  (cond 
    (< balance 0.0M) -3.213
    (< balance 1000.0M) 0.5
    (< balance 5000.0M) 1.621
    :else 2.475))

(defn- annual-yield [balance]
  (let [multiplier (bigdec (/ (interest-rate balance)
                              100))]
    (* (abs balance) multiplier)))

(defn annual-balance-update [balance]
  (+ balance (annual-yield balance)))

(defn amount-to-donate [balance tax-free-percentage]
  (if (> balance 0.0M)
    (int (* balance
            (* 2.0 (/ tax-free-percentage 100.0))))
    0))
