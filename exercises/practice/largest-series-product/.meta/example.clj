(ns largest-series-product)

(defn validate-input
  [n digits]
  (cond
    (neg? n) (throw (IllegalArgumentException. "span must not be negative"))
    (> n (count digits)) (throw (IllegalArgumentException. "span must not exceed string length"))
    (not-every? #(<= 0 % 9) digits) (throw (IllegalArgumentException. "digits input must only contain digits"))
    :else true))

(defn largest-product
  [n s]
  (let [digits (map #(Character/digit ^char % 10) s)]
    (do
      (validate-input n digits)
      (->> digits
           (partition n 1)
           (map #(reduce * %))
           (apply max)))))
