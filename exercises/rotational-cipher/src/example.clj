(ns rotational-cipher)

(defn ^:private spinner [s a]
  (let [a (int a)
        spin (fn [c] (mod (+ c s) 26))]
    (fn [c]
      (let [c (- (int c) a)]
        (char (+ (spin c) a))))))

(defn ^:private upper-spinner [s]
  (spinner s \A))

(defn ^:private lower-spinner [s]
  (spinner s \a))

(defn ^:private cipher [spin]
  (let [upper-spin (upper-spinner spin)
        lower-spin (lower-spinner spin)]
    (fn [c]
      (cond
        (Character/isUpperCase c) (upper-spin c)
        (Character/isLowerCase c) (lower-spin c)
        :default c))))

(defn rotate [text spin]
  (let [cipher (cipher spin)]
    (apply str (map cipher text))))
