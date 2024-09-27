(ns list-ops)

(defn append 
  "Given two lists, adds all the items in the second list to the end of the first list"
  [coll1 coll2]
  ;; your code goes here
)

(defn concatenate 
  "Given a series of lists, combines all the lists into one flattened list"
  [coll]
  ;; your code goes here
)

(defn select-if
  "Given a predicate and a list, returns the list of all items for which `predicate(item)` is True"
  [pred coll]
  ;; your code goes here
)

(defn length 
  "Given a list, returns the number of items within it"
  [coll]
  ;; your code goes here
)

(defn apply-to-each 
  "Given a function and a list, returns the list of the results of applying `function(item)` on all items"
  [f coll]
  ;; your code goes here
)

(defn foldl 
  "Given a function, a list, and initial accumulator, folds (reduces) each item into the accumulator from the left"
  [f coll init]
  ;; your code goes here
)

(defn foldr [f coll init]
  "Given a function, a list, and an initial accumulator, folds (reduces) each item into the accumulator from the right"
  ;; your code goes here
)

(defn reverse-order 
  "Given a list, returns a list with all the original items, but in reverse order"
  [coll]
  ;; your code goes here
)
