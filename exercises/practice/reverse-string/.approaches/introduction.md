# Introduction

[Strings][string] in Clojure are immutable, which means we cannot reverse them in place.
Instead, typically, we will create a new string while reversing the original one.

## String builder

One way to work around it is to use a string builder from the underlying Java Virtual Machine.

```clojure
(defn reverse-string [s]
  (.toString
    (.reverse
      (StringBuilder. s))))
```

Let's look at the [string builder approach][string-builder-approach] and a shortcut to it.

## It's a sequence

Beyond the above, there are a great many different solutions, but in general, they depend on two facts.
[Strings][string] in Clojure are Java [string][java-string]s.
Many core Clojure functions call `seq` on their arguments automatically converting a string into a seqence of characters.
And there are many ways to reverse a sequence.

```clojure
(defn reverse-string [s]
  (apply str (reverse s)))
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
[java-string]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[string-builder-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/string-builder
[its-a-sequence-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/its-a-sequence
[recursive-approach]: https://exercism.org/tracks/clojure/exercises/reverse-string/approaches/recursion