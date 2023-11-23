# Introduction

This concept provides a basic introduction to the `map` higher-order function, where we explain its most common usage form. Advanced mechanisms for using `map` are deferred to a later concept.

## Basic overview of map

Let us first provide a simplified explanation that covers the most common usage of `map`, and briefly explain later more elaborate usage forms.

In its most basic form, `map` accepts a previously defined function `f` as an argument, and a sequence of elements `s`, and applies `f` to each element of the sequence. As a result, it returns a list where the i-th element is the result of applying `f` to the i-th element of `s`:

```clojure
(map inc [1 2 3]) ; => '(2 3 4)
```

The previous example applies the clojure function `inc`, which increases a number by one, to each element of the vector `[1 2 3]`, and returns the result of this application as a list `'(2 3 4)`, where each element is the result of applying `inc` to the corresponding element of [1 2 3].

Let's see another example where we greet a given person with the message "Welcome":

```clojure
(defn say-welcome 
  [name]
  (str "Welcome " name "!"))

(map say-welcome ["Chris" "Jane" "Peter"]) ; => '("Welcome Chris!" "Welcome Jane!" "Welcome Peter!")
```

## Returning a lazy sequence

Previously we provided a simplified explanation of how `map` operates. In reality, `map` returns a so-called *lazy* sequence. Although an explanation of lazy sequences goes beyond the scope of this introduction, it basically means that the elements of the resulting list are not computed until they are actually needed. In other words, it is not until we actually use elements of this list (e.g., to print them or retrieve their value) that the function `f` passed to `map` is applied, and the value of each element is computed. This is handy when `f` is computationally expensive, and, for instance, we only end-up needing to retrieve some of the elements of the resulting list later in the program. For all intents and purposes however, in its most basic form we can simplify and consider that `map` just returns a list as described above.

## Using multiple collections

`map` allows multiple collections to be passed as input. If the number of collections we pass is `n`, the function `f` will receive `n` elements, one for each collection in the list. The result is a list where the i-th element is obtained by applying `f` to the i-th element of each collection.

