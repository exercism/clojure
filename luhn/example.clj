(ns luhn)

(defn to-reversed-digits
  "returns a lazy sequence of least to most significant digits of n"
  [n]
  (->> [n 0]
       (iterate (fn [[i _]] [(quot i 10) (mod i 10)]))
       (take-while #(not= [0 0] %))
       (map second)
       rest))

(defn checksum
  "returns the luhn checksum of n, assuming it has a check digit"
  [n]
  (->> n
       to-reversed-digits
       (map #(* %1 %2) (cycle [1 2]))
       (map #(if (>= % 10) (- % 9) %))
       (apply +)
       (#(mod % 10))))

(defn valid?
  "whether n has a valid luhn check-digit"
  [n]
  (= 0 (checksum n)))

(defn add-check-digit
  "given a number, adds a luhn check digit at the end"
  [n]
  (let [n-shifted (* 10 n)
        check-digit (- 10 (checksum n-shifted))]
    (+ n-shifted check-digit)))
