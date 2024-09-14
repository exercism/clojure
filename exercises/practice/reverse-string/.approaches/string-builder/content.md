# String builder

```clojure
(defn reverse-string [s]
  (.toString
    (.reverse
      (StringBuilder. s))))
```

In Clojure, as in Java, strings are immutable.
It means that with every change we want to make to any string, we create a new string in memory.

String recreation can be very resource-intensive, especially when new strings are created in many steps.
This is a common problem, so Java provides the `StringBuilder` class, which holds characters as a collection,
allowing for modifications until we are ready to create the string by calling `toString()` method.

String builder has a built-in `reverse()` method, which we can use as shown above.
The complete approach is to initialise a `StringBuilder` with the string we want to reverse.
Then reverse it, and finally convert it back to string.

## The shortcut

Is accessing the underlying Java Virtual Machine and Java classes necessary?
Couldn't we just use the `clojure.string/reverse` function instead?

We could! This is the alternative way to reverse a string:

```clojure
(defn reverse-string [s]
  (clojure.string/reverse s))
```

In fact, at some level, we could consider both approaches to be equivalent.
Let's have a look at [the implementation of the `clojure.string/reverse`][implementation] function.

```clojure
(defn ^String reverse
  "Returns s with its characters reversed."
  {:added "1.2"}
  [^CharSequence s]
  (.toString (.reverse (StringBuilder. s))))
```

While there is a little bit more going on in the syntax, at its core, it is the same as the code at the top of this approach.

[implementation]: https://github.com/clojure/clojure/blob/08a2d9bdd013143a87e50fa82e9740e2ab4ee2c2/src/clj/clojure/string.clj#L48C3-L48C3
