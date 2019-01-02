(ns sum-of-multiples)

(defn- divides?
  ([n]   (fn [d] (divides? n d)))
  ([n d] (zero? (rem n d))))

(defn sum-of-multiples [multiples n]
  (reduce (fn [sum x] (cond-> sum (some (divides? x) multiples) (+ x)))
          0 (range 1 n)))
