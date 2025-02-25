(ns run-length-encoding)

(defn encode-group
  [group]
  (let [n (count group)]
    (if (> n 1)
      (str n (first group))
      (str (first group)))))

(defn run-length-encode
  [s]
  (->> s
       (into [] (comp (partition-by identity) (map encode-group)))
       (apply str)))

(defn decode-rule
  [[_ n ch]]
  (let [len (Integer/parseInt (or (not-empty n) "1"))]
    (apply str (repeat len ch))))

(defn run-length-decode
  [s]
  (->> s
       (re-seq #"(\d*)(\D)")
       (map decode-rule)
       (apply str)))
