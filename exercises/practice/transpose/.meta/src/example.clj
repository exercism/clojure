(ns transpose)

(defn pad-lines
  [lines]
  (if-let [rev-lines (seq (reverse lines))]
    (loop [reversed-lines (rest rev-lines)
           padded-lines [(first rev-lines)]]
      (if (seq reversed-lines)
        (let [diff (- (.length (peek padded-lines)) (.length (first reversed-lines)))]
          (if (pos? diff)
            (recur (rest reversed-lines) (conj padded-lines (str (first reversed-lines) (apply str (repeat diff " ")))))
            (recur (rest reversed-lines) (conj padded-lines (first reversed-lines)))))
        (reverse padded-lines)))
    []))


(defn transpose
  [s]
  (let [padded-lines (-> s clojure.string/split-lines pad-lines)]
    (loop [result []
           padded-lines padded-lines]
      (if (seq (first padded-lines))
        (recur (conj result (map first padded-lines))
               (map rest padded-lines))
        (clojure.string/join "\n" (map #(apply str %) result))))))
