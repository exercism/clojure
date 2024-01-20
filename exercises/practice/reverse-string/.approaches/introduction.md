# Introduction

[Strings][string] in Clojure are immutable which means they cannot be reversed in place.
Instead a new reversed string has to be created.

## String builder

One way to work around it is to use a string builder from the underlaying Java Virtual Machine.

```clojure
(defn reverse-string [string]
  (.toString
    (.reverse
      (StringBuilder. string))))
```

Let's look at the [string builder approach][string-builder-approach] and the shrotcut to it.

## It's a sequence

Beyond the above, there are great many different solutions, but in general, they depend on one fact.
[Strings][string] in Clojure are sequences of characters and there are many ways to reverse a sequence.

```clojure
(defn reverse-string [string]
  (apply str (reverse string)))
```

We discuss some variations in [It's a sequence approach][its-a-sequence-approach].

## Recursion

A distinct variation of the above is to process a sequence in a recursive function.

```clojure
(defn reverse-string [s]
  (loop [s s acc ""]
    (if (empty? s)
      acc
      (recur
        (rest s)
        (str (first s) acc)))))
```

Let's explore the [recursive approach][recursive-approach].

[string]: https://clojure-doc.org/articles/cookbooks/strings
[string-builder-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/string-builder
[its-a-sequence-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/its-a-sequence
[recursive-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/recursion