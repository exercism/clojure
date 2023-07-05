(ns zipper)

(defn from-trail [tree last]
  (if (= (nth last 0) "left")
    {:value (nth last 1), :left tree, :right (nth last 2)}
    {:value (nth last 1), :left (nth last 2), :right tree}))

(defn from-tree [tree]
  {:tree tree :trail []})

(defn value [z]
  (:value (:tree z)))

(defn zipper [tree trail]
  {:tree tree :trail trail})

(defn left [z]
  (when (:left (:tree z))
    (zipper (:left (:tree z))
            (conj [["left" (:value (:tree z)) (:right (:tree z))]]
                  (:trail z)))))
(defn right [z]
  (when (:right (:tree z))
    (zipper (:right (:tree z))
            (conj [["right" (:value (:tree z)) (:left (:tree z))]]
                  (:trail z)))))

(defn rebuild-tree [tree trail]
  (if (= 0 (count trail))
    tree
    (recur (from-trail tree (first trail)) (fnext trail))))

(defn to-tree [z]
  (rebuild-tree (:tree z) (:trail z)))

(defn up [z]
  (when-not (zero? (count (:trail z)))
    (zipper (from-trail (:tree z) (first (:trail z)))
            (fnext (:trail z)))))

(defn set-value [z value]
  (zipper {:value value,
           :left  (:left (:tree z)),
           :right (:right (:tree z))}
          (:trail z)))

(defn set-left [z left]
  (zipper {:value (:value (:tree z)),
           :left  left,
           :right (:right (:tree z))}
          (:trail z)))

(defn set-right [z right]
  (zipper {:value (:value (:tree z)),
           :left  (:left (:tree z)),
           :right right}
          (:trail z)))
