# Recursion

```clojure
(defn reverse-string [s]
  (loop [s s acc ""]
    (if (empty? s)
      acc
      (recur
        (rest s)
        (str (first s) acc)))))
```

In the community solutions, you can see the distinct group of solutions using recursion to solve the exercise.
They can look like the `loop`/`recur` example above or perhaps use the `letfn` macro as below.

```clojure
(defn reverse-string [s]
  (letfn [(rev [str acc]
    (if (empty? str)
      acc
      (rev (rest str) (str (first str) acc))))]
    (rev s "")))
```

While this approach can be found in solutions, it is not recommended.
Recursion without `recur` can lead to stack overflow. 

## Performance considerations

It is not necessarily bad to use recursion as in these two examples.
In fact, many other approaches use recursion behind the scenes as, for instance, `clojure.string/join` is implemented using recursion.
However, we should remember that strings are immutable, so code like the examples above will be inefficient regardless of `recur` use.
Instead, we should consider using the `StringBuilder` in the recursive function. For example like so:

```clojure
(defn reverse-string [s]
  (loop [s (into () s) sb (StringBuilder. "")]
    (if (empty? s)
      (.toString sb)
      (recur
       (rest s)
       (-> sb (.append (first s)))))))
```