# Introduction

Raindrop sounds depends on three conditions that can be true or false.
This means there are only eight possible outcomes.

## Check every possibility

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

## Step by step

We can also make the three checks sequentially and concatenate the results.

```clojure
(defn convert [num]
  (let [pling (if (zero? (rem num 3)) "Pling" "")
        plang (if (zero? (rem num 5)) "Plang" "")
        plong (if (zero? (rem num 7)) "Plong" "")
        sound (str pling plang plong)]
      (if (empty? sound) (str num) sound)))
```

This [step by step approach][step-by-step] reduces the number of operations as each check is performed only once.

[check-every-posibility]: https://exercism.org/tracks/clojure/exercises/raindrops/approaches/check-every-possibility
[step-by-step]: https://exercism.org/tracks/clojure/exercises/raindrops/approaches/step-by-step