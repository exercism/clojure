(ns all-your-base)

(defn- digits->decimal
  "Converts a sequence of digits given in input-base into decimal format."
  [input-base digits]
  (loop [sum 0
         [num & nums] digits]
    (if num
      (recur (+ (* sum input-base) num) nums)
      sum)))

(defn- decimal->digits
  "Converts a decimal number into a sequence of digits in the desired output base."
  [output-base number]
  (loop [digits nil
         num number]
    (if (zero? num)
      digits
      (recur (conj digits (mod num output-base)) (quot num output-base)))))

(defn convert
  "Converts a sequence of digits given in input-base into a sequence of digits in the desired output-base."
  [input-base digits output-base]
  (cond
    (some #(< % 2) (list input-base output-base)) nil
    (not-every? #(and (not (neg? %)) (< % input-base)) digits) nil
    (empty? digits) ()
    (every? #(zero? %) digits) '(0)
    :else (->> digits
               (digits->decimal input-base)
               (decimal->digits output-base))))
