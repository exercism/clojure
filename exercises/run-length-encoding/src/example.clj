(ns run-length-encoding)

(defn run-length-encode
  ;encodes a string with run-length-encoding
  [s]
  (apply str
         (for
           [ x (partition-by identity s)]
           (str
             (if
               (= 1 (count x)) nil (count x)) (first x)))))

(defn run-length-decode
  ;decodes a run-length-encoded string
  [s]
  (->> s
       (re-seq #"[0-9]+.|[a-zA-Z\s]")
       vec
       (mapv #(if (= (count %) 1) (str "1" %) %))
       (mapv #(vector (Integer. (reduce str "" (butlast %))) (str (last %))))
       (mapv #(apply str (repeat (first %) (second %))))
       (reduce str)))
