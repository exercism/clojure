(ns list-ops)

(defn append 
  "Given two collections, it adds all the items in the second collection to the end of the first collection"
  [coll1 coll2]
  ;; your code goes here
)

(defn concatenate 
  "Given a series of collections, it combines all the collections into one flattened collection"
  [colls]
  ;; your code goes here
)

(defn select-if
  "Given a predicate and a collection, it returns the collection of all items for which predicate(item) is true"
  [pred coll]
  ;; your code goes here
)

(defn length 
  "Given a collection, it returns the number of items within it"
  [coll]
  ;; your code goes here
)

(defn apply-to-each 
  "Given a function and a collection, it returns the collection of the results of applying function(item) on all items"
  [f coll]
  ;; your code goes here
)

(defn foldl 
  "Given a function, a collection, and initial accumulator, it folds (reduces) each item into the accumulator from the left"
  [f coll init]
  ;; your code goes here
)

(defn foldr
  "Given a function, a collection, and an initial accumulator, it folds (reduces) each item into the accumulator from the right"
  [f coll init]
  ;; your code goes here
)

(defn reverse-order 
  "Given a collection, it returns a collection with all the original items, but in reverse order"
  [coll]
  ;; your code goes here
)
