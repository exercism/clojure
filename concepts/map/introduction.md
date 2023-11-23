# Introduction

`map` is a so-called *higher-order function*, which accepts a previously defined function `f` as an argument, and a sequence of elements `s`, and applies `f` to each element of the sequence. As a result, it returns a list where the i-th element is the result of applying `f` to the i-th element of `s`:

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
