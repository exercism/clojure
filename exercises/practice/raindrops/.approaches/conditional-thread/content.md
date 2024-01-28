# Conditional thread first

```clojure
(defn convert [number]
  (cond-> nil
    (zero? (rem number 3)) (str "Pling")
    (zero? (rem number 5)) (str "Plang")
    (zero? (rem number 7)) (str "Plong")
    :always (or (str number))))
```

Unlike `cond`, the matching condition doesn't stop the evaluation of the further conditions.
Instead, every matched condition leads to an operation on a value with the output passed to the next operation dictated by the next matching condition.
This allows for very concise code that behaves just like the [step by step approach][step-by-step].

[step-by-step]: https://exercism.org/tracks/clojure/exercises/raindrops/approaches/step-by-step