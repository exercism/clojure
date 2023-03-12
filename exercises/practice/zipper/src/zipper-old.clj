(ns zipper)

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

(defn to_zip [root]
  [root nil])

(defn node [loc] (loc 0))

(defn branch? [loc]
  (or (map? (node loc)) (map? (nth (node loc) 1))))

(defn children [loc]
  (if (branch? loc)
    (seq (if (map? (node loc)) (node loc) (nth (node loc) 1)))
    (throw (Exception. "called children on a leaf node"))))

(defn make-node [node children]
     (if (map? node)
       (into {} children)
       (assoc node 1 (into {} children))))

(defn down [loc]
  (when (branch? loc)
    (let [[node path] loc
          [c & cnext :as cs] (children loc)]
      (when cs
        [c {:l []
            :pnodes (if path (conj (:pnodes path) node) [node])
            :ppath path
            :r cnext}]))))

(defn next [loc]
  (let [[node {l :l  [r & rnext :as rs] :r :as path}] loc]
    (when (and path rs)
      [r (assoc path :l (conj l node) :r rnext)])))

(defn prev [loc]
  (let [[node {l :l r :r :as path}] loc]
    (when (and path (seq l))
      [(peek l) (assoc path :l (pop l) :r (cons node r))])))

(defn path [loc]
  (:pnodes (loc 1)))

(defn up [loc]
  (let [[node {l :l, ppath :ppath, pnodes :pnodes r :r, changed? :changed?, :as path}] loc]
    (when pnodes
      (let [pnode (peek pnodes)]
        (if changed?
          [(make-node pnode (concat l (cons node r)))
           (and ppath (assoc ppath :changed? true))]
          [pnode ppath])))))

(defn to_tree [loc]
  (if (= :end (loc 1))
    (node loc)
    (let [p (up loc)]
      (if p
        (recur p)
        (node loc)))))

(defn replace
  "Replaces the node at this loc, without moving"
  [loc node]
  (let [[_ path] loc]
    [node (assoc path :changed? true)]))

(defn edit
  "Replaces the node at this loc with the value of (f node args)"
  [loc f & args]
  (replace loc (apply f (node loc) args)))


(defn left
  "Takes a zipper with the focus at a tree node,
   returns a new zipper navigated to its left child.
   If no left child, returns nil."
  [z]
  (let [l (some #(when (= :left (ffirst %)) %) (iterate next (down z)))]
    (when-not (nil? (first (nfirst l))) l)))

(defn right
  "Takes a zipper with the focus at a tree node,
   returns a new zipper navigated to its right child.
   If no right child, returns nil."
  [z]
  (let [r (some #(when (= :right (ffirst %)) %) (iterate next (down z)))]
    (when-not (nil? (first (nfirst r))) r)))

(defn value
  "Takes a zipper with the focus at a tree node,
   returns its value."
  [z]
  (first (nfirst
          (some #(when (= :value (ffirst %)) %) 
                (iterate next (down z))))))

(defn set_value [z x]
  (replace z [:value x]))

(edit (-> tree
          to_zip
          left
          down) )

(-> tree
    to_zip
    left
    
    ;(set_value 5)
    ;to_tree
    )

;; expected output after set_value
{:value 1 :left  {:value 5
                  :left  nil 
                  :right {:value 3 :left  nil :right nil}}
 :right {:value 4 :left  nil :right nil}}

(-> tree
    to_zip
    left
    ;(set_value 5)
    ;to_tree
    )

(left (to_zip tree))

(defn set_left [z x])

(defn set_right [z x])

(comment 
  
  
  (-> tree
      to_zip
      left
      ;right
      ;value
      ))