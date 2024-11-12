(ns isbn-verifier)

(defn- get-value
  [ch]
  (if (= ch \X)
    10
    (Character/digit ^char ch 10)))

(defn- valid-isbn-value?
  [s]
  (->> (remove #{\-} s)
       (map get-value)
       (map * (range 10 0 -1))
       (reduce +)
       (#(mod % 11))
       zero?))

(defn valid-isbn-pattern?
  [s]
  (boolean (re-matches #"\d{9}(X|\d)|\d-\d{3}-\d{5}-(X|\d)" s)))

(defn isbn?
  [s]
  (and (valid-isbn-pattern? s) (valid-isbn-value? s)))
