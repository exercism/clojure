# Introduction

In its most basic form, the higher-order function `map` accepts two arguments: a function `f` and a collection `coll`.
It applies `f` to each element of `coll`, returning a list of the results in the same order.

```clojure
(map inc [1 2 3]) ; => (2 3 4)
```

The previous example applies the function `inc`, which increases a number by one, to each element of the vector `[1 2 3]`, and returns the result as the list `(2 3 4)`, where each element is the result of applying `inc` to the corresponding element of [1 2 3].

Let's see another example where we greet someone with the message "Welcome":

```clojure
(defn say-welcome 
  [name]
  (str "Welcome " name "!"))

(map say-welcome ["Chris" "Jane" "Peter"]) ; => ("Welcome Chris!" "Welcome Jane!" "Welcome Peter!")
```