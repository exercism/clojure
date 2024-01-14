# Flow control expressions

```clojure
(defn- divides? [number divisor]
  (zero? (mod number divisor)))

(defn leap-year? [year]
  (if (divides? year 100)
    (divides? year 400)
    (divides? year 4)))
```

## If

Clojure provides `if`, `cond`, `condp` and `case` expressions to control the flow of the program.

The `if` doesn't have an `else if` option, but it is not necessary here.
We can use `if` once to check if the year is divisible by 100.
If it is, then whether it is a leap year or not depends if it is divisible by 400.
If it is not, then whether it is a leap year or not depends if it is divisible by 4.

```clojure
(defn leap-year? [year]
  (if (divides? year 100)
    (divides? year 400)
    (divides? year 4)))
```

## Cond

Another option is `cond` which allows for evaluating multiple conditions, similar to `else if` in other languages.

```clojure
(defn leap-year? [year]
  (cond
    (divides? year 400) true
    (divides? year 100) false
    (divides? year 4) true
    :else false))
```

A very similar alternative is to use the `condp` macro, which takes a predicate and applies it to a series of test value and expected result pairs.

```clojure
(defn leap-year? [year]
  (condp #(zero? (mod %2 %1)) year
    400 true
    100 false
    4   true
        false))
```

When using both `cond` and `condp,` the other matters as the first true condition stops evaluating the list and determines the result.

## Case

Finally, it is also possible to use `case`, but this solution is not popular.

```clojure
(defn leap-year? [year]
  (case [(divides? year 400)
         (divides? year 100)
         (divides? year 4)
         ]
    [true true true]   true
    [false true true]  false
    [false false true] true
                       false))
```