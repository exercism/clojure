(ns run-length-encoding)

(defn run-length-encode [s]
  "encodes a string with run-length-encoding"
  (apply str
         (for
           [ x (partition-by identity s)]
           (str
             (when-not (= 1 (count x)) (count x)) (first x)))))

(defn run-length-decode [s]
  "decodes a run-length-encoded string"
  (->> s
       (re-seq #"[0-9]+.|[a-zA-Z\s]")
       (map #(if (= (count %) 1) (str "1" %) %))
       (map #(list (Integer. (reduce str "" (butlast %))) (str (last %))))
       (map #(apply str (repeat (first %) (second %))))
       (reduce str)))