(ns complex-numbers)

(defn real [[a _]] a)

(defn imaginary [[_ b]] b)

(defn abs [[a b]] (Math/sqrt (apply + (map #(Math/pow % 2) [a b]))))

(defn conjugate [[a b]] [a (- b)])

(defn add [[a b] [c d]] [(+ a c) (+ b d)])

(defn sub [[a b] [c d]] [(- a c) (- b d)])

(defn mul [[a b] [c d]] [(- (* a c) (* b d)) (+ (* a d) (* b c))])

(defn div [[a b] [c d]]
  (let [denominator (apply + (map #(Math/pow % 2) [c d]))]
    [(/ (+ (* a c) (* b d)) denominator)
     (/ (- (* b c) (* a d)) denominator)]))
