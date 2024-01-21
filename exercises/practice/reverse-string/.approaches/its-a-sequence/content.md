# It's a sequence

```clojure
(defn reverse-string [string]
  (apply str (reverse string)))
```

In Clojure, strings are sequences of characters.
["Most of Clojure's core library treats collections and sequences the same way"][collections-and-sequences].
It follows that we can use any method to reverse a sequence or a collection to reverse a string.

There will be three stops in this group of approaches:

1. Convert a string to a sequence or a collection. (Is usually implicit, part of the next step).
2. Reverse the sequence or a collection.
3. Convert the sequence of characters back into a string. (It has to be explicit).

## Reversing

Here are a few options for reversing a sequence of characters.
```clojure
(reverse s)
```
The above is self-explanatory.
```clojure
(into () s)
```
This takes one character at a time from `s` and adds it to a sequence.
Because in Clojure, by default, new elements are added to the beginning of the list,
`into` reverses the character at the same time as changing a string into an explicit sequence.

The more explicit verbose version of this operation could be something like this:
```clojure
(reduce conj () s)
```

## Converting back to a string

There are many options here, too.

```clojure
(apply str (reverse s))
(reduce str (reverse s))
(clojure.string/join (reverse s))
```

## A single step version

We also have an option to combine all three operations into a single function call:

```clojure
(defn reverse-string [s] ;; <- arglist goes here
  (reduce #(str %2 %1) "" s))
```

## Which one to use?

I'd suggest using the one that is the most readable to you.

[collections-and-sequences]: https://clojure-doc.org/articles/language/collections_and_sequences/