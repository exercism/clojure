# Introduction

In its most basic form, the higher-order function `map` accepts two arguments: a function `f` and a sequence of elements `s`. It then applies `f` to each element of the sequence, and returns a list where the i-th element is the result of applying `f` to the i-th element of `s`:

```clojure
(map inc [1 2 3]) ; => (2 3 4)
```

The previous example applies function `inc`, which increases a number by one, to each element of the vector `[1 2 3]`, and returns the result of this application as a list `(2 3 4)`, where each element is the result of applying `inc` to the corresponding element of [1 2 3].

Let's see another example where we greet a given person with the message "Welcome":

```clojure
(defn say-welcome 
  [name]
  (str "Welcome " name "!"))

(map say-welcome ["Chris" "Jane" "Peter"]) ; => ("Welcome Chris!" "Welcome Jane!" "Welcome Peter!")
```