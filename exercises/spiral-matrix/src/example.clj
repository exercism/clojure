(ns spiral-matrix)

(defn spiral-matrix [m n & [s]]
  (let [row (list (map #(+ s %) (range m)))]
    (if (= 1 n) row
        (->> (spiral-matrix (dec n) m (+ s m))
             (apply map list)
             (map reverse)
             (concat row)))))

(defn spiral [n] (if (zero? n) '() (spiral-matrix n n 1)))
