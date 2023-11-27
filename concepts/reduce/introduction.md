# Introduction

The higher-order funcion `reduce` accepts either two or three arguments. When called with three arguments, `(reduce f val coll)` applies the function `f` to  `val` and the first element `x_1` of the collection `coll`: `(f val x_1)`. Then, it applies the function `f` to its own result and the second element `x_2` of the collection `coll`: `(f (f val x_1) x_2)`. Then again, it applies `f` to its previous result and the third element of `coll`, and so on until all the elements of `coll` are used. Let's see a typical example using `+` as our function:

```clojure
(reduce + 100 [1 2 3 4]) 
;=> (+ 100 1) 
;=> (+ 101 2)
;=> (+ 103 3)
;=> (+ 106 4)
;=> 110
```

When called with only two arguments, `(reduce f coll)` applies the function `f` to the two first elements `x_1` and `x_2` of the collection `coll`, then applies `f` to its own result and the third element `x_3` of `coll`, then again to its own result and the fourth element of `coll`, and so on until all the elements of `coll` are used:

```clojure
(reduce + [1 2 3 4]) 
;=> (+ 1 2) 
;=> (+ 3 3)
;=> (+ 6 4)
;=> 10
```

In all these cases, the function `f` must accept either two arguments or a variable number of arguments as happens in the previous case with function `+`. Let's see an example with a user-defined function:

```clojure
(defn include-if-even
  [coll x]
  (if (= (mod x 2) 0)
    (conj coll x)
    coll))
```

In the previous example, the function `include-if-even` accepts two arguments: a collection `coll` and a number `x`. It then checks if `x` module 2 is 0, in which case `x` is an even number. If that's the case, it includes this number into the collection `coll` and returns this collection. Otherwise, it returns the original collection. We can then apply `reduce` to collect all the even numbers from a given collection as follows:

```clojure
(reduce include-if-even [] [1 2 3 4])
;=> (include-if-even [] 1) 
;=> (include-if-even [] 2) 
;=> (include-if-even [2] 3) 
;=> (include-if-even [2] 4) 
;=> [2 4] 
```

Note that in the previous example we must necessarily pass three arguments to `reduce`: our function `include-if-even`, an initial collection `[]`, and a collection of numbers like `[1 2 3 4]`. The initial collection `[]` is necessary due to the fact that `include-if-even` needs it as its first argument.