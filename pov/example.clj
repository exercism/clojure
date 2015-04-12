(ns pov
  (:require [clojure.zip :as zip]))

(defn- remove-child
  "Remove a child from a node"
  [parent child]
  (filter #(not= child %) parent))

(defn- reparent
  "Take a node, and make it the parent of its parent"
  [loc]
  (let [current (zip/node loc)
        parent (zip/up loc)
        belonged-to (when parent
                      (-> parent
                          (zip/edit remove-child current)
                          reparent
                          list))]
    (vec (concat current belonged-to))))

(defn- find-node
  "Find the node whose identifier matches the given value"
  [v tree]
  (loop [loc (-> tree zip/vector-zip zip/next)]
    (cond (= v (zip/node loc)) (zip/up loc)
          (zip/end? loc) nil
          :else (recur (zip/next loc)))))

(defn of
  "Find a node by its identifier and raise to the root"
  [s tree]
  (when-let [loc (find-node s tree)]
    (reparent loc)))

