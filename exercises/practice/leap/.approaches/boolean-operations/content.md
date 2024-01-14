# Boolean operations

```clojure
(defn- divides? [number divisor]
  (zero? (mod number divisor)))

(defn leap-year? [year]
  (and (divides? year 4)
    (or (not (divides? year 100))
      (divides? year 400))))
```

At the core of this approach, three checks are returning three boolean values.
We can use [Boolean logic](https://en.wikipedia.org/wiki/Boolean_algebra) to combine the results. Multiple variations are possible. One is shown above, but the below is also possible.

```clojure
(defn leap-year? [year]
  (or (divides? year 400)
    (and (not (divides? year 100))
      (divides? year 4))))
```

## Being explicit

The above examples use a private function `divides?` to be more explicit, to show what logical check is done rather than what operation is performed.
This is common in Clojure code, but it is also possible to do the checks directly.

```clojure
(defn leap-year? [year]
  (and (zero? year 4)
    (or (pos? year 100)
      (zero? year 400))))
```

In this example, in addition, instead of negating the second check, we check if the reminder from the division is greater than zero.

If the concern is that defining `divides?` adds confusion, because it is not known in the only place where it is used, `letfn` can be used. Here is another example.

```clojure
(defn leap-year? [year]
  (letfn [(is-multiple-of? [n] (zero? (mod year n)))]
    (and (is-multiple-of? 4)
      (or (not (is-multiple-of? 100))
        (is-multiple-of? 400)))))
```
