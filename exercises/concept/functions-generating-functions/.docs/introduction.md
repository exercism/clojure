# Introduction

**Higher-order functions** [in Clojure][clojure-higher-order-functions] are functions that either accept other functions as arguments or generate new functions as their result. We introduce here four important higher-order functions: `partial`, `comp`, `juxtp` and `memoize`.

## partial

[partial][clojure-api-partial] allows to fix some of the parameters of the original function by giving them specific values:

```clojure
(def inc-by-9 (partial + 9))
(inc-by-9 5)
; => 14
```

## comp

[comp][clojure-api-comp] can be used to create a composition of any number of functions we want to compose. Functions in the composition `(comp f1 f2 f3)` are evaluated from right to left: `f3` is evaluated on the input parameters, its output is passed as input to `f2` and its output is passed in turn to `f1`.

```clojure
(def six-times-result-sum 
  (comp (partial * 6) +))
(six-times-result-sum 3 2)
; = ((partial * 6) (+ 3 2))
; = (* 6 (+ 3 2))
; = 30
```

## memoize

[memoize][clojure-api-memoize] makes the function store previous results so that, given the same input, the *memoized* function returns the same result without having to recompute it again. 

```clojure
; original time-consuming function
(defn my-time-consuming-fn
    "Original, time-consuming function"
    [x]
    (Thread/sleep 2000)
    (* x 2)
)

; memoized function
(def my-memoized-fn 
  (memoize my-time-consuming-fn) )

; The first execution computes the result and stores it.
(time (my-memoized-fn 3))
; => "Elapsed time: 2001.364052 msecs"
; => 6

; Subsequent calls reuse the previous computation.
(time (my-memoized-fn 3))
; => "Elapsed time: 0.043701 msecs"
; => 6
```

## juxt

[juxt][clojure-api-juxt] applies the functions passed to it in left to right order, and ensembles the individual results in a vector: 

```clojure
; Compute the product of x by successive factors, from 2 to 5
((juxt (partial * 2) (partial * 3) (partial * 4) (partial * 5)) 10) ; => [20 30 40 50]
```

[clojure-higher-order-functions]: https://clojure.org/guides/higher_order_functions
[clojure-api-partial]: https://clojure.github.io/clojure/clojure.core-api.html#clojure.core/partial
[clojure-api-comp]: https://clojure.github.io/clojure/clojure.core-api.html#clojure.core/comp
[clojure-api-memoize]: https://clojuredocs.org/clojure.core/memoize
[clojure-api-juxt]: https://clojuredocs.org/clojure.core/juxt