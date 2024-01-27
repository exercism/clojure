# Introduction

Raindrop sounds depends on three conditions that can be true or false.
This means there are only eight possible outcomes.
We can check them all with `cond`.

```clojure
(defn convert [num]
  (cond
    (zero? (rem num (* 3 5 7))) "PlingPlangPlong"
    (zero? (rem num (* 5 7))) "PlangPlong"
    (zero? (rem num (* 3 7))) "PlingPlong"
    (zero? (rem num (* 3 5))) "PlingPlang"
    (zero? (rem num 7)) "Plong"
    (zero? (rem num 5)) "Plang"
    (zero? (rem num 3)) "Pling"
    :else (str num)))
```

This is the [check every possibility approach][check-every-posibility].

[check-every-posibility]: https://exercism.org/tracks/clojure/exercises/raindrops/approaches/check-every-possibility