A `vector` in Clojure is a sequential, indexed, immutable collection of zero or more values. This means that once a vector has been created, it cannot be modified. Functions for operating on vectors will return a new vector, while the original vector remains unchanged. The values in a vector may be of heterogenous types. Vectors can be defined as follows:

```clojure
(def empty [])
(def single-value 5)
(def single-value-alternative (vector 5))
(def three-values [a b c]
```

Elements can be retrieved from a vector using an index. Clojure vectors are zero-based, meaning that the first element's index is always zero:

```clojure
(def numbers [2 3 5])
;; Read value from vector
(get numbers 2)
;;=> 5
;; Update value in vector
(assoc numbers 2 9)
;;=> [2 3 9]
```

The original vector is unchanged:

```clojure
numbers
;;=> [2 3 5]
```

To remember the updated value, we need to pass it along or capture it in a var:

```clojure
(def updated-numbers
  (assoc numbers 2 9))
(get updated-numbers 2)
;;=> 9
```
