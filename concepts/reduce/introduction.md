# Introduction

This concept provides a basic introduction to the `reduce` higher-order function, where we explain its most common usage form. Advanced mechanisms for using `reduce` are deferred to later concepts from our syllabus.

## Basic overview of reduce

`reduce` accepts either two or three arguments. When called with three arguments, `(reduce f val coll)` takes applies the function `f` to the value `val` and to the first element `x_1` of the collection `coll`, `(f val x_1)`, then applies the function `f` to its own result and the second element `x_2` of the collection `coll`, `(f (f val x_1) x_2)`, then again to its previous result and the third element of `coll`, and so on until all the elements of `coll` are used. Let's see a typical example using function `+`:

```clojure
(reduce + 100 [1 2 3 4]) 
;=> (+ 100 1) 
;=> (+ 101 2)
;=> (+ 103 3)
;=> (+ 106 4)
;=> 110
```

When called with only two arguments, `(reduce f coll)` applies the function `f` to the two elements, `x_1` and `x_2`, of the collection `coll`, then applies `f` to its own result and the third element `x_3` of `coll`, `(f (f x_1 x_2) x_3)`, then again to its own result and the fourth element of `coll`, and so on until all the elements of `coll` are used:

```clojure
(reduce + [1 2 3 4]) 
;=> (+ 1 2) 
;=> (+ 3 3)
;=> (+ 6 4)
;=> 10
```

In all these cases, the function `f` must accept at least two arguments, more if it accepts a variable number of arguments as in `+`. Let's see an example with a user-defined function:

```clojure
(defn include-if-even
  [coll x]
  (if (= (mod x 2) 0)
    (conj coll x)
    coll))

(reduce include-if-even [] [1 2 3 4]) ;=> [2 4]
```

In the previous example, the function `include-if-even` accepts two arguments: a collection `coll` and a number `x`. It then checks if `x` module 2 is 0, in which case `x` is an even number, and it includes this number into the collection `coll` if that's the case, returning this collection. This function is then used to collect all the even numbers from a given collection:

```clojure
(reduce include-if-even [] [1 2 3 4])
;=> (include-if-even [] 1) 
;=> (include-if-even [] 2) 
;=> (include-if-even [2] 3) 
;=> (include-if-even [2] 4) 
;=> [2 4] 
```

Note that in the previous example we must necessarily use three arguments in `reduce`, since our function needs a collection as its first argument. 

## Especial cases

Especial cases arise when we use an empty collection or a collection with only one item:

- If we apply `reduce` to an empty collection, `(reduce f val coll)` returns `(f val)`, and `(reduce f coll)` returns the result of applying `f` with no arguments. In this case, the function `f` must be able to use no arguments. 
- If we apply `reduce` to a collection with only one item, `(reduce f val coll)` returns `(f val x_1)`, i.e., the result of applying `f` to `val` and the first element `x_1` of `coll`. If used with only two arguments, `(f coll)` returns the only element found in `coll`, and `f` is not called.

## Using collections of functions

`reduce` accepts any type of collection, including one that contains functions. In that case, we will typically use three arguments `(reduce f val coll)`, and the function `f` applies the first function `g_1` from the collection to `val`, then the second function `g_2` to the result of the previous application, `(f (f val g_1) g_2)` and so on until all the functions are applied. While this is an interesting use case, we leave a detailed explanation to more advanced concepts in our syllabus.

