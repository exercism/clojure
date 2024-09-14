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

## Performance considerations

It is not necessarily bad to use recursion as shown in the example above.
In fact, many other approaches use recursion behind the scenes as, for instance, `clojure.string/join` is implemented using recursion.
However, we should remember that strings are immutable, so code like the above will be inefficient.
Instead, we should consider using the `StringBuilder` in the recursive function. For example, like so:

```clojure
(defn reverse-string [s]
  (loop [s (into () s) sb (StringBuilder. "")]
    (if (empty? s)
      (.toString sb)
      (recur
        (rest s)
        (-> sb (.append (first s)))))))
```