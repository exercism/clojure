(ns zipper)

(defn to_zip [root]
  [root nil])

(defn zipper [branch? children make-node root]
  ^{:zip/branch? branch? :zip/children children :zip/make-node make-node}
  [root nil])

(defn node [loc] (loc 0))

(defn branch? [loc]
  ((:zip/branch? (meta loc)) (node loc)))

(defn children [loc]
  (if (branch? loc)
    ((:zip/children (meta loc)) (node loc))
    (throw (Exception. "called children on a leaf node"))))

(defn make-node [loc node children]
  ((:zip/make-node (meta loc)) node children))

(defn down [loc]
  (when (branch? loc)
    (let [[node path] loc
          [c & cnext :as cs] (children loc)]
      (when cs
        (with-meta [c {:l []
                       :pnodes (if path (conj (:pnodes path) node) [node])
                       :ppath path
                       :r cnext}] (meta loc))))))

(defn next [loc]
  (let [[node {l :l  [r & rnext :as rs] :r :as path}] loc]
    (when (and path rs)
      (with-meta [r (assoc path :l (conj l node) :r rnext)] (meta loc)))))

(defn prev [loc]
  (let [[node {l :l r :r :as path}] loc]
    (when (and path (seq l))
      (with-meta [(peek l) (assoc path :l (pop l) :r (cons node r))] (meta loc)))))

(defn path
  "Returns a seq of nodes leading to this loc"
  {:added "1.0"}
  [loc]
  (:pnodes (loc 1)))

(defn up
  "Returns the loc of the parent of the node at this loc, or nil if at
  the top"
  {:added "1.0"}
  [loc]
  (let [[node {l :l, ppath :ppath, pnodes :pnodes r :r, changed? :changed?, :as path}] loc]
    (when pnodes
      (let [pnode (peek pnodes)]
        (with-meta (if changed?
                     [(make-node loc pnode (concat l (cons node r)))
                      (and ppath (assoc ppath :changed? true))]
                     [pnode ppath])
          (meta loc))))))

(defn to_tree [loc]
  (if (= :end (loc 1))
    (node loc)
    (let [p (up loc)]
      (if p
        (recur p)
        (node loc)))))

(defn to_zip [m]
  (zipper
   (fn [x] (or (map? x) (map? (nth x 1))))
   (fn [x] (seq (if (map? x) x (nth x 1))))
   (fn [x children]
     (if (map? x)
       (into {} children)
       (assoc x 1 (into {} children))))
   m))




(def m {:a 3 :b {:x true :y false} :c 4})

  (map? m)

(-> (to_zip m) down next node)
  
(def tree
  {:value 1
   :left  {:value 2
           :left  nil,
           :right {:value 3
                   :left  nil
                   :right nil}},
   :right {:value 4
           :left  nil
           :right nil}})

(down (to_zip tree))

(defn left [tree]
  (:left tree))

(defn right [tree]
  (:right tree))

(defn value [tree]
  (:value tree))

(-> tree
    left
    left)

(defn set_value [z x])

(defn set_left [z x])

(defn set_right [z x])