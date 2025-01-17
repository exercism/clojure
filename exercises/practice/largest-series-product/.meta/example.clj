(ns largest-series-product)

(defn check-input
  [n digits]
  (cond
    (neg? n) (throw (IllegalArgumentException. "span must not be negative"))
    (or (> n (count digits)) (and (pos? n) (empty? digits))) (throw (IllegalArgumentException. "span must be smaller than string length"))
    (and (pos? n) (empty? digits)) (throw (IllegalArgumentException. "span must be smaller than string length"))
    (not-every? #(<= 0 % 9) digits) (throw (IllegalArgumentException. "digits input must only contain digits"))
    :else false))

(defn largest-product
  [n s]
  (let [digits (map #(Character/digit ^char % 10) s)]
    (or (check-input n digits)
        (if (zero? n)
          1
          (->> digits
               (partition n 1)
               (map #(reduce * %))
               (apply max))))))
