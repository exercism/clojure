(ns zipper)

(def t1 {:value 1, :left {:value 2, :left nil, :right {:value 3, :left nil, :right nil}}, :right {:value 4, :left nil, :right nil}})

(defn fromTrail [tree last]
  (if (= (nth last 0) "left")
    {:value (nth last 1), :left tree, :right (nth last 2)}
    {:value (nth last 1), :left (nth last 2), :right tree}))

(defn fromTree [tree]
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

(defn rebuildTree [tree trail]
  (if (= 0 (count trail)) 
    tree
    (rebuildTree (fromTrail tree (first trail)) (fnext trail))))

(defn toTree [z]
  (rebuildTree (:tree z) (:trail z)))

(defn up [z]
  (when-not (zero? (count (:trail z)))
    (zipper (fromTrail (:tree z) (first (:trail z)))
            (rest (:trail z)))))

(def z {:tree
        {:value 1,
         :left {:value 2, :left nil, :right {:value 3, :left nil, :right nil}},
         :right {:value 4, :left nil, :right nil}},
        :trail []})

(defn setValue [z value]
  (zipper {:value value,
           :left  (:left (:tree z)),
           :right (:right (:tree z))}
          (:trail z)))

(defn setLeft [z left]
  (zipper {:value (:value (:tree z)),
           :left  left,
           :right (:right (:tree z))}
          (:trail z)))

(defn setRight [z right]
  (zipper {:value (:value (:tree z)),
           :left  (:left (:tree z)),
           :right right}
          (:trail z)))


(-> t1
    fromTree
    ;up
    )