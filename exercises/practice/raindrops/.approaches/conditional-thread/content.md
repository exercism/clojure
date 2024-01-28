# Conditional thread first

```clojure
(defn convert [number]
  (cond-> nil
    (zero? (rem number 3)) (str "Pling")
    (zero? (rem number 5)) (str "Plang")
    (zero? (rem number 7)) (str "Plong")
    :always (or (str number))))
```

Unlike `cond`, the matching condition doesn't stop evaluation of the further conditions.
Instead, every matched condition leads to an operation on a value output of which is passed down to the next matching condition.
This allows for very concise code that behaves just like the [step by step approach][step-by-step].

[step-by-step]: https://exercism.org/tracks/clojure/exercises/raindrops/approaches/step-by-step