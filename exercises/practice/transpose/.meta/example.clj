(ns transpose)

(defn pad-lines
  [lines]
  (if-let [reversed-lines (seq (reverse lines))]
    (loop [rev-lines (rest reversed-lines)
           padded-lines [(first reversed-lines)]]
      (if (seq rev-lines)
        (let [diff (- (.length (peek padded-lines)) (.length (first rev-lines)))
              new-padded-line (str (first rev-lines) (apply str (repeat diff " ")))]
          (recur (rest rev-lines) (conj padded-lines new-padded-line)))
        (rseq padded-lines)))
    []))

(defn transpose
  [s]
  (loop [result []
         padded-lines (-> s clojure.string/split-lines pad-lines)]
    (if (seq (first padded-lines))
      (recur (conj result (map first padded-lines)) (map rest padded-lines))
      (clojure.string/join "\n" (map #(apply str %) result)))))
