(ns spiral-matrix)

(defn spiral-matrix [m n & [s]]
  (let [row (list (map #(+ s %) (range m)))]
    (if (= 1 n) row
      (concat row (map reverse
                       (apply map list
                              (spiral-matrix (dec n) m (+ s m))))))))

(defn spiral [n] (if (zero? n) '() (spiral-matrix n n 1)))
