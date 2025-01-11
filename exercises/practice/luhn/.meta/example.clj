(ns luhn)

(defn string->digits
  [s]
  (map #(Character/digit ^char % 10) s))

(defn valid-integer?
  [digits]
  (and (> (count digits) 1)
       (every? #(<= 0 % 9) digits)))

(defn zero-pad
  [digits]
  (if (even? (count digits))
    digits
    (conj digits 0)))

(defn transform-digit
  [index val]
  (if (odd? index)
    val
    (let [dval (* 2 val)]
      (if (> dval 9)
        (- dval 9)
        dval))))

(defn get-luhn-value
  [digits]
  (let [padded-digits (zero-pad digits)]
    (->> padded-digits
         (map-indexed transform-digit)
         (reduce +))))

(defn valid-luhn-value?
  [val]
  (int? (/ val 10)))

(defn remove-spaces
  [s]
  (remove #{\space} s))

(defn valid?
  "Returns true if the given string represents a valid luhn number, else false"
  [s]
  (let [digits (string->digits (remove-spaces s))]
    (and (valid-integer? digits)
         (valid-luhn-value? (get-luhn-value digits)))))
