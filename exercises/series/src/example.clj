(ns series)

(defn slices [string n]
  (if (zero? n)
    [""]
    (loop [string string, acc []]
      (if (< (count string) n)
        acc
        (recur (rest string) (conj acc (apply str (take n string))))))))
