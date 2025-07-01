# Introduction

In its most basic form, the higher-order function `map` accepts two arguments: a function `f` and a collection `coll`.

Given `f` and `coll`, `map` applies `f` to each element of `coll`, returning a list of the results in the same order.

```clojure
(map inc [1 2 3]) ; => (2 3 4)
```

The previous example applies the function `inc` to each element of the vector and returns the result as the list `(2 3 4)`.

Let's see another example where we greet someone with the message "Welcome":

```clojure
(defn say-welcome 
  [name]
  (str "Welcome " name "!"))

(map say-welcome ["Chris" "Jane" "Peter"]) ; => ("Welcome Chris!" "Welcome Jane!" "Welcome Peter!")
```

## Returning a lazy sequence

Previously we provided a simplified explanation of how `map` operates.

In reality, `map` does not return a list but a *lazy* sequence.

This essentially means that the elements of the resulting sequence are not generated until they are actually needed.

In other words, the function `f` passed to `map` is not applied until the elements of the resulting sequence are requested, for example, by printing them or retrieving their values.

This is advantageous when `f` is computationally expensive and only some elements are actually needed.

## Multiple collections

`map` allows multiple collections to be passed as input.

If the number of collections passed is `n`, the function `f` will receive `n` arguments, one from each collection.

The result is a sequence where the i-th element is obtained by applying `f` to the `n` elements at position i from each collection.

```clojure
(def coll_a [a1 a2])
(def coll_b [b1 b2])
(def coll_c [c1 c2])
(map f coll_a coll_b coll_c) ; => ((f a1 b1 c1) (f a2 b2 c2))
```

